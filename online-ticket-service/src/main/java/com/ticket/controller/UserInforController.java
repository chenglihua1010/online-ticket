package com.ticket.controller;

import com.ticket.api.vo.UserInforVo;
import com.ticket.entity.UserInfor;
import com.ticket.service.impl.UserInforImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userInfor")
public class UserInforController {
        @Autowired
        UserInforImpl userInforImpl;
        @RequestMapping("/addUser")
        public ModelAndView addUser(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView("index");
                String user_phone_num=request.getParameter("user_phone_num");
                String user_password=request.getParameter("user_password");
                String userIdNumber=request.getParameter("userIdNumber");
//                String user_id_number=request.getParameter("user_id_number");



                UserInforVo userInforVo=new UserInforVo();
                userInforVo.setUser_phone_num(user_phone_num);
                userInforVo.setUser_password(user_password);
                userInforVo.setUserIdNumber(userIdNumber);
//                userInforVo.setUser_id_number(userIdNumber);

                userInforImpl.addUser(userInforVo);
                return modelAndView;
        }
}