package com.ticket.entity;

import java.io.Serializable;

public class Passenger implements Serializable{
        //主键 id
        private Integer id;
        //用户账号
        private String user_phone_num;
        //乘客账号
        private String passenger_phone_num;
        //乘客真实姓名
        private String passenger_real_name;
        //乘客身份证号
        private String passenger_id_num;
        //0-成人，1-学生，3-儿童
        private Integer passenger_type;
        //乘客地址
        private String passenger_address;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getPassenger_phone_num() {
                return passenger_phone_num;
        }

        public void setPassenger_phone_num(String passenger_phone_num) {
                this.passenger_phone_num = passenger_phone_num;
        }



        public String getUser_phone_num() {
                return user_phone_num;
        }

        public void setUser_phone_num(String user_phone_num) {
                this.user_phone_num = user_phone_num;
        }

        public String getPassenger_real_name() {
                return passenger_real_name;
        }

        public void setPassenger_real_name(String passenger_real_name) {
                this.passenger_real_name = passenger_real_name;
        }

        public String getPassenger_id_num() {
                return passenger_id_num;
        }

        public void setPassenger_id_num(String passenger_id_num) {
                this.passenger_id_num = passenger_id_num;
        }

        public Integer getPassenger_type() {
                return passenger_type;
        }

        public void setPassenger_type(Integer passenger_type) {
                this.passenger_type = passenger_type;
        }

        public String getPassenger_address() {
                return passenger_address;
        }

        public void setPassenger_address(String passenger_address) {
                this.passenger_address = passenger_address;
        }
}