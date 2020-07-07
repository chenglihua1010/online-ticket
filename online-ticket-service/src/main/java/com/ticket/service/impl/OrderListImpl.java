package com.ticket.service.impl;

import com.ticket.dao.impl.OrderListDaoImpl;
import com.ticket.service.OrderListInerface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("orderListImpl")
public class OrderListImpl implements OrderListInerface {
        private OrderListDaoImpl orderListDaoImpl;

        @Resource(name = "orderListDaoImpl")
        public void setOrderListDaoImpl(OrderListDaoImpl orderListDaoImpl) {
                this.orderListDaoImpl = orderListDaoImpl;
        }
}