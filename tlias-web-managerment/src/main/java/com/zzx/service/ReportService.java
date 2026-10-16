package com.zzx.service;

import com.zzx.pojo.ClassOption;
import com.zzx.pojo.JobOption;

import java.util.List;
import java.util.Map;

public interface ReportService {
    /**
     * 统计各个职位的员工人数
     * @return
     */
    JobOption getEmpJobData();

    /**
     * 统计员工性别信息
     */
    List<Map> getEmpGenderData();

    /**
     * 统计各个班级的学生人数
     * @return
     */
    ClassOption getStudentCountData();

    /**
     * 统计学员学历信息
     */
    List<Map> getStudentDegreeData();

}
