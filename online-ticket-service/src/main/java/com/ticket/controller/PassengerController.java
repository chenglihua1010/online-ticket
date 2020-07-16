package com.ticket.controller;

import com.ticket.api.vo.PassengerVo;
import com.ticket.entity.Passenger;
import com.ticket.service.impl.PassengerImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
        @Autowired
        PassengerImpl passengerImpl;

        @RequestMapping("/addPassenger")
        @ResponseBody
        public PassengerVo addPassenger(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                String passenger_phone_num=request.getParameter("passenger_phone_num");

                PassengerVo passengerVo=new PassengerVo();
                passengerVo.setUser_phone_num(user_phone_num);
                passengerVo.setPassenger_phone_num(passenger_phone_num);
                passengerImpl.addPassenger(passengerVo);
                return passengerVo;
        }

        @RequestMapping("/selectPassengerByuser_phone_num")
        @ResponseBody
        public List<PassengerVo> selectPassengerByuser_phone_num(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                List<PassengerVo> passengerVoList=passengerImpl.selectPassengerByuser_phone_num(user_phone_num);
                return passengerVoList;
        }

        @RequestMapping("/deletPassenger")
        @ResponseBody
        public String deletPassenger(HttpServletRequest request){
                String user_phone_num=request.getParameter("user_phone_num");
                String passenger_phone_num=request.getParameter("passenger_phone_num");
                passengerImpl.deletPassenger(user_phone_num,passenger_phone_num);
                return "删除成功";
        }
}