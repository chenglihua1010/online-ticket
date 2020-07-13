package com.ticket.api.service;

import com.ticket.api.vo.TrainInforVo;


import java.util.List;

public interface TrainInforInterface {
        /**
         * 查用所有列车信息
         * @return 列车信息表
         */
        public List<TrainInforVo> findAllTrainInfor();
}