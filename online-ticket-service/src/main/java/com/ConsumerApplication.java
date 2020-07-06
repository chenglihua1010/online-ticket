package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:spring-mybatis.xml")      //导入xml配置
@SpringBootApplication
public class ConsumerApplication {
    public static void main(String[] args){
        SpringApplication.run(ConsumerApplication.class,args);
    }
}
