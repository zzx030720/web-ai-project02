package com.zzx;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

//SpringBoot测试注解：启动一个和线上一致的Spring容器（包含IOC、自动装配、数据源等），
//测试方法里可以@Autowired任何Bean，也能直接验证Mapper/Service的真实行为
@SpringBootTest
class TliasWebManagermentApplicationTests {

    //JUnit5注解：标记方法为一个单元测试；本方法体为空，仅用于验证Spring容器能否正常启动
    @Test
    void contextLoads() {
    }

}
