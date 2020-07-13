package com.ticket.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.TrainInforInterface;

import com.ticket.api.vo.TrainInforVo;

import com.ticket.entity.TrainInfor;
import com.ticket.mapper.TrainInforMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;


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
}
