package com.zzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Slf4j
@Data
@NoArgsConstructor
@AllArgsConstructor
public class LogQueryParam {
    private Integer page = 1;
    private Integer pageSize = 10;

    //以下为页面上的查询条件，不传就是查全部（对应 XML 里的 <if> 判断）
    private String operateEmpName;  //操作人姓名，模糊匹配

    private String className;       //操作的类名，模糊匹配

    private String methodName;      //操作的方法名，模糊匹配

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate begin;        //操作时间-开始

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate end;          //操作时间-结束，含当天
}
