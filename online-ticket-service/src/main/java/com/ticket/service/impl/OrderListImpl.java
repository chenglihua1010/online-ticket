package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.OrderListInerface;
import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.mapper.OrderListMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class OrderListImpl extends BaseService implements OrderListInerface {
        @Autowired
        OrderListMapper orderListMapper;

        /**
         * 添加订单
         * @param orderListVo
         */
        @Override
        public void addOrder(OrderListVo orderListVo) {
                OrderList orderList=transferObjectIgnoreCase(orderListVo,OrderList.class);
                orderListMapper.addOrder(orderList);
        }
}