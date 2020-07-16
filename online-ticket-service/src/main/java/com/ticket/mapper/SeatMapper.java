package com.ticket.mapper;

import com.ticket.entity.Seat;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface SeatMapper extends MyMapper<Seat>{
        public List<Seat> selectSeatByTrain_no(@Param("train_no") String train_no);
}