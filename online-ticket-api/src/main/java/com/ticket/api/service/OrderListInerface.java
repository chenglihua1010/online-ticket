package com.ticket.api.service;

import com.ticket.api.vo.OrderListVo;

import java.util.List;

public interface OrderListInerface {
        /**
         * 添加订单
         * @param orderListVo
         */
        public void addOrder(OrderListVo orderListVo);

        /**
         * 查询用户所有订单
         * @param user_phone_num 用户账号
         * @return 订单信息表
         */
        public List<OrderListVo> selectOrderByUser_phone_num(String user_phone_num);

        /**
         * 查询用户部分订单
         * @param user_phone_num 用户账号
         * @param order_status 订单状态
         * @return 订单信息表
         */
        public List<OrderListVo> selectPartOrderByUser_phone_num(String user_phone_num,Integer order_status);
}