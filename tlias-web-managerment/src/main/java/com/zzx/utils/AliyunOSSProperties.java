package com.zzx.utils;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

//Lombok注解：编译时自动生成所有字段的getter/setter、toString等方法，不用手写
@Data
//Spring注解：声明本类是组件，启动时被扫描并存入IOC容器
@Component
//Spring注解：批量读取 application.yml 中 aliyun.oss. 开头的所有配置，
//自动赋值给本类的同名字段（endpoint、bucketName、region），逐个写@Value太麻烦
@ConfigurationProperties(prefix = "aliyun.oss")
public class AliyunOSSProperties {
    private String endpoint;
    private String bucketName;
    private String region;
}