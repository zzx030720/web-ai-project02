package com.zzx.exception;

import com.zzx.pojo.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

//Lombok注解：编译时自动生成一个log日志对象，类里可以直接用 log.info(...) 记录日志
@Slf4j
//Spring注解：= @ControllerAdvice + @ResponseBody，声明本类为“全局异常处理器”，
//会拦截所有 @RestController 方法抛出的异常，并用统一 JSON（Result）格式返回前端
@RestControllerAdvice
public class GlobalExceptionHandler {

    //处理异常
    //Spring注解：声明下面方法专门处理指定类型的异常；参数 Exception e 决定了能拦截的范围，
    //这里写 Exception 属于“兜底”处理，任何未被其他 @ExceptionHandler 匹配的异常都会走这里
    @ExceptionHandler
    public Result ex(Exception e){//方法形参中指定能够处理的异常类型
        log.error("程序出错了",e);//用日志框架记录异常堆栈（替代 e.printStackTrace()）
        //捕获到异常之后，响应一个标准的Result
        return Result.error("对不起,操作失败,请联系管理员");
    }

    //Spring注解：专门处理“部门下还有员工不能删除”这类可预期的业务异常，
    //它会比兜底的 ex(Exception) 方法优先匹配（异常类型更具体），
    //并把异常自带的提示信息原样返回给前端展示
    @ExceptionHandler
    public Result handleDeptNotEmptyException(DeptNotEmptyException e) {
        //关键：用 e.getMessage() 取出抛出异常时写入的提示语，而不是写死的通用文案
        return Result.error(e.getMessage());
    }

    //Spring注解：专门处理 MySQL 唯一键冲突时 Spring 报的 DuplicateKeyException（比如新增员工时用户名重复），
    //它会比上面那个兜底方法优先匹配（因为异常类型更具体），返回可直接展示给用户的提示
    @ExceptionHandler
    public Result handleDuplicateKeyException(DuplicateKeyException e) {
        log.error("程序出错了",e);
        String message = e.getMessage();
        int i = message.indexOf("Duplicate entry");
        String errMsg = message.substring(i);
        String[] arr = errMsg.split(" ");
        return Result.error(arr[2] + "已存在");
    }

    

}