package com.ffideal.springboot_advance_demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.Caching;
import org.springframework.cache.annotation.EnableCaching;

@MapperScan("com/ffideal/springboot_advance_demo/mapper")
@EnableCaching
@SpringBootApplication
public class SpringbootAdvanceDemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringbootAdvanceDemoApplication.class, args);
    }

}
