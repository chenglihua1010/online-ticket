package com.ticket.entity;

import java.io.Serializable;

public class Seat implements Serializable{
        //主键 id
        private Integer id;
        //车厢编号
        private String carriage_no;
        //座位类型 1-硬座 2-软卧 3-硬卧 4-一等座 5-二等座 6-商务座
        private Integer seat_type;
        //座位数量
        private String seat_count;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getCarriage_no() {
                return carriage_no;
        }

        public void setCarriage_no(String carriage_no) {
                this.carriage_no = carriage_no;
        }

        public Integer getSeat_type() {
                return seat_type;
        }

        public void setSeat_type(Integer seat_type) {
                this.seat_type = seat_type;
        }

        public String getSeat_count() {
                return seat_count;
        }

        public void setSeat_count(String seat_count) {
                this.seat_count = seat_count;
        }
}