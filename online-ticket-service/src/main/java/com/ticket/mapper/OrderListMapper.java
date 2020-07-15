package com.ticket.mapper;

import com.ticket.entity.OrderList;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

public interface OrderListMapper extends MyMapper<OrderList>{
        public void addOrder(@Param("orderList")OrderList orderList);
}