package com.lemon.michstabe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages = "com.lemon.michstabe.dao")
public class MichstabeApplication {

    public static void main(String[] args) {
        SpringApplication.run(MichstabeApplication.class, args);
    }

}
