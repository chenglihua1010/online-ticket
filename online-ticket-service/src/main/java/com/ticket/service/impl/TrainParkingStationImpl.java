package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.TrainParkingStationInterface;
import com.ticket.api.vo.TrainParkingStationVo;
import com.ticket.entity.TrainParkingStation;
import com.ticket.mapper.TrainParkingStationMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;


@Service
public class TrainParkingStationImpl extends BaseService implements TrainParkingStationInterface {


        @Autowired
        TrainParkingStationMapper trainParkingStationMapper;
        @Autowired
        RedisUtils redisUtils;
        @Override
        public List<TrainParkingStationVo> selectStationByTrain_no(String train_no) {
                String method="selectStationByTrain_no";
                String param=train_no;
                String key=redisUtils.keyBuilder(method,param);
                List<TrainParkingStation> trainParkingStationList;
                Object trainInforFromRedis=redisUtils.get(key);
                if(!ObjectUtils.isEmpty(trainInforFromRedis)){
                        trainParkingStationList=(List<TrainParkingStation>) trainInforFromRedis;
                }else{
                        trainParkingStationList=trainParkingStationMapper.selectStationByTrain_no(train_no);
                        if(!ObjectUtils.isEmpty(trainParkingStationList)){
                                redisUtils.set(key,trainParkingStationList);
                        }
                }
                List<TrainParkingStationVo> trainParkingStationVoList=transferObjectIgnoreCaseList(trainParkingStationList,TrainParkingStationVo.class);
                return trainParkingStationVoList;

        }
}
