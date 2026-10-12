package com.zzx.controller;

import com.zzx.pojo.Dept;
import com.zzx.pojo.Result;
import com.zzx.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//Lombok注解：编译时自动生成一个log日志对象，类里可以直接用 log.info(...) 记录日志
@Slf4j
//等于 @Controller + @ResponseBody：声明本类是控制器并交给Spring管理，
//所有方法的返回值都自动转成JSON写回浏览器（不做页面跳转）
@RestController
@RequestMapping("/depts")
public class DeptController {

    //Spring依赖注入：容器自动把DeptService的实现类对象塞给这个变量，不用手动new
    @Autowired //注入service
    private DeptService deptService;

    //处理GET /depts请求：前端用GET方式访问该地址时，调用下面的list()查询全部部门
    @GetMapping
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
   //处理DELETE /depts请求：用于删除部门，id来自URL问号后的参数（如 ?id=5）
   @DeleteMapping
   public Result delete(Integer id) {
//       System.out.println("删除部门id为：" + id);
       log.info("删除部门id为：" + id);
       deptService.deleteById(id);
       return Result.success();
   }

   //处理POST /depts请求：用于新增部门
   @PostMapping
    public Result add(@RequestBody Dept dept) { //@RequestBody：把前端请求体里的JSON数据转成Dept对象
//        System.out.println("添加部门：" + dept);
       log.info("添加部门：" + dept);
        deptService.addDept(dept);
        return Result.success();
    }

    /**
     * 根据ID查询部门
     */
    //处理GET /depts/{id}请求：如 /depts/5，表示查询id为5的部门
    @GetMapping("/{id}")
    public Result findById(@PathVariable Integer id) { //@PathVariable：取出URL路径中{id}的值赋给id参数
//        System.out.println("查询部门id为：" + id);
        log.info("查询部门id为：" + id);
        Dept dept = deptService.getById(id);
        return Result.success(dept);
    }
    /**
     * 根据ID修改部门
     */
    //处理PUT /depts请求：用于根据id修改部门信息
    @PutMapping
    public Result update(@RequestBody Dept dept) { //@RequestBody：把前端请求体JSON中的部门数据转成Dept对象
//        System.out.println("修改部门：" + dept);
        log.info("修改部门：" + dept);
        deptService.updateById(dept);
        return Result.success();
    }
}
