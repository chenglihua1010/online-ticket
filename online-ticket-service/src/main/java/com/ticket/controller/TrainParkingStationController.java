package com.ticket.controller;

import com.alibaba.dubbo.common.json.JSONObject;
import com.ticket.api.vo.TrainParkingStationVo;
import com.ticket.service.impl.RedisService;
import com.ticket.service.impl.TrainParkingStationImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/trainParkingStation")
public class TrainParkingStationController {
        @Autowired
        RedisService redisService;
        @Autowired
        TrainParkingStationImpl trainParkingStationImpl;
        @RequestMapping("/selectStation")
        @ResponseBody
        public List<TrainParkingStationVo> selectStationByTrain_no(HttpServletRequest request){
                String train_no=request.getParameter("train_no");

                List<TrainParkingStationVo> voList=trainParkingStationImpl.selectStationByTrain_no(train_no);
//                redisService.setList(train_no,voList);
//                redisService.setList(train_no.toString(),JSONObject.to)

                return voList;
        }

}