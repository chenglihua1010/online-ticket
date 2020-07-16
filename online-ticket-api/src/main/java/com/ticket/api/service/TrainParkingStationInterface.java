package com.ticket.api.service;

import com.ticket.api.vo.TrainParkingStationVo;

import java.util.List;

public interface TrainParkingStationInterface {
        /**
         * 根据列车编号查询列车站点信息
         * @param train_no 列车编号
         * @return 列车站点信息
         */
        public List<TrainParkingStationVo> selectStationByTrain_no(String train_no);
}