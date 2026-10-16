package com.zzx.service.impl;

import com.zzx.mapper.EmpMapper;
import com.zzx.pojo.JobOption;
import com.zzx.service.ReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class ReportServiceImpl implements ReportService {

    @Autowired
    private EmpMapper empMapper;

    @Override
    public JobOption getEmpJobData() {
//        {pos="班主任", total=5},    ← 第1条Map
//        {pos="咨询师", total=3},    ← 第2条Map
//        {pos="教研主管", total=7},  ← 第3条Map
        List<Map<String,Object>> list = empMapper.countEmpJobData(); //map: pos=班主任,num=1(一个map)
//        这个 Map 里 所有 key 都必须是 String，所有 value 都必须是 Object
        List<Object> jobList = list.stream().map(dataMap -> dataMap.get("pos")).toList();
        List<Object> dataList = list.stream().map(dataMap -> dataMap.get("total")).toList();
        return new JobOption(jobList, dataList);
    }

    @Override
    public List<Map> getEmpGenderData() {
        return empMapper.countEmpGenderData();
    }
}
