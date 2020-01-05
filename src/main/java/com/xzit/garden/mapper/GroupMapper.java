package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.GroupMember;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface GroupMapper {

    @Select("select * from `group` limit #{page}, #{limit}")
    List<Group> findAllPage(@Param("page") Integer page, @Param("limit") Integer limit);

    @Select("select count(*) from `group`")
    int countGroup();

    @Select("select * from `group` where id=#{groupId}")
    Group findById(Long groupId);

    @Select("select * from `group` where name=#{groupName}")
    Group findByGroupName(String groupName);

    @Insert("insert into `group` (name, state, createTime, leaderId, type, description) " +
            "values (#{name}, #{state}, #{createTime}, #{leaderId}, #{type}, #{description});")
    @Options(useGeneratedKeys = true, keyProperty = "id", keyColumn = "id")
    void add(Group group);

    @Delete("delete from `group` where id=#{groupId}")
    void deleteById(Long groupId);

    @Update("update `group` set name = #{name}, state = #{state}, " +
            "dismissTime = #{dismissTime}, leaderId = #{leaderId}, type = #{type}, description = #{description} " +
            "where id = #{id}")
    void updateById(Group group);

    @Select("select * from group_member where groupId=#{groupId}")
    List<GroupMember> findMemberById(Long groupId);

    @Select("select * from group_member where id=#{groupMemberId}")
    GroupMember findGroupMemberById(Long groupMemberId);

    @Select("select * from group_member where groupId=#{groupId} and memberId=#{memberId}")
    GroupMember findGroupMemberByGroupIdAndMemberId(@Param("groupId") Long groupId, @Param("memberId") Long memberId);

    @Insert("insert into group_member (groupId, memberId, postId, state) " +
            "values (#{groupId}, #{memberId}, #{postId}, #{state})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    void addGroupMember(GroupMember groupMember);

    @Delete("delete from group_member where id=#{groupMemberId}")
    void deleteGroupMemberById(Long groupMemberId);

    @Update("update group_member set postId=#{postId} where id=#{id}")
    void updateGroupMember(GroupMember groupMember);

    @Select("select * from `group` where state=0")
    List<Group> findNotImplAll();
}
