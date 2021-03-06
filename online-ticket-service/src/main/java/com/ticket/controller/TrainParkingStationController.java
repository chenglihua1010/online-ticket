package com.ticket.controller;


import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ticket.api.vo.TrainInforVo;
import com.ticket.api.vo.TrainParkingStationVo;
import com.ticket.service.impl.RedisService;
import com.ticket.service.impl.TrainParkingStationImpl;
import com.ticket.utils.DateUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/trainParkingStation")
public class TrainParkingStationController {
        @Autowired
        TrainParkingStationImpl trainParkingStationImpl;

        private static final Logger LOGGER= LoggerFactory.getLogger("TrainParkingStationController");

        @RequestMapping("/selectStationByTrain_no")
        public ModelAndView selectStationByTrain_no(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String train_no=request.getParameter("train_no");
                try{
                        List<TrainParkingStationVo> trainParkingStationVoList=trainParkingStationImpl.selectStationByTrain_no(train_no);
                        for (TrainParkingStationVo vo:trainParkingStationVoList) {
                                String train_start_timeString= DateUtil.format(vo.getTrain_start_time(),DateUtil.DATEFORMATSECOND);
                                vo.setTrain_start_timeString(train_start_timeString);
                                String train_end_timeString=DateUtil.format(vo.getTrain_end_time(),DateUtil.DATEFORMATSECOND);
                                vo.setTrain_end_timeString(train_end_timeString);
                        }
                        if(!ObjectUtils.isEmpty(trainParkingStationVoList)){
                                modelAndView.addObject("trainParkingStationVoList",trainParkingStationVoList);
                                modelAndView.setViewName("aim-train");
                                LOGGER.info("TrainParkingStationController selectStationByTrain_no bean={}", JSONObject.toJSONString(trainParkingStationVoList));
                                LOGGER.info("TrainParkingStationController selectStationByTrain_no param={}", JSONObject.toJSONString(train_no));
                        }
                }catch(Exception e){
                        e.printStackTrace();
                }

                return modelAndView;
        }

}