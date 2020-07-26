package com.ticket.controller;


import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;
import com.ticket.api.vo.ManageInforVo;
import com.ticket.api.vo.UserInforVo;
import com.ticket.entity.UserInfor;
import com.ticket.service.impl.RedisService;
import com.ticket.service.impl.RedisUtils;
import com.ticket.utils.RedisClient;
import com.ticketManage.api.service.DubboService;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import redis.clients.jedis.Jedis;

import java.util.*;

import static com.ticket.utils.BaseService.transferObjectIgnoreCase;


@Controller
@RequestMapping("/dubbo")
public class DubboController {

    private static final Logger LOGGER = LoggerFactory.getLogger(DubboController.class);

//    @Resource
    @Reference
    DubboService dubboService;

    @Autowired
    RedisService redisService;


    @Autowired
    RedisClient redisClient;

    @Autowired
    RedisUtils redisUtils;


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
    public List<UserInfor> testRedis(){

        UserInfor userInfor=new UserInfor();
        userInfor.setUser_address("xxxxx");
        userInfor.setUser_real_name("wangwuclr");
        userInfor.setUser_id_number("11");

        UserInfor userInfor1=new UserInfor();
        userInfor1.setUser_address("yyyy");
        userInfor1.setUser_real_name("jflsjfks");
        userInfor1.setUser_id_number("22222");

        List<UserInfor>  list= Lists.newArrayList();
        list.add(userInfor);
        list.add(userInfor1);

//        UserInforVo u;
//        for(int i=0;i<list.size();i++){
//
//            u=transferObjectIgnoreCase(list.get(i),UserInforVo.class);
//            System.out.println(u);
//                }
//
//        for(UserInfor p:list){
//            transfer(p);
//            System.out.println(p);
//        }


        //TODO import com.google.common.collect的用法（lists、sets、maps）
//        List<UserInfor> list1=new ArrayList<>();
//
//        List<UserInfor> list2=Lists.newArrayList();
//
//
//        Map<String,String> map=new HashedMap();
//        Map<String,String> map1= Maps.newHashMap();
//
//
//        Set<UserInfor> set =new TreeSet<>();
//       Set<UserInfor> set1= Sets.newTreeSet();
//        Set<UserInfor> set2= Sets.newHashSet();
//        System.out.println(userInfor);
//        System.out.println(JSONObject.toJSONString(userInfor));
//        System.out.println(userInfor.toString());

         // redisService的用法
//        redisService.setNameValue(userInfor.getUser_id_number().toString(),JSONObject.toJSONString(userInfor));
//        String userString=redisService.findName(userInfor.getUser_id_number().toString());
//        UserInfor userInfor1=JSONObject.parseObject(userString,UserInfor.class);
//        LOGGER.info("DubboController testRedis value={}",JSONObject.toJSONString(userInfor1));
//        System.out.println("++++++++++++++++++++++++++++++++++++++++++++++++++++++++++");
//        System.out.println("www "+JSONObject.toJSONString(userInfor1));


//        redisUtils.set("ceshi11","1233");
////        redisClient.set("ceshi","123");
//        redisUtils.get("ceshi11");
////        redisUtils.set("list",list);
//        System.out.println(redisUtils.get("list"));
//        List<UserInfor> userInforList=(List<UserInfor>)redisUtils.get("list");

        redisUtils.tryGetDistributedLock("mykey","myclient",20*(1000));

        return null;
    }

    /**
     * Vo和Entity转换
     * @param userInfor
         */
    public void transfer(UserInfor userInfor){
        UserInforVo userInforVo=transferObjectIgnoreCase(userInfor,UserInforVo.class);
    }

    @RequestMapping("/testRedisForList")
    @ResponseBody
    public List testRedisForList(){
        UserInfor userInfor=new UserInfor();
        userInfor.setUser_address("xxxxx");
        userInfor.setUser_real_name("wangwuclr");
        userInfor.setUser_id_number("11");

        UserInfor userInfor1=new UserInfor();
        userInfor1.setUser_address("yyyy");
        userInfor1.setUser_real_name("jflsjfks");
        userInfor1.setUser_id_number("22222");

        UserInfor userInfor2=new UserInfor();
        userInfor2.setUser_id_number("111");


        List<UserInfor>  list= Lists.newArrayList();
        list.add(userInfor);
        list.add(userInfor1);

        redisUtils.lPushAll("listAll",list);
        System.out.println("ListALL"+redisUtils.lGet("listAll",0,-1));
        redisUtils.lPush("listAll",userInfor2);
        System.out.println("ListALL"+redisUtils.lGet("listAll",0,-1));
        List userInfors= redisUtils.lGet("listAll",0,1);

        return userInfors;
    }

}
