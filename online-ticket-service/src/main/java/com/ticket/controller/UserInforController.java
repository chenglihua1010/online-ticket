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
                ModelAndView modelAndView=new ModelAndView();
                String userPhoneNum=request.getParameter("userPhoneNum");
                String userPassword=request.getParameter("userPassword");
                UserInforVo userInforVo=new UserInforVo();
                userInforVo.setUserPassword(userPassword);
                userInforVo.setUserPhoneNum(userPhoneNum);
                userInforImpl.addUser(userInforVo);
                return modelAndView;
        }
}