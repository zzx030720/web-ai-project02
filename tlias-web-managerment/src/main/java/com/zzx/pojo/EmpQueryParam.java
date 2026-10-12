package com.zzx.pojo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

//Lombok注解：编译时自动生成所有字段的getter/setter、toString、equals等方法，不用手写
@Data
public class EmpQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;
    private String name;
    private Integer gender;
    //Spring注解：日期格式转换，把前端传来的 yyyy-MM-dd 字符串（如 2026-10-12）解析成LocalDate对象
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;
    //Spring注解：同上，把结束日期的字符串按 yyyy-MM-dd 格式解析成LocalDate对象
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;
}
