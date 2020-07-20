package com.ticket.controller;

import com.ticket.api.vo.TrainInforVo;
import com.ticket.service.impl.TrainInforImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trianInfor")
public class TrainInforController {
        @Autowired
        TrainInforImpl trainInforImpl;

        private static final Logger LOGGER= LoggerFactory.getLogger(TrainInforController.class);


        @RequestMapping("/findAllTrainInfor")
        @ResponseBody
        public List<TrainInforVo> findAllTrainInfor(){

                List<TrainInforVo> trainInforVoList=trainInforImpl.findAllTrainInfor();

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

//        trian.jsp->trainList.jsp 获取出发地、目的地、出发时间 查询到 合适的列车 并将列车信息传给trainList.jsp
        @RequestMapping("/findAimTrainInfor")
        public ModelAndView findAimTrainInfor(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String train_start_station=request.getParameter("train_start_station");
                String train_end_station=request.getParameter("train_end_station");
                String train_start_time=request.getParameter("train_start_time");
//                Date train_start_timeDate=Dateu

                TrainInforVo trainInforVo=new TrainInforVo(train_start_station,train_end_station);
                List<TrainInforVo> trainInforVoList=trainInforImpl.findAimTrainInfor(trainInforVo);

                modelAndView.addObject("trainInfor",trainInforVoList.get(0));

                modelAndView.setViewName("trains-list");

                return modelAndView;

        }
}