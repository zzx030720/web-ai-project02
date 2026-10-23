package com.zzx.mapper;

import com.zzx.pojo.Clazz;
import com.zzx.pojo.ClazzQueryParam;
import org.apache.ibatis.annotations.*;


import java.util.List;

@Mapper
public interface ClazzMapper {
    /**
     * 分页查询
     */
    List<Clazz> list(ClazzQueryParam param);
    /**
     * 添加班级,先存数字、读的时候再 case when 翻译
     */
    @Insert("insert into clazz (name, room,master_id, begin_date, end_date,subject,create_time, update_time) " +
            "values (#{name}, #{room}, #{masterId}, #{beginDate}, #{endDate}, #{subject}, #{createTime}, #{updateTime})")
    void save(Clazz clazz);

    /**
     * 根据ID查询
     */
    @Select("select * from clazz where id = #{id}")
    Clazz getById(Integer id);

    /**
     * 修改班级信息
     */
    @Update("update clazz set name = #{name}, room = #{room}, master_id = #{masterId}, begin_date = #{beginDate}, end_date = #{endDate}, subject = #{subject}, update_time = #{updateTime} where id = #{id}")
    void update(Clazz clazz);

    /**
     * 删除班级
     */
    @Delete("delete from clazz where id = #{id}")
    void delete(Integer id);
}
