package com.ticket.api.service;

import com.ticket.api.vo.TrainInforVo;


import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TrainInforInterface {
        /**
         * 查询所有列车信息
         * @return 列车信息表
         */
        public List<TrainInforVo> findAllTrainInfor();

        /**
         *  根据车次查询列车信息
         * @param train_num 列车车次
         * @return 列车信息
         */
        public List<TrainInforVo> findByTrain_num(String train_num);

        /**
         * 查询所有列车车次
         * @return 列车车次
         */
//        public List<Map<String,Object>> findAllTrain_num();
        public List<String> findAllTrain_num();

        /**
         *  查询目的列车
         * @param train_start_station 起始站
         * @param train_end_station 终点站
         * @return 列车信息
         */
        public List<TrainInforVo> findAimTrainInfor(String train_start_station, String train_end_station);


        public List<TrainInforVo> findAimTrainforByfourParam(String train_start_station, String train_end_station,Date train_start_time,Integer train_type);
}