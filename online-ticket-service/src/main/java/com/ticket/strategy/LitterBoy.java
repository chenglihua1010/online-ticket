package com.ticket.strategy;

/**
 * Created by wangwu on 2020/8/10.
 */
public class LitterBoy implements BuyTicketInterface{
        @Override
        public double sell() {
                return 0.5;
        }
}
