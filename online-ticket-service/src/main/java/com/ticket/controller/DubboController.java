package com.ticket.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.ticketManage.api.service.DubboService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/dubbo")
public class DubboController {

//    @Resource
    @Reference
DubboService dubboService;

    @RequestMapping("/sayHello")
    public void sayHello() {
        System.out.println("dubbo开始调用");
        dubboService.sayHello("consumer 请求服务");
    }


}
