package com.ticket.mapper;

import com.ticket.entity.TrainParkingStation;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface TrainParkingStationMapper extends MyMapper<TrainParkingStation>{
        /**
         * 根据列车编号查询列车站点信息
         * @param train_no 列车编号
         * @return 列车站点信息
         */
        public List<TrainParkingStation> selectStationByTrain_no(@Param("train_no") String train_no);
}