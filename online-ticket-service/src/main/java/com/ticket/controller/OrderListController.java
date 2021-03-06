package com.ticket.controller;


import com.alibaba.fastjson.JSONObject;
import com.sun.org.apache.xpath.internal.operations.Mod;
import com.ticket.api.vo.OrderListVo;
import com.ticket.api.vo.SeatVo;
import com.ticket.api.vo.TrainInforVo;
import com.ticket.api.vo.UserInforVo;
import com.ticket.service.impl.OrderListImpl;
import com.ticket.service.impl.RedisUtils;
import com.ticket.service.impl.SeatImpl;
import com.ticket.service.impl.UserInforImpl;
import com.ticket.utils.DateUtil;
import com.ticket.utils.ExecutorRegister;
import com.ticket.utils.RandomUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;


@Controller
@RequestMapping("/orderList")
public class OrderListController {

        private static ExecutorService executor = ExecutorRegister.register(Executors.newFixedThreadPool(2));


        private Object object = new Object();

        private char[] chars = new char[]{};

        private Lock lock = new ReentrantLock();

        private TrainInforVo trainInforVo;

        public TrainInforVo getTrainInforVo() {
                return trainInforVo;
        }

        public void setTrainInforVo(TrainInforVo trainInforVo) {
                this.trainInforVo = trainInforVo;
        }


        @Autowired
        OrderListImpl orderListImpl;
        @Autowired
        UserInforImpl userInforVoImpl;
        @Autowired
        SeatImpl seatImpl;
        @Autowired
        RedisUtils redisUtils;

        //注意引用的架包import org.slf4j.Logger; import org.slf4j.LoggerFactory;
        private static final Logger LOGGER = LoggerFactory.getLogger(OrderListController.class);

        @RequestMapping("/addOrder")
//        @ResponseBody
        public ModelAndView addOrder(HttpServletRequest request) {
                ModelAndView modelAndView = new ModelAndView();
                //接收对象？
//                String train_no=trainInforVo.getTrain_no();

                //trainInfor
                String train_no = request.getParameter("train_no");
                String train_num = request.getParameter("train_num");
                String start_station_name = request.getParameter("start_station_name");
                String end_station_name = request.getParameter("end_station_name");
                String train_start_time_string = request.getParameter("train_start_time_String");
                try {
                        //parase只识别yyyy-MM-dd HH:mm:ss
                        Date train_start_dateRealy = DateUtil.parase(train_start_time_string, DateUtil.DATEFORMATSECOND);
//                        Date train_start_dateRealy = new Date("train_start_time");
                        String train_start_dateString = DateUtil.getbeforeMinutesAnyDate(train_start_dateRealy, 30);
                        Date train_start_date = DateUtil.parase(train_start_dateString, DateUtil.DATEFORMATSECOND);
                        String train_start_date_String=DateUtil.format(train_start_date,DateUtil.DATEFORMATSECOND);
                        //userInfor
                        String user_phone_num = request.getParameter("user_phone_num");
                        //passengerInfor
                        String passenger_real_name = request.getParameter("passenger_real_name");
                        String passenger_id_num = request.getParameter("passenger_id_num");
                        String passenger_typeString = request.getParameter("passenger_type");
                        Integer passenger_type=Integer.parseInt(passenger_typeString);
//                        0-成人，1-学生，2-儿童  1-硬座 2-软卧 3-硬卧 4-一等座 5-二等座 6-商务座
                        //Seat
                        String seat_typeAndseat_priceString = request.getParameter("seat_type");
                        String[] seat_priceAndseat_priceList=seat_typeAndseat_priceString.split(",");
                        Integer seat_type=Integer.parseInt(seat_priceAndseat_priceList[0]);
                        Double seat_price=Double.parseDouble(seat_priceAndseat_priceList[1]);
                        Integer seat_count=Integer.parseInt(seat_priceAndseat_priceList[2]);
                        Integer id=Integer.parseInt(seat_priceAndseat_priceList[3]);
//                        String idString=request.getParameter("id");
//                        Integer id=Integer.parseInt(idString);
                        //更新座位数量
//                        Integer seat_count=seatImpl.selectseat_countByid(id);
                        seat_count-=1;
                        seatImpl.updateSeat_count(id,seat_count);
                        Double order_money;
//                        票价判断
                        if(passenger_type==2){
                                order_money=seat_price*0.5;
                        }else{
                                if(passenger_type==1){
                                        order_money=seat_price*0.75;
                                }else{
                                        order_money=seat_price;
                                }
                        }

                        String order_id = RandomUtil.getRandomNickname(10);
                        OrderListVo orderListVo = new OrderListVo();
                        orderListVo.setOrder_status(1);
                        orderListVo.setUser_phone_num(user_phone_num);
                        orderListVo.setPassenger_id_num(passenger_id_num);
                        orderListVo.setPassenger_real_name(passenger_real_name);
                        orderListVo.setTrain_no(train_no);
                        orderListVo.setTrain_num(train_num);
                        orderListVo.setStart_station_name(start_station_name);
                        orderListVo.setEnd_station_name(end_station_name);
                        orderListVo.setTrain_start_date(train_start_date);
                        orderListVo.setTrain_start_date_String(train_start_date_String);
                        orderListVo.setOrder_create_time(new Date());
                        orderListVo.setOrder_id(order_id);
                        orderListVo.setOrder_money(order_money);
                        orderListImpl.addOrder(orderListVo);
                        modelAndView.addObject("orderListVo",orderListVo);
                        modelAndView.setViewName("pay");


                        //====================锁==============================//
//                new Thread(new Runnable() {
//                        @Override
//                        public void run() {
//                                OrderListVo orderListVo=new OrderListVo();
//                                orderListVo.setOrder_id(order_id);
//                                orderListVo.setOrder_money(order_moneyDouble);
//                                orderListVo.setUser_phone_num(user_phone_num);
//                                orderListImpl.addOrder(orderListVo);
//                        }
//                }).start();
//
//                synchronized(chars){
//                        executor.execute(new Runnable() {
//                                @Override
//                                public void run() {
//                                        OrderListVo orderListVo=new OrderListVo();
//                                        orderListVo.setOrder_id(order_id);
//                                        orderListVo.setOrder_money(order_moneyDouble);
//                                        orderListVo.setUser_phone_num(user_phone_num);
//                                        orderListImpl.addOrder(orderListVo);
//                                }
//                        });
//                };
//                lock.lock();
//                try {
//                                        OrderListVo orderListVo=new OrderListVo();
//                                        orderListVo.setOrder_id(order_id);
//                                        orderListVo.setOrder_money(order_moneyDouble);
//                                        orderListVo.setUser_phone_num(user_phone_num);
//                                        orderListImpl.addOrder(orderListVo);
//                }catch (Exception e){
//                        lock.unlock();
//                     LOGGER.info("error exception", JSONObject.toJSONString(e.getMessage()));
//                }

                } catch (Exception e) {
                        e.printStackTrace();
                }
                return modelAndView;
        }

