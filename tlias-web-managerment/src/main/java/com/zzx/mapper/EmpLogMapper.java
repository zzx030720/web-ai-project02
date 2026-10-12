package com.zzx.mapper;

import com.zzx.pojo.EmpLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

//MyBatis注解：告诉MyBatis为这个接口自动生成实现类，并交给Spring容器管理，service中才能注入使用
@Mapper
public interface EmpLogMapper {
    //插入日志
    //MyBatis注解：执行INSERT语句写入一条操作日志，#{operateTime}、#{info}从empLog对象属性取值
    @Insert("insert into emp_log (operate_time, info) values (#{operateTime}, #{info})")
    public void insert(EmpLog empLog);
}
