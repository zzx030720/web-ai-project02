package com.zzx.mapper;

import com.zzx.pojo.Emp;
import com.zzx.pojo.EmpQueryParam;
import com.zzx.pojo.LoginInfo;
import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

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
    /**
     * 分页条件查询员工列表（对应 EmpMapper.xml 中 <select id="list"> 的动态SQL）
     *
     * @param param 查询条件载体（姓名、性别、入职日期范围等）
     */

    //MyBatis规则：方法只接收一个对象参数时，XML中的 #{xxx} 和 <if test="xxx != null"> 会自动
    //到该对象的属性里取值，即 #{name} 实际取的是 param.getName()，#{gender} 取 param.getGender()，
    //#{begin}/#{end} 取 param.getBegin()/getEnd()。所以虽然XML里没有出现 param 这个名字，
    //这个参数实际上就是动态SQL所有条件的数据来源，删掉它条件查询就取不到值了。
    //把多个散参数封装成一个对象的好处：后续新增查询条件只需给 EmpQueryParam 加属性，方法签名不用改。
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

    /**
     * 根据ID获取员工
     * @param id
     * @return
     */
    Emp getById(Integer id);

    /**
     * 根据ID修改员工
     * @param emp
     */
    void updateById(Emp emp);

    /**
     * 统计各个职位的员工人数
     */

    List<Map<String,Object>> countEmpJobData();

    /**
     * 统计员工性别信息
     */
    @MapKey("name")
    List<Map> countEmpGenderData();

    /**
     * 查询员工列表
     */
    @Select("select * from emp")
    List<Emp> listAll();

    /**
     * 根据部门id查询员工数量
     * @param id
     * @return
     */
    @Select("SELECT COUNT(*) FROM emp WHERE dept_id = #{id}")
    Integer getEmpCountByDeptId(Integer id);

    /**
     * 统计各个班级的学生人数
     */
    List<Map<String, Object>> countStudentCountData();

    /**
     * 登录
     */
    @Select("select * from emp where username = #{username} and password = #{password}")
    Emp getUsernameAndPassword(Emp emp);
}
