package com.ticket.api.service;

import com.ticket.api.vo.OrderListVo;

public interface OrderListInerface {
        /**
         * 添加订单
         * @param orderListVo
         */
        public void addOrder(OrderListVo orderListVo);
}