package com.ticket.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.ticket.entity.UserInfor;
import com.ticket.service.impl.RedisService;
import com.ticketManage.api.service.DubboService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.List;


@Controller
@RequestMapping("/dubbo")
public class DubboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboController.class);

//    @Resource
    @Reference
DubboService dubboService;

    @Autowired
    RedisService redisService;


    @RequestMapping("/sayHello")
    @ResponseBody
    public String sayHello() {
        System.out.println("dubbo开始调用");
        dubboService.sayHello("consumer 请求服务");
        return "ceshi";
    }



    /**
     * 进入主页
     */
    @RequestMapping("/toIndex")
    public ModelAndView toIndex(){
        ModelAndView modelAndView=new ModelAndView();
        try {
            modelAndView.setViewName("index");
            modelAndView.addObject("www","www");
            LOGGER.info("DubboController  index  bean={}", JSONObject.toJSON(modelAndView));
            LOGGER.info("DubboController  index  bean={}", JSONObject.toJSON("ssssss"));

        }catch (Exception e){
            e.printStackTrace();
        }
        return  modelAndView;
    }

    @RequestMapping("/testWeb")
    public String testWeb(){
        return "about";
    }

    @RequestMapping("/testRedis")
    @ResponseBody
    public UserInfor testRedis(){

        UserInfor userInfor=new UserInfor();
        userInfor.setUser_address("xxxxx");
        userInfor.setUser_real_name("wangwuclr");
        userInfor.setUser_id_number("11");
        redisService.setNameValue(userInfor.getUser_id_number().toString(),JSONObject.toJSONString(userInfor));

        String userString=redisService.findName(userInfor.getUser_id_number().toString());

        UserInfor userInfor1=JSONObject.parseObject(userString,UserInfor.class);

        LOGGER.info("DubboController testRedis value={}",JSONObject.toJSONString(userInfor1));

        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
        System.out.println("www "+JSONObject.toJSONString(userInfor1));


        return userInfor1;
    }

}
