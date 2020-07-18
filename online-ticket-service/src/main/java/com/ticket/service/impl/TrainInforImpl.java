package com.ticket.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.TrainInforInterface;

import com.ticket.api.vo.TrainInforVo;

import com.ticket.entity.TrainInfor;
import com.ticket.mapper.TrainInforMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;

import java.util.List;
import java.util.Map;


@Service
public class TrainInforImpl extends BaseService implements TrainInforInterface {

        @Autowired
        TrainInforMapper trainInforMapper;
        @Autowired
        RedisUtils redisUtils;

        /**
         * 查询列车信息
         * @return 列车信息表
          */
        @Override
        public List<TrainInforVo> findAllTrainInfor() {
                String method="findAllTrainInfor";
                String key = redisUtils.keyBuilder(method);
                Object trainInforFromRedis=redisUtils.get(key);
                List<TrainInfor> userInforList;
                if(!ObjectUtils.isEmpty(trainInforFromRedis)){
                        userInforList=(List<TrainInfor>) trainInforFromRedis;
                }else{
                        userInforList=trainInforMapper.findAllTrainInfor();
                        if(!ObjectUtils.isEmpty(userInforList))
                                redisUtils.set(key,userInforList);
                }
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

//        /**
//         * 查询所有列车车次信息
//         * @return 车次
//         */
//        @Override
//        public List<Map<String,Object>> findAllTrain_num() {
//                List<Map<String,Object>> list=trainInforMapper.findAllTrain_num();
//                return list;
//        }
        /**
         * 查询所有列车车次信息
         * @return 车次
         */
        @Override
        public List<String> findAllTrain_num() {
                List<String> list=trainInforMapper.findAllTrain_num();
                return list;
        }

}
