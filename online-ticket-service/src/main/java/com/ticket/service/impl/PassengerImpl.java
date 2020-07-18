package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.PassengerInterface;
import com.ticket.api.vo.PassengerVo;
import com.ticket.entity.Passenger;
import com.ticket.mapper.PassengerMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class PassengerImpl extends BaseService implements PassengerInterface {

        @Autowired
        PassengerMapper passengerMapper;

        @Autowired
        RedisUtils redisUtils;
        /**
         * 添加乘客
         * @param passengerVo 乘客信息
         */
        @Override
        public void addPassenger(PassengerVo passengerVo) {
                Passenger passenger=transferObjectIgnoreCase(passengerVo,Passenger.class);
                passengerMapper.addPassenger(passenger);
        }

        /**
         * 查询用户下的乘客信息
         * @param user_phone_num 用户账号
         * @return 乘客信息
         */
        @Override
        public List<PassengerVo> selectPassengerByuser_phone_num(String user_phone_num) {
                List<Passenger> passengers;
                //手动获得方法名
                String method="selectPassengerByuser_phone_num";
                //获取规范的key（未完善）
                String key=redisUtils.keyBuilder(method,user_phone_num);
                Object passengerFromRedis=redisUtils.get(key);
                if(!ObjectUtils.isEmpty(passengerFromRedis)){
                        passengers=(List<Passenger>) passengerFromRedis;
                }else{
                        passengers=passengerMapper.selectPassengerByuser_phone_num(user_phone_num);
                        if(!ObjectUtils.isEmpty(passengers)){
                                redisUtils.set(key,passengers);
                        }
                }
                List<PassengerVo> passengerVos=transferObjectIgnoreCaseList(passengers,PassengerVo.class);
                return passengerVos;
        }

        /**
         * 删除用户乘客信息
         * @param user_phone_num 用户账号
         * @param passenger_phone_num 乘客账号
         */
        @Override
        public void deletPassenger(String user_phone_num, String passenger_phone_num) {
                passengerMapper.deletPassenger(user_phone_num,passenger_phone_num);
        }


}