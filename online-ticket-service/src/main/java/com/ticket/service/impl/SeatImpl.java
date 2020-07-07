package com.ticket.service.impl;

import com.ticket.dao.impl.SeatDaoImpl;
import com.ticket.service.SeatInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import javax.annotation.Resource;
@Transactional
@Service("seatImpl")
public class SeatImpl implements SeatInterface {
        private SeatDaoImpl seatDaoImpl;

        @Resource(name = "SeatDaoImpl")
        public void setSeatDaoImpl(SeatDaoImpl seatDaoImpl) {
                this.seatDaoImpl = seatDaoImpl;
        }
}