package com.ticket.service.impl;

import com.ticket.dao.impl.TrainParkingStationDaoImpl;
import com.ticket.service.TrainParkingStationInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("trainParkingStationImpl")
public class TrainParkingStationImpl implements TrainParkingStationInterface{

        private TrainParkingStationDaoImpl trainParkingStationDaoImpl;
        @Resource(name = "trainParkingStationDaoImpl")
        public void setTrainParkingStationDaoImpl(TrainParkingStationDaoImpl trainParkingStationDaoImpl) {
                this.trainParkingStationDaoImpl = trainParkingStationDaoImpl;
        }
}
