package com.ticket.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.TrainInforInterface;

import com.ticket.api.vo.TrainInforVo;

import com.ticket.entity.TrainInfor;
import com.ticket.mapper.TrainInforMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Map;


@Service
public class TrainInforImpl extends BaseService implements TrainInforInterface {

        @Autowired
        TrainInforMapper trainInforMapper;

        /**
         * 查询列车信息
         * @return 列车信息表
          */
        @Override
        public List<TrainInforVo> findAllTrainInfor() {
                List<TrainInfor> userInforList=trainInforMapper.findAllTrainInfor();
                List<TrainInforVo> trainInforVoList = transferObjectIgnoreCaseList(userInforList,TrainInforVo.class);
                return trainInforVoList;
        }

        /**
         * 根据车次查询列车
         * @param train_num 列车车次
         * @return 列车信息
         */
        @Override
        public List<TrainInforVo> findByTrain_num(String train_num) {
                List<TrainInfor> trainInforList=trainInforMapper.findByTrain_num(train_num);
                List<TrainInforVo> trainInforVoList=transferObjectIgnoreCaseList(trainInforList,TrainInforVo.class);
                return trainInforVoList;
        }

        /**
         * 查询所有列车车次信息
         * @return 车次
         */
        @Override
        public List<Map<String,Object>> findAllTrain_num() {
                List<Map<String,Object>> list=trainInforMapper.findAllTrain_num();
                return list;
        }

}
