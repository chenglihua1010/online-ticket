package com.ticket.mapper;

import com.ticket.entity.Passenger;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;
import org.omg.CORBA.StringHolder;

import java.util.List;

public interface PassengerMapper extends MyMapper<Passenger>{
        /**
         * 添加乘客
         * @param passenger 乘客信息
         */
        public void addPassenger(@Param("passenger")Passenger passenger);

        /**
         * 查询用户的乘客信息
         * @param user_phone_num 用户账号
         * @return 乘客信息
         */
        public List<Passenger> selectPassengerByuser_phone_num(String user_phone_num);

        public void deletPassenger(@Param("user_phone_num") String user_phone_num,@Param("passenger_real_name") String passenger_real_name);

        public Passenger findAimPassenger(@Param("user_phone_num") String user_phone_num,@Param("passenger_real_name") String passenger_real_name);

}