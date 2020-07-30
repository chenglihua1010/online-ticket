package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.SeatInterface;
import com.ticket.api.vo.SeatVo;
import com.ticket.entity.Seat;
import com.ticket.mapper.SeatMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class SeatImpl extends BaseService implements SeatInterface {

        @Autowired
        SeatMapper seatMapper;
        @Autowired
        RedisUtils redisUtils;

        /**
         * 根据列车编号查询座位信息
         * @return 座位信息表
         */
        @Override
        public List<SeatVo> selectSeatByTrain_no(String train_no) {
                String method="selectSeatByTrain_no";
                String parame=train_no;
                String key=redisUtils.keyBuilder(method,parame);
                Object seatVofromRedis=redisUtils.get(key);
                List<Seat> seats;
                if(!ObjectUtils.isEmpty(seatVofromRedis)){
                        seats=(List<Seat>) seatVofromRedis;
                }else {
                        seats=seatMapper.selectSeatByTrain_no(train_no);
                        if(!ObjectUtils.isEmpty(seats)){
                                redisUtils.set(key,seats);
                        }
                }
                List<SeatVo> seatVos=transferObjectIgnoreCaseList(seats,SeatVo.class);
                return seatVos;
        }

        /**
         * 查询座位数量
         * @param id
         * @return
         */
        public Integer selectseat_countByid(Integer id){
                Integer seat_count=seatMapper.selectseat_countByid(id);
                return seat_count;
        }

        public void updateSeat_count(Integer id,Integer seat_count){
                seatMapper.updateSeat_count(id,seat_count);
        }
}