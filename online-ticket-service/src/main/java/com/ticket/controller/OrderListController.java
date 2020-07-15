package com.ticket.controller;

import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.service.impl.OrderListImpl;
import com.ticket.utils.RandomUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/orderList")
public class OrderListController {
        @Autowired
        OrderListImpl orderListImpl;
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

}