package com.zzx.service.impl;

import com.zzx.mapper.DeptMapper;
import com.zzx.pojo.Dept;
import com.zzx.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

//Spring注解：声明本类是业务层组件，启动时被扫描并存入IOC容器，Controller中才能注入使用
@Service
public class DeptServiceImpl implements DeptService {

    //Spring依赖注入：容器自动把DeptMapper的实现类对象塞给这个变量，不用手动new
    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> findAll() {
        return deptMapper.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        deptMapper.deleteById(id);
    }

    @Override
    public void addDept(Dept dept) {
        //补全基础属性
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
    }

    @Override
    public Dept getById(Integer id) {
        return deptMapper.getById(id);
    }

    @Override
    public void updateById(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateById(dept);
    }
}
