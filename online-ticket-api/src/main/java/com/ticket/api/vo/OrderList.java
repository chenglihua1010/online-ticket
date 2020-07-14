package com.ticket.api.vo;

import java.util.Date;

public class OrderList {
        //主键 id
        private Integer id;
        //订单号
        private Integer order_id;
        //用户账号
        private String user_phone_num;
        //乘客手机号
        private String passenger_phone_num;
        //乘客身份证号
        private String passenger_id_num;
        //车号（列车编号)
        private String train_no;
        //初始站站编号
        private String start_station_no;
        //初始站名字
        private String start_station_name;
        //终点站编号
        private String end_station_no;
        //终点站名字
        private String end_station_name;
        //车厢编号
        private String carriage_no;
        //座位号
        private String seat_no;
        //订单价格
        private String order_money;
        //订单时间
        private Date order_create_time;
        //订单状态
        private String order_status;
        //搭乘时间
        private Date train_start_date;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public Integer getOrder_id() {
                return order_id;
        }

        public void setOrder_id(Integer order_id) {
                this.order_id = order_id;
        }

        public String getUser_phone_num() {
                return user_phone_num;
        }

        public void setUser_phone_num(String user_phone_num) {
                this.user_phone_num = user_phone_num;
        }

        public String getPassenger_phone_num() {
                return passenger_phone_num;
        }

        public void setPassenger_phone_num(String passenger_phone_num) {
                this.passenger_phone_num = passenger_phone_num;
        }

        public String getPassenger_id_num() {
                return passenger_id_num;
        }

        public void setPassenger_id_num(String passenger_id_num) {
                this.passenger_id_num = passenger_id_num;
        }

        public String getTrain_no() {
                return train_no;
        }

        public void setTrain_no(String train_no) {
                this.train_no = train_no;
        }

        public String getStart_station_no() {
                return start_station_no;
        }

        public void setStart_station_no(String start_station_no) {
                this.start_station_no = start_station_no;
        }

        public String getStart_station_name() {
                return start_station_name;
        }

        public void setStart_station_name(String start_station_name) {
                this.start_station_name = start_station_name;
        }

        public String getEnd_station_name() {
                return end_station_name;
        }

        public void setEnd_station_name(String end_station_name) {
                this.end_station_name = end_station_name;
        }

        public String getEnd_station_no() {
                return end_station_no;
        }

        public void setEnd_station_no(String end_station_no) {
                this.end_station_no = end_station_no;
        }

        public String getCarriage_no() {
                return carriage_no;
        }

        public void setCarriage_no(String carriage_no) {
                this.carriage_no = carriage_no;
        }

        public String getSeat_no() {
                return seat_no;
        }

        public void setSeat_no(String seat_no) {
                this.seat_no = seat_no;
        }

        public String getOrder_money() {
                return order_money;
        }

        public void setOrder_money(String order_money) {
                this.order_money = order_money;
        }

        public Date getOrder_create_time() {
                return order_create_time;
        }

        public void setOrder_create_time(Date order_create_time) {
                this.order_create_time = order_create_time;
        }

        public String getOrder_status() {
                return order_status;
        }

        public void setOrder_status(String order_status) {
                this.order_status = order_status;
        }

        public Date getTrain_start_date() {
                return train_start_date;
        }

        public void setTrain_start_date(Date train_start_date) {
                this.train_start_date = train_start_date;
        }
}