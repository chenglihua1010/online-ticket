package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.SeatInterface;
import com.ticket.api.vo.SeatVo;
import com.ticket.entity.Seat;
import com.ticket.mapper.SeatMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class SeatImpl extends BaseService implements SeatInterface {

        @Autowired
        SeatMapper seatMapper;

        /**
         * 根据列车编号查询座位信息
         * @return 座位信息表
         */
        @Override
        public List<SeatVo> selectSeatByTrain_no(String train_no) {
                List<Seat> seat =seatMapper.selectSeatByTrain_no(train_no);
                List<SeatVo> seatVos=transferObjectIgnoreCaseList(seat,SeatVo.class);
                return seatVos;
        }
}