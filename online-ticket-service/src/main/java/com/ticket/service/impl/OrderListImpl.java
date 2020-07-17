package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.OrderListInerface;
import com.ticket.api.vo.OrderListVo;
import com.ticket.entity.OrderList;
import com.ticket.mapper.OrderListMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class OrderListImpl extends BaseService  implements OrderListInerface {
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

        /**
         * 根据用户账号查询订单
         * @param user_phone_num 用户账号
         * @return 订单信息表
         */
        @Override
        public List<OrderListVo> selectOrderByUser_phone_num(String user_phone_num) {
                List<OrderList> orderLists=orderListMapper.selectOrderByUser_phone_num(user_phone_num);
                List<OrderListVo> orderListVos=getList(orderLists,OrderListVo.class);
                return orderListVos;
        }

        /**
         * 查询用户部分订单
         * @param user_phone_num 用户账号
         * @param order_status 订单状态
         * @return 订单信息表
         */
        @Override
        public List<OrderListVo> selectPartOrderByUser_phone_num(String user_phone_num, Integer order_status) {
                List<OrderList> orderLists=orderListMapper.selectPartOrderByUser_phone_num(user_phone_num,order_status);
                List<OrderListVo> listVos=transferObjectIgnoreCaseList(orderLists,OrderListVo.class);
                return listVos;
        }
}