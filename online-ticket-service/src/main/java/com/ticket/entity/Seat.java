package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "seat")
public class Seat implements Serializable{
        //主键 id
        private Integer id;
        //车厢编号
        private String carriageNo;
        //座位类型 1-硬座 2-软卧 3-硬卧 4-一等座 5-二等座 6-商务座
        private Integer seatType;
        //座位数量
        private String seatCount;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "carriage_no")
        public String getCarriageNo() {
                return carriageNo;
        }

        public void setCarriageNo(String carriageNo) {
                this.carriageNo = carriageNo;
        }
        @Column(name = "seat_type")
        public Integer getSeatType() {
                return seatType;
        }

        public void setSeatType(Integer seatType) {
                this.seatType = seatType;
        }
        @Column(name = "seat_count")
        public String getSeatCount() {
                return seatCount;
        }

        public void setSeatCount(String seatCount) {
                this.seatCount = seatCount;
        }
}