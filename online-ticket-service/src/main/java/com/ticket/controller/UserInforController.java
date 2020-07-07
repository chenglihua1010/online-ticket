package com.ticket.controller;

import com.ticket.entity.UserInfor;
import com.ticket.service.impl.UserInforImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/userInfor")
public class UserInforController {
        private UserInforImpl userInforImpl;
        @Resource(name = "userInforImpl")
        public void setUserInforImpl(UserInforImpl userInforImpl) {
                this.userInforImpl = userInforImpl;
        }

        @RequestMapping("/addUser")
        public ModelAndView addUser(HttpServletRequest request){
                ModelAndView modelAndView=new ModelAndView();
                userInforImpl.addUser();
                return modelAndView;
        }

}