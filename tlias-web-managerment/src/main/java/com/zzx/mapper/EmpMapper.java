package com.zzx.mapper;

import com.zzx.pojo.Emp;
import com.zzx.pojo.EmpQueryParam;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Options;

import java.util.List;

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
    @Options(useGeneratedKeys = true, keyProperty = "id")
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
