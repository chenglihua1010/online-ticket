package com.ticket.mapper;

import com.ticket.entity.OrderList;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderListMapper extends MyMapper<OrderList>{
        public void addOrder(@Param("orderList")OrderList orderList);
        public List<OrderList> selectOrderByUser_phone_num(@Param("user_phone_num")String user_phone_num);
        public List<OrderList> selectPartOrderByUser_phone_num(@Param("user_phone_num")String user_phone_num,@Param("order_status")Integer order_status);
        public void updateOrder_status(@Param("order_status")Integer order_status,@Param("order_id") String order_id);

}