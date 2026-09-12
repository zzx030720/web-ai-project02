package com.zzx.service;

import com.zzx.pojo.Dept;

import java.util.List;

public interface DeptService {

    /**
     * 查询所有部门
     * @return
     */
    List<Dept> findAll();

    /**
     * 删除部门
     * @param id
     */
    void deleteById(Integer id);

    /**
     * 添加部门
     * @param dept
     */
    void addDept(Dept dept);

    /**
     * 根据id查询部门
     * @param id
     * @return
     */
    Dept getById(Integer id);

    /**
     * 修改部门
     * @param dept
     */
    void updateById(Dept dept);
}
