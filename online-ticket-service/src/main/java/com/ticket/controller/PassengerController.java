package com.ticket.controller;

import com.ticket.service.impl.PassengerImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/passenger")
public class PassengerController {
        private PassengerImpl passengerImpl;

        @Resource(name = "passengerImpl")
        public void setPassengerImpl(PassengerImpl passengerImpl) {
                this.passengerImpl = passengerImpl;
        }
}