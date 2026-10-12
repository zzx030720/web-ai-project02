package com.zzx.mapper;

import com.zzx.pojo.Emp;
import com.zzx.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

//MyBatis注解：告诉MyBatis为这个接口自动生成实现类，并交给Spring容器管理，service中才能注入使用
@Mapper
public interface EmpMapper {

//    /**
//     * 获取总员工数量
//     * @return
//     */
//    @Select("select count(*) from emp e left join dept d on e.dept_id = d.id")
//    public Long getEmpCount();
//
//    /**
//     * 分页查询
//     * @return
//     */
//    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id " +
//            "order by e.update_time desc limit #{start},#{pageSize}")
//    public List<Emp> list(Integer start, Integer pageSize);

    //    @Select("select e.*,d.name deptName from emp e left join dept d on e.dept_id = d.id order by e.update_time desc ")
//    public List<Emp> list(String name, Integer gender,
//                          LocalDate begin, LocalDate end);
    public List<Emp> list(EmpQueryParam param);

    /**
     * 添加员工
     *
     * @param emp
     */
    //MyBatis注解：配合下面的INSERT，执行后把数据库自增的主键id回填到emp对象的id属性上，
    //这样后续保存工作经历时才能通过 emp.getId() 拿到刚插入的员工id
    @Options(useGeneratedKeys = true, keyProperty = "id")
    //MyBatis注解：执行INSERT语句新增员工，#{username}等会从emp对象的属性里取值
    @Insert("insert into emp(username,name,gender,phone,job,salary,image,entry_date,dept_id,create_time,update_time) " +
            "values(#{username},#{name},#{gender},#{phone},#{job},#{salary},#{image},#{entryDate},#{deptId},#{createTime},#{updateTime})")
    void insert(Emp emp);

    /**
     * 根据ID批量删除员工
     *
     * @param ids
     */
    void deleteById(List<Integer> ids);
}
