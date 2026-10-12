package com.zzx.controller;

import com.zzx.pojo.Emp;
import com.zzx.pojo.EmpQueryParam;
import com.zzx.pojo.PageResult;
import com.zzx.pojo.Result;
import com.zzx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok注解：编译时自动生成一个log日志对象，类里可以直接用 log.info(...) 记录日志
@Slf4j
//公共路径前缀：本类所有接口的地址都以 /emps 开头，如 GET /emps、POST /emps
@RequestMapping("/emps")
//等于 @Controller + @ResponseBody：声明本类是控制器并交给Spring管理，
//所有方法的返回值都自动转成JSON写回浏览器（不做页面跳转）
@RestController
public class EmpController {

    //Spring依赖注入：容器自动把EmpService的实现类对象塞给这个变量，不用手动new
    @Autowired
    private EmpService empService;

    //    @GetMapping
//    public Result page(@RequestParam(defaultValue = "1")Integer page ,
//                       @RequestParam (defaultValue = "10")Integer pageSize,
//                       String  name, Integer  gender,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate begin,
//                       @DateTimeFormat(pattern = "yyyy-MM-dd") LocalDate end){
//        log.info("分页查询,参数:{},{},{},{},{},{}",page,pageSize,name,gender,begin,end);
//        PageResult<Emp> pageResult = empService.page(page,pageSize,name,gender,begin,end);
//        return Result.success(pageResult);
//    }
    //处理GET /emps请求：分页查询员工列表，URL问号后的参数（page、name等）会自动封装到EmpQueryParam对象里
    @GetMapping
    public Result page(EmpQueryParam param) {
        log.info("分页查询,参数:{}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }
    //处理POST /emps请求：新增员工
    @PostMapping
    public Result save(@RequestBody Emp emp){ //@RequestBody：把请求体里的JSON数据转成Emp对象
        log.info("保存员工,参数:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    //处理DELETE /emps请求：批量删除员工，如 ?ids=1,2,3
    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){ //@RequestParam：取出URL问号后的ids参数值赋给ids形参
        log.info("批量删除员工，参数：{}",ids);
        empService.delete(ids);
        return Result.success();
    }
}