        @RequestMapping("/selectOrderByuser_phone_num")
//        @ResponseBody
        public List<OrderListVo> selectOrderByuser_phone_num(HttpServletRequest request) {
                String user_phone_num = request.getParameter("user_phone_num");

                List<OrderListVo> listVos = orderListImpl.selectOrderByUser_phone_num(user_phone_num);
//                listVos=Lists.newArrayList();
//                List<OrderListVo> listVos=Lists.newArrayList();
//                listVos=orderListImpl.selectOrderByUser_phone_num(user_phone_num);


                redisUtils.set("ceshi", listVos);
                return listVos;
        }

        /**
         * 查询用户部分订单信息
         *
         * @param request
         * @return
         */
        @RequestMapping("/selectPartOrderByUser_phone_num")
//        @ResponseBody
        public ModelAndView selectPartOrderByUser_phone_num(HttpServletRequest request) {
                String user_phone_num = request.getParameter("user_phone_num");
                String order_status = request.getParameter("order_status");
                Integer order_statusInt = Integer.parseInt(order_status);
                ModelAndView modelAndView = new ModelAndView();
                try {
                        List<OrderListVo> orderListVo = orderListImpl.selectPartOrderByUser_phone_num(user_phone_num, order_statusInt);
                        for(OrderListVo vo:orderListVo){
                                String train_start_dateString=DateUtil.format(vo.getTrain_start_date(),DateUtil.DATEFORMATSECOND);
                                vo.setTrain_start_date_String(train_start_dateString);
                        }
                        if (!ObjectUtils.isEmpty(orderListVo)) {
                                modelAndView.setViewName("aim-orderlist");
                                modelAndView.addObject("orderListVo", orderListVo);
                                //尝试记录日志：结果？ 参数
                                LOGGER.info("OrderListController selectPartOrderByUser_phone_num bean={}", JSONObject.toJSON(modelAndView));
                                LOGGER.info("OrderListController selectPartOrderByUser_phone_num bean={}",
                                                JSONObject.toJSON("参数user_phone_num:" + user_phone_num + "参数order_statusInt:" + order_statusInt));
                        } else {
                                modelAndView.setViewName("error");
                        }
                } catch (Exception e) {
                        e.printStackTrace();
                        LOGGER.error(e.getMessage());

                }
                return modelAndView;

        }


        @RequestMapping("preorder")
        @ResponseBody
        public TrainInforVo preorder(TrainInforVo trainInforVo, HttpServletRequest request) {
//                ModelAndView modelAndView=new ModelAndView();
                return trainInforVo;
//                modelAndView.addObject("trainInforList[1]",trainInforVo);
//                modelAndView.setViewName("preorder");
//                return modelAndView;
        }

        @RequestMapping("/topayAndtoIndex")
        public ModelAndView topayAndtoIndex(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String user_phone_num=request.getParameter("user_phone_num");
                String order_id=request.getParameter("order_id");
                Integer order_status=2;

                orderListImpl.updateOrder_status(order_status,order_id);
                UserInforVo userInforVo=userInforVoImpl.findById(2);
                modelAndView.addObject("userInforVo",userInforVo);
                modelAndView.setViewName("index");
                return modelAndView;

        }

        /**
         * 跳转到查询订单页面
         * @param request
         * @return
         */
        @RequestMapping("/toSelectOrder")
        public ModelAndView toSelectOrder(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                String idString=request.getParameter("id");
                Integer id=Integer.parseInt(idString);
                UserInforVo userInforVo=userInforVoImpl.findById(id);
                modelAndView.setViewName("selectorder");
                modelAndView.addObject("userInforVo",userInforVo);
                return modelAndView;
        }

}