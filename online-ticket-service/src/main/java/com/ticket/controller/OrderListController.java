package com.ticket.controller;


import com.alibaba.fastjson.JSONObject;
import com.google.common.collect.Lists;
import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.entity.Passenger;
import com.ticket.service.impl.OrderListImpl;
import com.ticket.service.impl.RedisUtils;
import com.ticket.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;


@Controller
@RequestMapping("/orderList")
public class OrderListController {

        @Autowired
        OrderListImpl orderListImpl;

        @Autowired
        RedisUtils redisUtils;

        //注意引用的架包import org.slf4j.Logger; import org.slf4j.LoggerFactory;
        private static final Logger LOGGER = LoggerFactory.getLogger(OrderListController.class);

        @RequestMapping("/addOrder")
//        @ResponseBody
        public ModelAndView addOrder(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                //userInfor
                String user_phone_num=request.getParameter("user_phone_num");
                //passengerInfor
                String passenger_real_name=request.getParameter("passenger_real_name");
                //trainInfor
                String start_station_name=request.getParameter("start_station_name");
                String end_station_name=request.getParameter("end_station_name");
                String train_start_dateString=request.getParameter("");
                String order_money=request.getParameter("order_money");
                Double order_moneyDouble=Double.parseDouble(order_money);
                String order_id=RandomUtil.getRandomNickname(10);

                OrderListVo orderListVo=new OrderListVo();
                orderListVo.setOrder_id(order_id);
                orderListVo.setOrder_money(order_moneyDouble);
                orderListVo.setUser_phone_num(user_phone_num);
                orderListImpl.addOrder(orderListVo);
                return modelAndView;

        }

        @RequestMapping("/selectOrderByuser_phone_num")
        @ResponseBody
        public List<OrderListVo> selectOrderByuser_phone_num(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");

                List<OrderListVo> listVos=orderListImpl.selectOrderByUser_phone_num(user_phone_num);
//                listVos=Lists.newArrayList();
//                List<OrderListVo> listVos=Lists.newArrayList();
//                listVos=orderListImpl.selectOrderByUser_phone_num(user_phone_num);


                redisUtils.set("ceshi",listVos);
                return listVos;
        }

        @RequestMapping("/selectPartOrderByUser_phone_num")
        @ResponseBody
        public ModelAndView selectPartOrderByUser_phone_num(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                String order_status=request.getParameter("order_status");
                Integer order_statusInt = Integer.parseInt(order_status);
                ModelAndView modelAndView=new ModelAndView();
                try{
                        List<OrderListVo> orderListVo=orderListImpl.selectPartOrderByUser_phone_num(user_phone_num,order_statusInt);
                        if(!ObjectUtils.isEmpty(orderListVo)){
                                modelAndView.setViewName("");
                                modelAndView.addObject("orderList",orderListVo);
                                //尝试记录日志：结果？ 参数
                                LOGGER.info("OrderListController selectPartOrderByUser_phone_num bean={}", JSONObject.toJSON(modelAndView));
                                LOGGER.info("OrderListController selectPartOrderByUser_phone_num bean={}",
                                                JSONObject.toJSON("参数user_phone_num:"+user_phone_num+"参数order_statusInt:"+order_statusInt));
                        }else{
                                modelAndView.setViewName("error");
                                LOGGER.error("orderListVo未从MySQL、redus中获取到值");
                        }
                }catch (Exception e){
                        e.printStackTrace();
                }
                return modelAndView;

        }



}