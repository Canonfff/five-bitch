package com.canon.base.run;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @program: five-bitch
 * @Auther: canon
 * @Date: 2019/12/6 13:18
 * @Description:
 */
@SpringBootApplication
@ComponentScan("com.canon.*")
@MapperScan(basePackages = "com.canon.*.dao")
public class Main {
    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
