package com.ticket.service.impl;

import com.ticket.dao.impl.PassengerDaoImpl;
import com.ticket.service.PassengerInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("passengerImpl")
public class PassengerImpl implements PassengerInterface{
        private PassengerDaoImpl passengerDaoImpl;
        @Resource(name = "passengerDaoImpl")
        public void setPassengerDaoImpl(PassengerDaoImpl passengerDaoImpl) {
                this.passengerDaoImpl = passengerDaoImpl;
        }
}