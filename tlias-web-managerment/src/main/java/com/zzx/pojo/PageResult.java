package com.zzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

//Lombok注解：编译时自动生成所有字段的getter/setter、toString、equals等方法，不用手写
@Data
//Lombok注解：生成无参构造方法 PageResult()，Jackson转JSON、MyBatis封装时都需要它
@NoArgsConstructor
//Lombok注解：生成全参构造方法 PageResult(total, rows)，方便 service 里一行代码封装分页结果
@AllArgsConstructor
public class PageResult<T> {
    private long total;
    private List<T> rows;
}
