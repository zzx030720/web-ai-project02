package com.zzx.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

//Lombok注解：编译时自动生成所有字段的getter/setter、toString、equals等方法，不用手写
@Data
//Lombok注解：生成无参构造方法 EmpLog()，MyBatis查数据、Jackson转JSON时都需要它
@NoArgsConstructor
//Lombok注解：生成全参构造方法 EmpLog(id, operateTime, info)，
//方便代码里直接 new EmpLog(null, 当前时间, 日志内容)
@AllArgsConstructor
public class EmpLog {
    private Integer id; //ID
    private LocalDateTime operateTime; //操作时间
    private String info; //详细信息
}
