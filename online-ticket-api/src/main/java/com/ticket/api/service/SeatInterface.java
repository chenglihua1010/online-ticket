package com.ticket.api.service;

import com.ticket.api.vo.SeatVo;

import java.util.List;

public interface SeatInterface {
        /**
         * 根据列车编号查询座位信息
         * @return
         */
        public List<SeatVo> selectSeatByTrain_no(String train_no);

//        /**
//         * 唯一座位
//         * @param id
//         * @return
//         */
//        public Integer selectSeatByid(Integer id);
}