package com.ticket.strategy;

/**
 * Created by wangwu on 2020/8/10.
 */
public class OldMan implements BuyTicketInterface{
        @Override
        public double sell() {
                return 0.3;
        }
}
