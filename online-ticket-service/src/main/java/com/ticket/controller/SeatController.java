package com.ticket.controller;

import com.ticket.api.vo.SeatVo;
import com.ticket.service.impl.SeatImpl;
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
        @RequestMapping("/selectSeatByTrain_no")
        @ResponseBody
        public List<SeatVo> selectSeatByTrain_no(HttpServletRequest request){
                String train_no=request.getParameter("train_no");
                List<SeatVo> seatVos=seat.selectSeatByTrain_no(train_no);
                return seatVos;
        }


}