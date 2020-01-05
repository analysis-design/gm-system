package com.xzit.garden.mapper;

import com.xzit.garden.bean.entity.ResSchPlan;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface ResSchPlanMapper {

    @Select("select * from res_sch_plan order by allocatedTime desc limit #{page}, #{limit}")
    List<ResSchPlan> findPage(@Param("page") int page, @Param("limit") Integer limit);

    @Select("select count(*) from res_sch_plan")
    int countResSchPlan();

    @Select("select * from res_sch_plan where id=#{rspId}")
    ResSchPlan findById(Long rspId);

    @Insert("insert into res_sch_plan (implPlanId, resId, resNum, planState, allocatedTime, description)" +
            " values (#{implPlanId}, #{resId}, #{resNum}, #{planState}, #{allocatedTime}, #{description})")
    void add(ResSchPlan resSchPlan);

    @Update("update res_sch_plan " +
            "set implPlanId = #{implPlanId}, resId = #{resId}, resNum = #{resNum}, " +
            "allocatedTime = #{allocatedTime}, description = #{description where id = #{id}")
    void updateById(ResSchPlan resSchPlan);

    @Delete("delete from res_sch_plan where id=#{rspId}")
    void deleteById(Long rspId);

    @Delete("<script>" +
            "delete from res_sch_plan where id in " +
            "<foreach collection=\"idList\"  item=\"item\" open=\"(\" separator=\",\" close=\")\">" +
            "   #{item} " +
            "</foreach>" +
            "</script>")
    void deleteByIdList(@Param("idList") List<Long> resSchPlanIdList);
}
