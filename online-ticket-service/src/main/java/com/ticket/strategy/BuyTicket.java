package com.ticket.strategy;

import com.ticket.entity.Seat;

/**
 * Created by wangwu on 2020/8/10.
 */
public class BuyTicket {
        private static double price=100;
        public static Double buyTicketPrice(Integer age){
                double endPrice=price;
                 if(age<=18 && age>0){
                         endPrice=price*0.5;
                 }else if(age<=70 && age>18){
                         endPrice=price;
                 }else if(age>70){
                         endPrice=price*0.3;
                 }
                return endPrice;
        }

        public static void main(String[] args) {

                System.out.println(buyTicketPrice(10));

        }
}

