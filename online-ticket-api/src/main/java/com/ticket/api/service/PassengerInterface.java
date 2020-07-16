package com.ticket.api.service;

import com.ticket.api.vo.PassengerVo;

import java.util.List;

public interface PassengerInterface {
        /**
         * 添加乘客
         * @param passengerVo 乘客信息
         */
        public void addPassenger(PassengerVo passengerVo);

        /**
         * 查询用户下的乘客信息
         * @param user_phone_num 用户账号
         * @return 乘客信息
         */
        public List<PassengerVo> selectPassengerByuser_phone_num(String user_phone_num);

        /**
         * 删除用户乘客信息
         * @param user_phone_num 用户账号
         * @param passenger_phone_num 乘客账号
         */
        public void deletPassenger(String user_phone_num,String passenger_phone_num);
}