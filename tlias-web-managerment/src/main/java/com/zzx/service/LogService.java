package com.zzx.service;


import com.zzx.pojo.LogQueryParam;
import com.zzx.pojo.OperateLog;
import com.zzx.pojo.PageResult;

public interface LogService {

    PageResult<OperateLog> getLogList(LogQueryParam logQueryParam);
}
