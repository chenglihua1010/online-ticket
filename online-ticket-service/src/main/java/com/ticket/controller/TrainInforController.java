package com.ticket.controller;

import com.ticket.service.impl.TrainInforImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/trianInfor")
public class TrainInforController {
        private TrainInforImpl trainInforImpl;

        @Resource(name = "trainInforImpl")
        public void setTrainInforImpl(TrainInforImpl trainInforImpl) {
                this.trainInforImpl = trainInforImpl;
        }
}