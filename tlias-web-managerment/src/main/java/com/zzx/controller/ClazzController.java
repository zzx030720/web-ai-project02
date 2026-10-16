package com.zzx.controller;


import com.zzx.pojo.*;
import com.zzx.service.ClazzService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RequestMapping("/clazzs")
@RestController
public class ClazzController {

    @Autowired
    private ClazzService clazzService;
    @GetMapping
    public Result page(ClazzQueryParam param) {
        log.info("分页查询,参数:{}", param);
        PageResult<Clazz> pageResult = clazzService.page(param);
        return Result.success(pageResult);
    }

    /**
     * 添加班级
     */
    @PostMapping
    public Result save(@RequestBody Clazz clazz) {
        log.info("添加班级,参数:{}", clazz);
        clazzService.save(clazz);
        return Result.success();
    }

    /**
     * 根据ID查询班级信息
     */
    @GetMapping("/{id}")
    public Result getById(@PathVariable Integer id) {
        log.info("根据ID查询班级信息,参数:{}", id);
        Clazz clazz = clazzService.getById(id);
        return Result.success(clazz);
    }

    @PutMapping
    public Result update(@RequestBody Clazz clazz) {
        log.info("修改班级,参数:{}", clazz);
        clazzService.update(clazz);
        return Result.success();
    }

    /**
     * 删除班级
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id) {
        log.info("删除班级,参数:{}", id);
        clazzService.delete(id);
        return Result.success();
    }
}
