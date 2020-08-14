package com.ticket.strategy;

/**
 * Created by wangwu on 2020/8/10.
 */
public class BuyStrategy {
        private BuyTicketInterface buyTicketInterface;

        public BuyStrategy(BuyTicketInterface buyTicketInterface){
                this.buyTicketInterface=buyTicketInterface;
        }

        public double sell(){
               return buyTicketInterface.sell();
        }
}
