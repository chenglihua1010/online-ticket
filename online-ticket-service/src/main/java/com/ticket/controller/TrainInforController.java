package com.ticket.controller;

import com.ticket.api.vo.TrainInforVo;
import com.ticket.service.impl.TrainInforImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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

        @RequestMapping("/findByTrain_num")
        @ResponseBody
        public List<TrainInforVo> findByTrain_num(HttpServletRequest request){
                String train_num=request.getParameter("train_num");
                List<TrainInforVo> trainInforVoList=trainInforImpl.findByTrain_num(train_num);
                return trainInforVoList;
        }

        //接收指定字段(resultMap与resultType)
//        @RequestMapping("/findAllTrain_num")
//        @ResponseBody
//        public List<Map<String,Object>> findAllTrain_num(){
//                List<Map<String,Object>> list =trainInforImpl.findAllTrain_num();
//                return list;
//        }
        @RequestMapping("/findAllTrain_num")
        @ResponseBody
        public List<String> findAllTrain_num(){
                List<String> list =trainInforImpl.findAllTrain_num();
                return list;
        }
}