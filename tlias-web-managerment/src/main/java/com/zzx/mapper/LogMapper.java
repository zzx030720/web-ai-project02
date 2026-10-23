package com.zzx.mapper;

import com.zzx.pojo.LogQueryParam;
import com.zzx.pojo.OperateLog;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface LogMapper {

    /**
     * 操作日志分页条件查询
     * 对应 LogMapper.xml 中的 <select id="selectByLogQueryParam">
     * 分页由 service 层的 PageHelper.startPage() 完成，SQL 里不写 limit
     *
     * @param logQueryParam 查询条件载体
     * @return 当前页的日志列表
     */
    List<OperateLog> selectByLogQueryParam(LogQueryParam logQueryParam);
}
