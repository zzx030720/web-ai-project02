package com.zzx.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {
    /**
     * 根据班级ID查询学生数量
     */
    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{clazzId}")
    Integer countByClazzId(Integer clazzId);
}
