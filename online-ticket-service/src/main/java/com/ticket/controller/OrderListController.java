package com.ticket.controller;

import com.google.common.collect.Lists;
import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.service.impl.OrderListImpl;
import com.ticket.service.impl.RedisUtils;
import com.ticket.utils.RandomUtil;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orderList")
public class OrderListController {

        @Autowired
        OrderListImpl orderListImpl;

        @Autowired
        RedisUtils redisUtils;

        @RequestMapping("/addOrder")
        @ResponseBody
        public OrderListVo addOrder(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                String order_money=request.getParameter("order_money");
                Double order_moneyDouble=Double.parseDouble(order_money);
                String order_id=RandomUtil.getRandomNickname(10);

                OrderListVo orderListVo=new OrderListVo();
                orderListVo.setOrder_id(order_id);
                orderListVo.setOrder_money(order_moneyDouble);
                orderListVo.setUser_phone_num(user_phone_num);
                orderListImpl.addOrder(orderListVo);
                return orderListVo;

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
        public List<OrderListVo> selectPartOrderByUser_phone_num(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                String order_status=request.getParameter("order_status");
                Integer order_statusInt = Integer.parseInt(order_status);
                List<OrderListVo> orderListVo=orderListImpl.selectPartOrderByUser_phone_num(user_phone_num,order_statusInt);
                return orderListVo;
        }



}