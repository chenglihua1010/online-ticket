package com.ticket.controller;

import com.alibaba.fastjson.JSONObject;
import com.ticket.api.vo.PassengerVo;
import com.ticket.api.vo.SeatVo;
import com.ticket.api.vo.TrainInforVo;
import com.ticket.entity.Passenger;
import com.ticket.service.impl.PassengerImpl;
import com.ticket.service.impl.SeatImpl;
import com.ticket.service.impl.TrainInforImpl;
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
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/trianInfor")
public class TrainInforController {
        @Autowired
        TrainInforImpl trainInforImpl;
        @Autowired
        SeatImpl seatImpl;
        @Autowired
        PassengerImpl passengerImpl;

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

// 2020 07 20  trian.jsp->trainList.jsp 获取出发地、目的地、出发时间 查询到 合适的列车 并将列车信息传给trainList.jsp
// 2020 07 21 预订单：需传座位信息、乘客信息
        @RequestMapping("/findAimTrainInfor")
        public ModelAndView findAimTrainInfor(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String train_start_station=request.getParameter("train_start_station");
                String train_end_station=request.getParameter("train_end_station");
                String train_start_time=request.getParameter("train_start_time");

                String user_phone_num=request.getParameter("user_phone_num");
                //时间的获取方式
//                Date train_start_timeDate=Dateu
                try{
                        List<TrainInforVo> trainInforVoList=trainInforImpl.findAimTrainInfor(train_start_station,train_end_station);
                        List<PassengerVo> passengerVoList=passengerImpl.selectPassengerByuser_phone_num(user_phone_num);
                        String train_no=trainInforVoList.get(1).getTrain_no();//
                        List<SeatVo> seatVoList=seatImpl.selectSeatByTrain_no(train_no);

                        if(!ObjectUtils.isEmpty(trainInforVoList)){
//                                modelAndView.addObject("trainInfor",trainInforVoList.get(1));
                                for (TrainInforVo vo:trainInforVoList) {
                                        String train_start_time_String= DateUtil.format(vo.getTrain_start_time(),DateUtil.DATEFORMATSECOND);
                                        vo.setTrain_start_time_String(train_start_time_String);
                                         String train_end_time_String=DateUtil.format(vo.getTrain_end_time(),DateUtil.DATEFORMATSECOND);
                                        vo.setTrain_end_time_String(train_end_time_String);
                                }

                                modelAndView.addObject("trainInforList",trainInforVoList);

                                modelAndView.addObject("seat",seatVoList.get(0));
                                modelAndView.addObject("passenger",passengerVoList.get(0));
                                modelAndView.setViewName("trains-list");
                                LOGGER.info("TrainInforController findAimTrainInfor bean={}", JSONObject.toJSON(trainInforVoList));
                                LOGGER.info("TrainInforController findAimTrainInfor bean={}", JSONObject.toJSON("参数train_start_station："+train_start_station+
                                                "参数train_end_station"+train_end_station));

                                LOGGER.info("TrainInforController findAimTrainInfor 参数train_start_station={}，参数train_end_station={},passengerVoList={}", JSONObject.toJSONString(train_start_station),JSONObject.toJSONString(train_end_station),JSONObject.toJSONString(passengerVoList));
                        }
                }catch (Exception e){
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());
                }

                return modelAndView;

        }
}