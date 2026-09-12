package com.zzx.controller;

import com.zzx.pojo.Dept;
import com.zzx.pojo.Result;
import com.zzx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
public class DeptController {

    @Autowired //注入service
    private DeptService deptService;

    @GetMapping(value = "/depts")
    public Result list() {
//        System.out.println("查询全部部门数据");
        log.info("查询全部部门数据");
        List<Dept> deptList = deptService.findAll();
        return Result.success(deptList);
    }

   /*
   删除部门
    */
//    @DeleteMapping(value = "/depts")
//    public Result delete(HttpServletRequest  request) {
//        String idStr = request.getParameter("id");
//        int id = Integer.parseInt(idStr);
//        System.out.println("删除部门id为：" + id);
//        return Result.success();
//    }
//    @DeleteMapping(value = "/depts")
//    public Result delete(@RequestParam(value = "id",required = false)Integer id) {
//        System.out.println("删除部门id为：" + id);
//        return Result.success();
//    }
   @DeleteMapping(value = "/depts")
   public Result delete(Integer id) {
//       System.out.println("删除部门id为：" + id);
       log.info("删除部门id为：" + id);
       deptService.deleteById(id);
       return Result.success();
   }

   @PostMapping(value = "/depts")
    public Result add(@RequestBody Dept dept) {
//        System.out.println("添加部门：" + dept);
       log.info("添加部门：" + dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门
     */
    @GetMapping(value = "/depts/{id}")
    public Result findById(@PathVariable Integer id) {
//        System.out.println("查询部门id为：" + id);
        log.info("查询部门id为：" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 根据ID修改部门
     */
    @PutMapping(value = "/depts")
    public Result update(@RequestBody Dept dept) {
//        System.out.println("修改部门：" + dept);
        log.info("修改部门：" + dept);
        deptService.updateById(dept);
        return Result.success();
    }
}
