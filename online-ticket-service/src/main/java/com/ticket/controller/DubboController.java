package com.ticket.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ticketManage.api.service.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@RestController
@RequestMapping("/dubbo")
public class DubboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboController.class);

//    @Resource
    @Reference
DubboService dubboService;

    @RequestMapping("/sayHello")
    public void sayHello() {
        System.out.println("dubbo开始调用");
        dubboService.sayHello("consumer 请求服务");
    }



    /**
     * 进入主页
     */
    @RequestMapping("/index")
    public Object index(){
        ModelAndView modelAndView=new ModelAndView();
        try {
            modelAndView.setViewName("index");
            LOGGER.info("ThymeleafController  loginForIndex  bean={}", JSONObject.toJSON(modelAndView));
        }catch (Exception e){
            e.printStackTrace();
        }
        return  modelAndView;
    }

}
