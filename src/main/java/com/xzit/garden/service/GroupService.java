package com.xzit.garden.service;

import com.xzit.garden.bean.dto.GroupDto;
import com.xzit.garden.bean.dto.GroupMemberDto;
import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.GroupMember;
import com.xzit.garden.bean.model.PageModel;

import java.util.List;


public interface GroupService {
    /**
     * 查询分页的工程组列表信息
     *
     * @param pageModel 分页模型对象
     * @return 工程组信息列表
     */
    List<GroupDto> getPageUserList(PageModel<List<GroupDto>> pageModel);

    /**
     * 根据工程组id查询工程组
     *
     * @param groupId 工程组id
     * @return 工程组信息
     */
    Group getById(Long groupId);

    /**
     * 添加工程组信息
     *
     * @param group 工程组信息
     */
    void addGroup(Group group);

    /**
     * 根据工程组id删除工程组
     *
     * @param groupId 工程组id
     * @return 删除的工程组信息
     */
    Group deleteById(Long groupId);

    /**
     * 批量删除工程组信息
     *
     * @param groupIdList 要删除的工程组id
     * @return 删除完成工程组信息列表
     */
    List<Group> deleteAllById(List<Long> groupIdList);

    /**
     * 根据工程组id跟新工程组信息
     *
     * @param group 更新的工程组信息
     */
    void updateById(Group group);

    /**
     * 根据工程组id获取工程组成员
     *
     * @param pageModel 分页对象
     * @param groupId   工程组id
     * @return 工程组成员信息列表
     */
    List<GroupMemberDto> getGroupMemberList(PageModel<List<GroupMemberDto>> pageModel, Long groupId);

    /**
     * 根据工程组成员id获取工程组成员
     *
     * @param groupMemberId 工程组成员id
     * @return 工程组成员信息
     */
    GroupMember getGroupMemberById(Long groupMemberId);

    /**
     * 添加工程组成员信息
     *
     * @param groupMember 工程组成员信息
     */
    void addGroupMember(GroupMember groupMember);

    /**
     * 根据工程组成员id删除工程组成员信息
     *
     * @param groupMemberId 工程组成员id
     * @return 删除的工程组成员
     */
    GroupMember deleteGroupMemberById(Long groupMemberId);

    /**
     * 更新工程组成员
     * @param groupMember 工程组成员信息
     */
    void updateGroupMemberById(GroupMember groupMember);
}
