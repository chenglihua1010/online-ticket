package com.ticket.api.service;

import com.ticket.api.vo.OrderListVo;

import java.util.List;

public interface OrderListInerface {
        /**
         * 添加订单
         * @param orderListVo
         */
        public void addOrder(OrderListVo orderListVo);

        public List<OrderListVo> selectOrderByUser_phone_num(String user_phone_num);
}