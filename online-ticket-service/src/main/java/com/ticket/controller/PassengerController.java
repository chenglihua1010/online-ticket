package com.ticket.controller;


import com.alibaba.fastjson.JSONObject;
import com.ticket.api.vo.PassengerVo;
import com.ticket.api.vo.UserInforVo;
import com.ticket.entity.Passenger;
import com.ticket.service.impl.PassengerImpl;
import com.ticket.service.impl.UserInforImpl;
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
@RequestMapping("/passenger")
public class PassengerController {
        @Autowired
        PassengerImpl passengerImpl;

        @Autowired
        UserInforImpl userInforImpl;

        private static final Logger LOGGER= LoggerFactory.getLogger(PassengerController.class);


        @RequestMapping("/addPassenger")
        @ResponseBody
        public ModelAndView addPassenger(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String user_phone_num=request.getParameter("user_phone_num");
//                String passenger_phone_num=request.getParameter("passenger_phone_num");
                String passenger_real_name=request.getParameter("passenger_real_name");
                String passenger_id_num=request.getParameter("passenger_id_num");
                String passenger_type=request.getParameter("passenger_type");
                String passenger_address=request.getParameter("passenger_address");
                String idString=request.getParameter("id");
                try{
                        Integer passenger_typeInt=Integer.parseInt(passenger_type);
                        Integer id=Integer.parseInt(idString);
//                        PassengerVo passengerVo=new PassengerVo(user_phone_num,passenger_real_name,passenger_id_num,
//                                        passenger_typeInt,passenger_address);
                        PassengerVo passengerVo=new PassengerVo();
                        passengerVo.setUser_phone_num(user_phone_num);
                        passengerVo.setPassenger_real_name(passenger_real_name);
                        passengerVo.setPassenger_id_num(passenger_id_num);
                        passengerVo.setPassenger_type(passenger_typeInt);
                        passengerVo.setPassenger_address(passenger_address);
                        UserInforVo userInforVo=userInforImpl.findById(id);
                        passengerImpl.addPassenger(passengerVo);
                        LOGGER.info("PassengerController addPassenger bean={}",JSONObject.toJSONString(passengerVo));
                        modelAndView.addObject("userInforVo",userInforVo);
                        modelAndView.setViewName("index");
                }catch (Exception e){
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());
                }
//                passengerVo.setPassenger_phone_num(passenger_phone_num);
                return modelAndView;
        }

        @RequestMapping("/selectPassengerByuser_phone_num")
        @ResponseBody
        public ModelAndView selectPassengerByuser_phone_num(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String user_phone_num=request.getParameter("user_phone_num");
                String idString=request.getParameter("id");
                try{
                        List<PassengerVo> passengerVoList=passengerImpl.selectPassengerByuser_phone_num(user_phone_num);
                        Integer id=Integer.parseInt(idString);
                        UserInforVo userInforVo=userInforImpl.findById(id);
                        if(!ObjectUtils.isEmpty(passengerVoList)){
                                modelAndView.addObject("passengerVoList",passengerVoList);
                                modelAndView.addObject("userInforVo",userInforVo);
                                modelAndView.setViewName("passengerInfor");
                                LOGGER.info("PassengerController selectPassengerByuser_phone_num bean={}", JSONObject.toJSONString(passengerVoList));
                                LOGGER.info("PassengerController selectPassengerByuser_phone_num 参数={}", JSONObject.toJSONString(user_phone_num));
                        }else {
                                modelAndView.setViewName("error");
                        }
                }catch (Exception e){
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());
                }
                return modelAndView;
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