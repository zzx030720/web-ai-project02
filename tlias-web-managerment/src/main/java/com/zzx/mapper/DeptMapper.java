package com.zzx.mapper;

import com.zzx.pojo.Dept;
import org.apache.ibatis.annotations.*;

import java.util.List;

//MyBatis注解：告诉MyBatis为这个接口自动生成实现类，并交给Spring容器管理，service中才能注入使用
@Mapper //自动创建实现类对象，并放入IOC容器中
public interface DeptMapper {
    /**
     * 查询所有部门
     * @return
     */
//    @Results({
//            @Result(column = "create_time" , property = "createTime"),
//            @Result(column = "update_time" , property = "updateTime")
//    })


//    @Select("select id, name, create_time createTime, update_time updateTime from dept order by update_time desc ")
    //MyBatis注解：执行下面的SELECT语句，把查询结果自动封装成Dept对象列表
    @Select("select id, name, create_time, update_time from dept order by update_time desc ")
    List<Dept> findAll();

    /**
     * 根据id删除部门
     * @param id
     */
    //MyBatis注解：执行DELETE语句删除部门，#{id}是占位符，防止SQL注入
    @Delete("delete from dept where id = #{id}")
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    //MyBatis注解：执行INSERT语句新增部门，#{name}等会从dept对象的属性里取值
    @Insert("insert into dept(name, create_time, update_time) values(#{name}, #{createTime}, #{updateTime})")
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    //MyBatis注解：执行SELECT语句，把查到的那行数据封装成一个Dept对象返回
    @Select("select id, name, create_time, update_time from dept where id = #{id}")
    Dept getById(Integer id);

    /**
     * 修改部门
     */
    //MyBatis注解：执行UPDATE语句，根据id修改部门名称和更新时间
    @Update("update dept set name = #{name}, update_time = #{updateTime} where id = #{id}")
    void updateById(Dept dept);
}
