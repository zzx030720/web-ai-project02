package com.zzx.service;

import com.zzx.pojo.PageResult;
import com.zzx.pojo.Student;
import com.zzx.pojo.StudentQueryParam;

public interface StudentService {
    /**
     * 分页查询
     */
    PageResult<Student> page(StudentQueryParam queryParam);

    /**
     * 新增
     */
    void add(Student student);

    /**
     * 根据ID查询
     */
    Student get(Integer id);

    /**
     * 修改
     */
    void update(Student student);

    /**
     * 删除
     */
    void delete(Integer id);

    /**
     * 违纪处理
     */
    void violation(Integer id, Integer score);
}
