package com.zzx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzx.mapper.StudentMapper;
import com.zzx.pojo.PageResult;
import com.zzx.pojo.Student;
import com.zzx.pojo.StudentQueryParam;
import com.zzx.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentMapper studentMapper;
    /**
     * 分页查询
     */
    @Override
    public PageResult<Student> page(StudentQueryParam queryParam) {
        PageHelper.startPage(queryParam.getPage(), queryParam.getPageSize());
        List<Student> list = studentMapper.page(queryParam);
        //封装成Page类型
        Page<Student> p = (Page<Student>) list;
        return new PageResult<Student>(p.getTotal(), p.getResult());
    }

    @Override
    public void add(Student student) {
        student.setCreateTime(LocalDateTime.now());
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.add(student);
    }

    @Override
    public Student get(Integer id) {
        return studentMapper.get(id);
    }

    @Override
    public void update(Student student) {
        student.setUpdateTime(LocalDateTime.now());
        studentMapper.update(student);
    }

    @Override
    public void delete(Integer id) {
        studentMapper.delete(id);
    }

    @Override
    public void violation(Integer id, Integer score) {
        studentMapper.violation(id, score);
    }
}
