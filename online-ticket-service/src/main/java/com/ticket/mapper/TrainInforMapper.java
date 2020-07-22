package com.ticket.mapper;

import com.ticket.entity.TrainInfor;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;
import java.util.Map;

public interface TrainInforMapper extends MyMapper<TrainInfor> {

        public List<TrainInfor> findAllTrainInfor();

        public List<TrainInfor> findByTrain_num(@Param("train_num")String train_num);

//        public List<Map<String,Object>> findAllTrain_num();
        public List<String> findAllTrain_num();

        public List<TrainInfor> findAimTrainInfor(@Param("train_start_station") String train_start_station ,@Param("train_end_station") String train_end_station);
        public List<TrainInfor> findAimTrainforByfourParam(@Param("train_start_station") String train_start_station , @Param("train_end_station") String train_end_station,
                                                           @Param("train_start_time")Date train_start_time,@Param("train_type") Integer train_type);
}
