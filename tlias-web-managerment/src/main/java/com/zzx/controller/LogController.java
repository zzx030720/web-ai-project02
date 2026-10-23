package com.zzx.controller;


import com.zzx.pojo.LogQueryParam;
import com.zzx.pojo.OperateLog;
import com.zzx.pojo.PageResult;
import com.zzx.pojo.Result;
import com.zzx.service.LogService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RequestMapping("/log/page")
@RestController
public class LogController {
    @Autowired
    private LogService logService;

    @GetMapping
    public Result getLogList(LogQueryParam logQueryParam) {
        PageResult<OperateLog> logPageResult = logService.getLogList(logQueryParam);
        return Result.success(logPageResult);
    }
}
