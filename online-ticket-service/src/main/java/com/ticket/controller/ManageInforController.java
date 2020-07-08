package com.ticket.controller;

import com.ticket.api.vo.ManageInforVo;


import com.ticket.service.impl.ManageInforImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manageInfor")
public class ManageInforController {

        @Autowired
        ManageInforImpl manageInforImpl;
        @RequestMapping("/findAllManageTicket")
        @ResponseBody
        public List<ManageInforVo> findAllManageTicket(){
                List<ManageInforVo> manageInforList=manageInforImpl.findAllManageTicket();
                System.out.println(manageInforList.size());
                return manageInforList;
        }

}