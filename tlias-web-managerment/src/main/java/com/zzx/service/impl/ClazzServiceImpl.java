package com.zzx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzx.exception.DeptNotEmptyException;
import com.zzx.mapper.ClazzMapper;
import com.zzx.mapper.StudentMapper;
import com.zzx.pojo.Clazz;
import com.zzx.pojo.ClazzQueryParam;
import com.zzx.pojo.Emp;
import com.zzx.pojo.PageResult;
import com.zzx.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Slf4j
@Service
public class ClazzServiceImpl implements ClazzService {
    @Autowired
    private ClazzMapper clazzMapper;

    @Autowired
    private StudentMapper studentMapper;
    @Override
    public PageResult<Clazz> page(ClazzQueryParam param) {
        //设置分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //执行查询
        List<Clazz> clazzList = clazzMapper.list(param);
        //解析查询结果，并封装
        Page<Clazz> p = (Page<Clazz>) clazzList;
        return new PageResult<Clazz>(p.getTotal(), p.getResult());
    }

    /**
     * 添加班级
     */
    @Override
    public void save(Clazz clazz) {
        log.info("添加班级,参数:{}", clazz);
        clazz.setCreateTime(LocalDateTime.now());
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.save(clazz);
    }

    /**
     * 根据ID查询班级信息
     */
    @Override
    public Clazz getById(Integer id) {
        return clazzMapper.getById(id);
    }

    /**
     * 修改班级信息
     */
    @Override
    public void update(Clazz clazz) {
        log.info("修改班级,参数:{}", clazz);
        clazz.setUpdateTime(LocalDateTime.now());
        clazzMapper.update(clazz);
    }

    @Override
    public void delete(Integer id) {
        Integer count = studentMapper.countByClazzId(id);
        if (count != null && count > 0) {
            throw new DeptNotEmptyException("班级中还有学生，不能删除");
        }
        log.info("删除班级,参数:{}", id);
        clazzMapper.delete(id);
    }

    /**
     * 查询所有班级
     */
    @Override
    public List<Clazz> listAll() {
        return clazzMapper.listAll();
    }
}
