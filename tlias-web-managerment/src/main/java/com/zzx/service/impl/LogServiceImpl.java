package com.zzx.service.impl;


import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.zzx.mapper.LogMapper;
import com.zzx.pojo.LogQueryParam;
import com.zzx.pojo.OperateLog;
import com.zzx.pojo.PageResult;
import com.zzx.service.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService {

    @Autowired
    private LogMapper logMapper;
    @Override
    public PageResult<OperateLog> getLogList(LogQueryParam logQueryParam) {
        //PageHelper 的规则：startPage 只对它下面紧挨着的第一次查询生效
        PageHelper.startPage(logQueryParam.getPage(), logQueryParam.getPageSize());
        //查询返回的是 Page 的实现类，可以直接强转拿到 total
        List<OperateLog> list = logMapper.selectByLogQueryParam(logQueryParam);
        Page<OperateLog> page = (Page<OperateLog>) list;
        return new PageResult<>(page.getTotal(), page.getResult());
    }
}
