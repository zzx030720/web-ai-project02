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

@Slf4j
@RequestMapping("/emps")
@RestController
public class EmpController {

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
    @GetMapping
    public Result page(EmpQueryParam param) {
        log.info("分页查询,参数:{}", param);
        PageResult<Emp> pageResult = empService.page(param);
        return Result.success(pageResult);
    }
    @PostMapping
    public Result save(@RequestBody Emp emp){
        log.info("保存员工,参数:{}",emp);
        empService.save(emp);
        return Result.success();
    }

    @DeleteMapping
    public Result delete(@RequestParam List<Integer> ids){
        log.info("批量删除员工，参数：{}",ids);
        empService.delete(ids);
        return Result.success();
    }
}
