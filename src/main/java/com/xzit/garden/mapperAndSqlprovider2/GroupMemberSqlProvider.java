package com.xzit.garden.mapperAndSqlprovider2;

import com.xzit.garden.bean.entity.*;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class GroupMemberSqlProvider {

    public String insertSelective(GroupMember record) {
        BEGIN();
        INSERT_INTO("group_member");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getGroupid() != null) {
            VALUES("groupId", "#{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getMemberid() != null) {
            VALUES("memberId", "#{memberid,jdbcType=INTEGER}");
        }
        
        if (record.getPostid() != null) {
            VALUES("postId", "#{postid,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            VALUES("state", "#{state,jdbcType=INTEGER}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(GroupMember record) {
        BEGIN();
        UPDATE("group_member");
        
        if (record.getGroupid() != null) {
            SET("groupId = #{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getMemberid() != null) {
            SET("memberId = #{memberid,jdbcType=INTEGER}");
        }
        
        if (record.getPostid() != null) {
            SET("postId = #{postid,jdbcType=INTEGER}");
        }
        
        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        
        return SQL();
    }
}