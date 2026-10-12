package com.zzx.pojo;

import lombok.Data;

import java.time.LocalDate;

/**
 * 工作经历
 */
//Lombok注解：编译时自动生成所有字段的getter/setter、toString、equals等方法，不用手写
@Data
public class EmpExpr {
    private Integer id; //ID
    private Integer empId; //员工ID
    private LocalDate begin; //开始时间
    private LocalDate end; //结束时间
    private String company; //公司名称
    private String job; //职位
}
