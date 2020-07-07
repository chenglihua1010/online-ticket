package com.ticket.controller;

import com.ticket.service.impl.OrderListImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/orderList")
public class OrderListController {
        private OrderListImpl orderListImpl;
        @Resource(name = "orderListImpl")
        public void setOrderListImpl(OrderListImpl orderListImpl) {
                this.orderListImpl = orderListImpl;
        }


}