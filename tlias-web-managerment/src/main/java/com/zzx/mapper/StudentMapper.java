package com.zzx.mapper;

import com.zzx.pojo.Student;
import com.zzx.pojo.StudentQueryParam;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper {
    /**
     * 根据班级ID查询学生数量
     */
    @Select("SELECT COUNT(*) FROM student WHERE clazz_id = #{clazzId}")
    Integer countByClazzId(Integer clazzId);

    /**
     * 分页查询
     */
    List<Student> page(StudentQueryParam queryParam);

    /**
     * 新增
     */
    @Insert("INSERT INTO student (name, no,gender,phone,id_card,is_college,address,degree,graduation_date,clazz_id,create_time,update_time) " +
            "VALUES (#{name}, #{no}, #{gender}, #{phone}, #{idCard}, #{isCollege}, #{address}, #{degree}, #{graduationDate}, #{clazzId}, #{createTime}, #{updateTime})")
    void add(Student student);

    /**
     *  根据ID查询学生数据
     */
    @Select("select * from student where id = #{id}")
    Student get(Integer id);

    /**
     * 修改
     */
    @Update("UPDATE student SET name = #{name}, no = #{no}, gender = #{gender}, phone = #{phone}, id_card = #{idCard}, is_college = #{isCollege}, address = #{address}, degree = #{degree}, graduation_date = #{graduationDate}, clazz_id = #{clazzId}, update_time = #{updateTime} WHERE id = #{id}")
    void update(Student student);

    /**
     * 删除
     */
    @Delete("DELETE FROM student WHERE id = #{id}")
    void delete(Integer id);

    /**
     * 违纪处理
     * @param id
     * @param score
     */
    @Update("UPDATE student SET violation_score = violation_score + #{score} , violation_count = violation_count + 1 WHERE id = #{id}")
    void violation(Integer id, Integer score);


    /**
     * 查询学生数量数据
     */
    List<Map<String, Object>> countStudentCountData();

    /**
     * 查询不同学历人数
     * @return
     */
    List<Map> countDegreeData();

}
