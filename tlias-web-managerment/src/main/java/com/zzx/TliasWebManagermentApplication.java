package com.zzx;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

//SpringBoot核心注解：声明这是启动配置类，并自动完成三件事——
//1.标注为配置类 2.开启自动配置（内嵌Tomcat、数据源等自动装配） 3.扫描本包及子包下的@Component/@Service等注解
@SpringBootApplication
public class TliasWebManagermentApplication {

    public static void main(String[] args) {
        SpringApplication.run(TliasWebManagermentApplication.class, args);
    }

}
