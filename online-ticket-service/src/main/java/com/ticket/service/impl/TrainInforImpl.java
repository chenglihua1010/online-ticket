package com.ticket.service.impl;


import com.ticket.dao.impl.TrainInforDaoImpl;
import com.ticket.service.TrainInforInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("trainInforImpl")
public class TrainInforImpl implements TrainInforInterface {
        private TrainInforDaoImpl trainInforDaoImpl;

        @Resource(name = "trainInforDaoImpl")
        public void setTrainInforDaoImpl(TrainInforDaoImpl trainInforDaoImpl) {
                this.trainInforDaoImpl = trainInforDaoImpl;
        }
}