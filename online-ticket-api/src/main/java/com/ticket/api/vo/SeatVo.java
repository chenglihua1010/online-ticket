package com.ticket.api.vo;

public class SeatVo {
        //主键 id
        private Integer id;
        //列车编号
        private String train_no;
        //车厢编号
        private String carriage_no;
        //座位类型 1-硬座 2-软卧 3-硬卧 4-一等座 5-二等座 6-商务座
        private Integer seat_type;
        //座位数量
        private Integer seat_count;
        //票价
        private Double seat_price;

        public Double getSeat_price() {
                return seat_price;
        }

        public void setSeat_price(Double seat_price) {
                this.seat_price = seat_price;
        }

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getTrain_no() {
                return train_no;
        }

        public void setTrain_no(String train_no) {
                this.train_no = train_no;
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

        public Integer getSeat_count() {
                return seat_count;
        }

        public void setSeat_count(Integer seat_count) {
                this.seat_count = seat_count;
        }
}