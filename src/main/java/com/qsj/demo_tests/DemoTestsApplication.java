package com.qsj.demo_tests;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.qsj.demo_tests.mappers")
public class DemoTestsApplication {

    public static void main(String[] args) {
        SpringApplication.run(DemoTestsApplication.class, args);
    }

}
