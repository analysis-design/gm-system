package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.Group;
import com.xzit.garden.bean.entity.GroupMember;
import com.xzit.garden.bean.entity.MaintenancePlan;
import com.xzit.garden.bean.entity.Project;

import static org.apache.ibatis.jdbc.SqlBuilder.*;

public class MaintenancePlanSqlProvider {

    public String insertSelective(MaintenancePlan record) {
        BEGIN();
        INSERT_INTO("maintenance_plan");
        
        if (record.getId() != null) {
            VALUES("id", "#{id,jdbcType=INTEGER}");
        }
        
        if (record.getProjectid() != null) {
            VALUES("projectId", "#{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            VALUES("startTime", "#{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            VALUES("expectedEndTime", "#{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            VALUES("actualEndTime", "#{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroupid() != null) {
            VALUES("groupId", "#{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            VALUES("purpose", "#{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanstate() != null) {
            VALUES("planState", "#{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            VALUES("description", "#{description,jdbcType=VARCHAR}");
        }
        
        return SQL();
    }

    public String updateByPrimaryKeySelective(MaintenancePlan record) {
        BEGIN();
        UPDATE("maintenance_plan");
        
        if (record.getProjectid() != null) {
            SET("projectId = #{projectid,jdbcType=INTEGER}");
        }
        
        if (record.getStarttime() != null) {
            SET("startTime = #{starttime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getExpectedendtime() != null) {
            SET("expectedEndTime = #{expectedendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getActualendtime() != null) {
            SET("actualEndTime = #{actualendtime,jdbcType=TIMESTAMP}");
        }
        
        if (record.getGroupid() != null) {
            SET("groupId = #{groupid,jdbcType=INTEGER}");
        }
        
        if (record.getPurpose() != null) {
            SET("purpose = #{purpose,jdbcType=VARCHAR}");
        }
        
        if (record.getPlanstate() != null) {
            SET("planState = #{planstate,jdbcType=INTEGER}");
        }
        
        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }
        
        WHERE("id = #{id,jdbcType=INTEGER}");
        return SQL();
    }

    public String updateGroupByPrimaryKeySelective(Group record) {
        BEGIN();
        UPDATE(" `group` ");

        if (record.getName() != null) {
            SET("name = #{name,jdbcType=VARCHAR}");
        }

        if (record.getState() != null) {
            SET("state = #{state,jdbcType=INTEGER}");
        }

        if (record.getCreateTime() != null) {
            SET("createTime = #{createtime,jdbcType=TIMESTAMP}");
        }

        if (record.getLeaderId() != null) {
            SET("leaderId = #{leaderid,jdbcType=INTEGER}");
        }

        if (record.getType() != null) {
            SET("type = #{type,jdbcType=INTEGER}");
        }

        if (record.getDescription() != null) {
            SET("description = #{description,jdbcType=VARCHAR}");
        }

        WHERE("id = #{id,jdbcType=INTEGER}");

        return SQL();
    }

}