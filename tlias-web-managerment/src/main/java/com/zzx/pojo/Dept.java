package com.zzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Lombok注解：编译时自动生成所有字段的getter/setter、toString、equals等方法，不用手写
@Data
//Lombok注解：生成无参构造方法 Dept()，MyBatis查数据、Jackson转JSON时都需要它
@NoArgsConstructor
//Lombok注解：生成全参构造方法 Dept(id, name, createTime, updateTime)
@AllArgsConstructor
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
