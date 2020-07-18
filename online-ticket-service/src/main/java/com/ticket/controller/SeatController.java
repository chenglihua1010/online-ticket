package com.ticket.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticket.api.vo.SeatVo;
import com.ticket.service.impl.SeatImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/seat")
public class SeatController {
        @Autowired
        SeatImpl seat;


        private static final Logger LOGGER= LoggerFactory.getLogger(SeatController.class);

        @RequestMapping("/selectSeatByTrain_no")
        @ResponseBody
        public List<SeatVo> selectSeatByTrain_no(HttpServletRequest request){
                String train_no=request.getParameter("train_no");

                List<SeatVo> seatVos=seat.selectSeatByTrain_no(train_no);
                LOGGER.info("SeatController selectSeatByTrain_no bean ={}", JSONObject.toJSON(seatVos));
                LOGGER.info("SeatController selectSeatByTrain_no bean ={}", JSONObject.toJSON("参数train_no:"+train_no));

                return seatVos;
        }


}