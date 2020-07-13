package com.ticket.mapper;

import com.ticket.entity.TrainInfor;
import com.ticket.utils.MyMapper;

import java.util.List;

public interface TrainInforMapper extends MyMapper<TrainInfor> {
        public List<TrainInfor> findAllTrainInfor();
}
