package com.ticket.mapper;

import com.ticket.entity.TrainInfor;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface TrainInforMapper extends MyMapper<TrainInfor> {

        public List<TrainInfor> findAllTrainInfor();

        public List<TrainInfor> findByTrain_num(@Param("train_num")String train_num);

//        public List<Map<String,Object>> findAllTrain_num();
        public List<String> findAllTrain_num();
}
