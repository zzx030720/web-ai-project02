package com.zzx.controller;

import com.zzx.pojo.*;
import com.zzx.pojo.StudentQueryParam;
import com.zzx.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;
    /**
     * 分页查询
     */
    //处理GET /students请求：分页查询学生列表，URL问号后的参数会自动封装到StudentQueryParam对象里
    @GetMapping
    public Result page(StudentQueryParam queryParam){
        log.info("分页查询学生信息,参数:{}", queryParam);
        PageResult<Student> pageResult = studentService.page(queryParam);
        return Result.success(pageResult);
    }
    /**
     * 新增学员
     */
    @PostMapping
    public Result add(@RequestBody Student student){
        log.info("新增学员,参数:{}", student);
        studentService.add(student);
        return Result.success();
    }

    /**
     * 根据ID查询
     */
    @GetMapping("/{id}")
    public Result get(@PathVariable Integer id){
        log.info("根据ID查询学生信息,参数:{}", id);
        Student student = studentService.get(id);
        return Result.success(student);
    }

    /**
     * 修改学员信息
     */
    @PutMapping
    public Result update(@RequestBody Student student){
        log.info("修改学员信息,参数:{}", student);
        studentService.update(student);
        return Result.success();
    }

    /**
     * 删除学员
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        log.info("删除学员,参数:{}", id);
        studentService.delete(id);
        return Result.success();
    }

    /**
     * 违纪处理
     */
    @PutMapping("/violation/{id}/{score}")
    public Result violation(@PathVariable Integer id, @PathVariable Integer score){
        log.info("违纪处理,参数:id={}, score={}", id, score);
        studentService.violation(id, score);
        return Result.success();
    }
}
