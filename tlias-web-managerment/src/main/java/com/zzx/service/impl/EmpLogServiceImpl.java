package com.zzx.service.impl;

import com.zzx.mapper.EmpLogMapper;
import com.zzx.pojo.EmpLog;
import com.zzx.service.EmpLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

//Spring注解：声明本类是业务层组件，启动时被扫描并存入IOC容器，其他类中才能注入使用
@Service
public class EmpLogServiceImpl implements EmpLogService {

    //Spring依赖注入：容器自动把EmpLogMapper的实现类对象塞给这个变量
    @Autowired
    private EmpLogMapper empLogMapper;

    //Spring事务注解：propagation = REQUIRES_NEW 表示开启一个全新独立的事务提交，
    //即使外层事务（如保存员工）回滚，日志也能单独写入成功
    @Transactional(propagation = Propagation.REQUIRES_NEW)//需要在新的事务中运行
    @Override
    public void insertLog(EmpLog empLog) {
        empLogMapper.insert(empLog);
    }
}
