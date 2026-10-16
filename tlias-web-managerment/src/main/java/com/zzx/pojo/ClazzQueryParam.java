package com.zzx.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Data
public class ClazzQueryParam {
    private Integer page = 1; //页码
    private Integer pageSize = 10; //每页展示记录数

    //以下三个为页面分页查询的人为操作条件
    private String name; //班级名称
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin; //结课时间-开始
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end; //结课时间-结束
}
