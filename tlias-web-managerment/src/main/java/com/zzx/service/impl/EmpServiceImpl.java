package com.zzx.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzx.mapper.EmpExprMapper;
import com.zzx.mapper.EmpMapper;
import com.zzx.pojo.*;
import com.zzx.service.EmpLogService;
import com.zzx.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.CollectionUtils;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmpServiceImpl implements EmpService {

    @Autowired
    private EmpMapper empMapper;
    @Autowired
    private EmpExprMapper empExprMapper;
    @Autowired
    private EmpLogService empLogService;


//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize) {
//        long total =empMapper.getEmpCount();
//        Integer start  = (page-1)*pageSize;
//        List<Emp> rows = empMapper.list(start,pageSize);
//        return new PageResult<Emp>(total,rows);
//    }

    /*
    PageHelper
     */
//    @Override
//    public PageResult<Emp> page(Integer page, Integer pageSize, String name, Integer gender,
//                                LocalDate begin, LocalDate end) {
//        //设置分页参数
//        PageHelper.startPage(page, pageSize);
//        //执行查询
//        List<Emp> empList = empMapper.list(name, gender, begin, end);
//        //解析查询结果，并封装
//        Page<Emp> p = (Page<Emp>) empList;
//        return new PageResult<Emp>(p.getTotal(), p.getResult());
//    }
    @Override
    public PageResult<Emp> page(EmpQueryParam param) {
        //设置分页参数
        PageHelper.startPage(param.getPage(), param.getPageSize());
        //执行查询
        List<Emp> empList = empMapper.list(param);
        //解析查询结果，并封装
        Page<Emp> p = (Page<Emp>) empList;
        return new PageResult<Emp>(p.getTotal(), p.getResult());
    }

    //保存员工
    @Transactional//事务
    @Override
    public void save(Emp emp) {
        try {
            //保存员工基本信息

            emp.setCreateTime(LocalDateTime.now());
            emp.setUpdateTime(LocalDateTime.now());
            empMapper.insert(emp);
        int i = 1/0;

//        保存员工工作信息
            List<EmpExpr> exprList = emp.getExprList();
            if(!CollectionUtils.isEmpty(exprList)){
                for (EmpExpr expr : exprList) {
                    expr.setEmpId(emp.getId());
                }
                empExprMapper.insertBatch(exprList);
            }
        } finally {
            //记录操作日志
            EmpLog empLog = new EmpLog(null, LocalDateTime.now(),"保存员工信息"+emp);
            empLogService.insertLog(empLog);
        }

    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void delete(List<Integer> ids) {
        //1. 批量删除员工基本信息
        empMapper.deleteById(ids);

        //2. 批量删除员工工作信息
        empExprMapper.deleteEmpId(ids);
    }

}
