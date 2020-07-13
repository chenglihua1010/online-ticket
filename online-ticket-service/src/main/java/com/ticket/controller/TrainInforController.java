package com.ticket.controller;

import com.ticket.api.vo.TrainInforVo;
import com.ticket.service.impl.TrainInforImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import java.util.List;

@Controller
@RequestMapping("/trianInfor")
public class TrainInforController {
        @Autowired
        TrainInforImpl trainInforImpl;
        @RequestMapping("/findAllTrainInfor")
        @ResponseBody
        public List<TrainInforVo> findAllTrainInfor(){
                List<TrainInforVo> trainInforVoList=trainInforImpl.findAllTrainInfor();
                System.out.println(trainInforVoList.size());
                return trainInforVoList;

        }

}