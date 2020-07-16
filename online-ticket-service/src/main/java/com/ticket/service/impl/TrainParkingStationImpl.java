package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.TrainParkingStationInterface;
import com.ticket.api.vo.TrainParkingStationVo;
import com.ticket.entity.TrainParkingStation;
import com.ticket.mapper.TrainParkingStationMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


@Service
public class TrainParkingStationImpl extends BaseService implements TrainParkingStationInterface {


        @Autowired
        TrainParkingStationMapper trainParkingStationMapper;
        @Override
        public List<TrainParkingStationVo> selectStationByTrain_no(String train_no) {
                List<TrainParkingStation> trainParkingStationList=trainParkingStationMapper.selectStationByTrain_no(train_no);
                List<TrainParkingStationVo> trainParkingStationVoList=transferObjectIgnoreCaseList(trainParkingStationList,TrainParkingStationVo.class);
                return trainParkingStationVoList;

        }
}
