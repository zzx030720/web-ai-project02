package com.zzx.Aspect;

import com.zzx.anno.LogOperation;
import com.zzx.mapper.OperateLogMapper;
import com.zzx.pojo.OperateLog;
import com.zzx.utils.CurrentHolder;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.time.LocalDateTime;
import java.util.Arrays;

@Aspect
@Component
public class OperationLogAspect {

    @Autowired
    private OperateLogMapper operateLogMapper;

    // 环绕通知
    @Around("@annotation(com.zzx.anno.LogOperation)")
    public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        // 记录开始时间
        long startTime = System.currentTimeMillis();
        // 执行方法
        Object result = joinPoint.proceed();
        // 当前时间
        long endTime = System.currentTimeMillis();
        // 耗时
        long costTime = endTime - startTime;

        // 构建日志对象
        OperateLog operateLog = new OperateLog();
        operateLog.setOperateEmpId(getCurrentUserId()); // 需要实现 getCurrentUserId 方法
        operateLog.setOperateTime(LocalDateTime.now());
        operateLog.setClassName(joinPoint.getTarget().getClass().getName());
        operateLog.setMethodName(joinPoint.getSignature().getName());
        operateLog.setMethodParams(Arrays.toString(joinPoint.getArgs()));
        operateLog.setReturnValue(result.toString());
        operateLog.setCostTime(costTime);
//        operateLog.setOperateEmpName(getCurrentUserName());


        // 插入日志
        operateLogMapper.insert(operateLog);
        return result;
    }

    // 示例方法，获取当前用户ID
    private Integer getCurrentUserId() {
        // 这里应该根据实际情况从认证信息中获取当前登录用户的ID
        Integer id = CurrentHolder.getCurrentId(); // 获取当前用户ID
        return id == null ? -1 : id; // ThreadLocal为空时返回-1，避免自动拆箱NULL导致空指针
    }

    //获取当前用户姓名
    private String getCurrentUserName() {
        // 这里应该根据实际情况从认证信息中获取当前登录用户的姓名
        String name = CurrentHolder.getCurrentName(); // 获取当前用户姓名
        return name == null ? "" : name; // 如果当前用户没有设置姓名则返回空字符串
    }
}
