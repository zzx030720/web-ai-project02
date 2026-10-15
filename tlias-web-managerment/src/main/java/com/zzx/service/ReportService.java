package com.zzx.service;

import com.zzx.pojo.JobOption;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();
}
