package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.ticket.api.service.DubboService1;


@Service
public class DubboServiceImpl implements DubboService1 {
    @Override
    public void sayHello(String name) {
        System.out.println(name);
        System.out.println("---dubbo 我是online-ticket的服务--1111111111--");
    }
}
