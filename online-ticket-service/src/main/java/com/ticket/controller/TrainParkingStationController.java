package com.ticket.controller;

import com.ticket.service.impl.TrainParkingStationImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/trainParkingStation")
public class TrainParkingStationController {
        private TrainParkingStationImpl trainParkingStationImpl;

        @Resource(name = "trainParkingStationImpl")
        public void setTrainParkingStationImpl(TrainParkingStationImpl trainParkingStationImpl) {
                this.trainParkingStationImpl = trainParkingStationImpl;
        }
}