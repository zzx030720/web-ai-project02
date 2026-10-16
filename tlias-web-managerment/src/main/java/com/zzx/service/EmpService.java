package com.zzx.service;

import com.zzx.pojo.Emp;
import com.zzx.pojo.EmpQueryParam;
import com.zzx.pojo.LoginInfo;
import com.zzx.pojo.PageResult;

import java.util.List;

public interface EmpService {
    /**
     * 分页查询
     * @param page
     * @param pageSize
     * @return
     */
//    PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                 LocalDate begin,LocalDate end);
    PageResult<Emp> page(EmpQueryParam  param);

    void save(Emp emp);

    void delete(List<Integer> ids);

    /**
     * 根据ID获取员工
     * @param id
     * @return
     */
    Emp getInfo(Integer id);

    void update(Emp emp);

    /**
     * 获取所有员工
     * @return
     */
    List<Emp> listAll();

    /**
     * 登录
     * @param emp
     * @return
     */
    LoginInfo login(Emp emp);
}
