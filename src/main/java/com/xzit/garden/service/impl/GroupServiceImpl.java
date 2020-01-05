package com.xzit.garden.service.impl;

import com.xzit.garden.bean.dto.GroupDto;
import com.xzit.garden.bean.dto.GroupMemberDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.GroupMember;
import com.xzit.garden.bean.entity.Post;
import com.xzit.garden.bean.entity.Staff;
import com.xzit.garden.bean.model.PageModel;
import com.xzit.garden.exception.ObjectNotFoundException;
import com.xzit.garden.exception.ObjectAlreadyExistException;
import com.xzit.garden.mapper.GroupMapper;
import com.xzit.garden.mapper.PostMapper;
import com.xzit.garden.mapper.StaffMapper;
import com.xzit.garden.service.GroupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class GroupServiceImpl implements GroupService {

    @Autowired
    private GroupMapper groupMapper;

    @Autowired
    private StaffMapper staffMapper;

    @Autowired
    private PostMapper postMapper;

    @Override
    public List<GroupDto> getPageUserList(PageModel<List<GroupDto>> pageModel) {

        int page = pageModel.getPage() - 1;
        List<Group> groupList = groupMapper.findAllPage(page * pageModel.getLimit(), pageModel.getLimit());
        int count = groupMapper.countGroup();
        pageModel.setCount(count);

        if (groupList == null)
            groupList = new ArrayList<>();

        return getUserDtoList(groupList);
    }

    @Override
    public Group getById(Long groupId) {
        Group group = groupMapper.findById(groupId);
        if (group == null)
            throw new ObjectNotFoundException("工程组" + groupId + "不存在");
        if (group.getDismissTime() != null)
            group.setDismissFlag(true);

        return group;
    }

    @Transactional
    @Override
    public void addGroup(Group group) {
        String groupName = group.getName();
        validateExistGroup(groupName);

        validateExistLeader(group.getLeaderId());

        group.setState(0);
        group.setCreateTime(new Date());
        groupMapper.add(group);
    }

    private void validateExistGroup(String groupName) {
        Group temp = groupMapper.findByGroupName(groupName);
        if (temp != null)
            throw new ObjectAlreadyExistException("工程组" + groupName + "已存在");
    }

    private void validateExistLeader(Long leaderId) {
        Staff staff = staffMapper.findById(leaderId);
        if (staff == null)
            throw new ObjectNotFoundException("负责人编号" + leaderId + "不存在");
    }

    @Transactional
    @Override
    public Group deleteById(Long groupId) {
        Group group = getById(groupId);

        groupMapper.deleteById(groupId);
        return group;
    }

    @Override
    public List<Group> deleteAllById(List<Long> groupIdList) {

        return null;
    }

    @Transactional
    @Override
    public void updateById(Group group) {
        Group temp = getById(group.getId());
        Group temp2 = groupMapper.findByGroupName(group.getName());
        if (temp2 != null && !group.getName().equals(temp2.getName()))
            throw new ObjectAlreadyExistException("工程组" + group.getName() + "已存在");

        validateExistLeader(group.getLeaderId());

        group.setState(temp.getState());
        group.setDismissTime(temp.getDismissTime());

        if (group.isDismissFlag() && group.getState() != 0)
            throw new RuntimeException("工程组的状态为" + (group.getState() == 1 ?
                    "施工" : group.getState() == 2 ? "已加入实施计划" :
                    group.getState() == 3 ? "解除" : "空闲") + "，不能解除");

        if (group.isDismissFlag()) {
            group.setDismissTime(null);
            group.setState(0);
        }

        groupMapper.updateById(group);
    }

    @Override
    public List<GroupMemberDto> getGroupMemberList(PageModel<List<GroupMemberDto>> pageModel, Long groupId) {
        Group group = groupMapper.findById(groupId);
        if (group == null)
            throw new ObjectNotFoundException("工程组" + groupId + "不存在");

        List<GroupMember> groupMemberList = groupMapper.findMemberById(groupId);
        if (groupMemberList == null) groupMemberList = new ArrayList<>();

        pageModel.setCount(groupMemberList.size());
        return getGroupMemberDtoList(group, groupMemberList);
    }

    @Override
    public GroupMember getGroupMemberById(Long groupMemberId) {
        GroupMember groupMember = groupMapper.findGroupMemberById(groupMemberId);
        if (groupMember == null)
            throw new ObjectNotFoundException("工程组成员编号" + groupMemberId + "不存在");
        return groupMember;
    }

    @Transactional
    @Override
    public void addGroupMember(GroupMember groupMember) {
        Long memberId = groupMember.getMemberId();
        Staff staff = staffMapper.findById(memberId);
        if (staff == null)
            throw new ObjectNotFoundException("成员编号" + memberId + "不存在");

        Long postId = groupMember.getPostId();
        Post post = postMapper.findById(postId);
        if (post == null)
            throw new ObjectNotFoundException("职称编号" + postId + "不存在");

        Long groupId = groupMember.getGroupId();
        Group group = groupMapper.findById(groupId);
        if (group == null)
            throw new ObjectNotFoundException("工程组编号" + groupId + "不存在");

        GroupMember temp = groupMapper.findGroupMemberByGroupIdAndMemberId(groupId, memberId);
        if (temp != null)
            throw new ObjectAlreadyExistException("工程组" + groupId + "的成员" + memberId + "已存在");

        groupMember.setState(1);
        groupMapper.addGroupMember(groupMember);
    }

    @Transactional
    @Override
    public GroupMember deleteGroupMemberById(Long groupMemberId) {
        GroupMember groupMember = getGroupMemberById(groupMemberId);

        groupMapper.deleteGroupMemberById(groupMemberId);
        return groupMember;
    }

    @Transactional
    @Override
    public void updateGroupMemberById(GroupMember groupMember) {
        GroupMember temp = getGroupMemberById(groupMember.getId());
        Post post = postMapper.findById(groupMember.getPostId());
        if (post == null)
            throw new ObjectNotFoundException("职称编号" + groupMember.getPostId() + "不存在");

        groupMember.setId(temp.getId());
        groupMember.setGroupId(temp.getGroupId());
        groupMember.setMemberId(temp.getMemberId());
        groupMapper.updateGroupMember(groupMember);
    }

    private List<GroupMemberDto> getGroupMemberDtoList(Group group, List<GroupMember> groupMemberList) {
        List<GroupMemberDto> dtoList = new ArrayList<>();
        for (GroupMember groupMember : groupMemberList) {
            GroupMemberDto groupMemberDto = new GroupMemberDto();
            groupMemberDto.setId(groupMember.getId());
            groupMemberDto.setGroup(group);
            groupMemberDto.setStaff(staffMapper.findById(groupMember.getMemberId()));
            groupMemberDto.setPost(postMapper.findById(groupMember.getPostId()));
            dtoList.add(groupMemberDto);
        }

        return dtoList;
    }

    private List<GroupDto> getUserDtoList(List<Group> groupList) {
        List<GroupDto> groupDtoList = new ArrayList<>();

        for (Group group : groupList) {
            Staff leader = staffMapper.findById(group.getLeaderId());
            GroupDto dto = new GroupDto(group);
            dto.setLeader(leader);
            groupDtoList.add(dto);
        }

        return groupDtoList;
    }
}
