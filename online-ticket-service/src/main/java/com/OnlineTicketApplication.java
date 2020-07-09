package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import tk.mybatis.spring.annotation.MapperScan;

@ImportResource("classpath:spring-mybatis.xml")      //导入xml配置
@MapperScan(basePackages = "com.ticket.mapper")
@ComponentScan(basePackages ={"com.ticket.api"} )
@SpringBootApplication
public class OnlineTicketApplication {
    public static void main(String[] args){
        SpringApplication.run(OnlineTicketApplication.class,args);
    }
}
