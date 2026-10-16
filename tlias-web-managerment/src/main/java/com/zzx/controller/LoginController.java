package com.zzx.controller;

import com.zzx.pojo.Emp;
import com.zzx.pojo.LoginInfo;
import com.zzx.pojo.Result;
import com.zzx.service.EmpService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private EmpService empService;
    // 处理 POST /login 请求
    @PostMapping
    public Result login(@RequestBody Emp emp) {
        log.info("进行登录验证{}", emp);
        LoginInfo loginInfo = empService.login(emp);
        if (loginInfo != null){
            return Result.success(loginInfo);
        }
        return Result.error("用户名或密码错误");
    }
}
