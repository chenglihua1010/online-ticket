package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "passenger")
public class Passenger implements Serializable{
        //主键 id
        private Integer id;
        //用户账号
        private String userPhoneNum;
        //乘客账号
        private String passengerPhoneNum;
        //乘客真实姓名
        private String passengerRealName;
        //乘客身份证号
        private String passengerIdNum;
        //0-成人，1-学生，3-儿童
        private Integer passengerType;
        //乘客地址
        private String passengerAddress;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "user_phone_num")
        public String getUserPhoneNum() {
                return userPhoneNum;
        }

        public void setUserPhoneNum(String userPhoneNum) {
                this.userPhoneNum = userPhoneNum;
        }
        @Column(name = "passenger_phone_num")
        public String getPassengerPhoneNum() {
                return passengerPhoneNum;
        }

        public void setPassengerPhoneNum(String passengerPhoneNum) {
                this.passengerPhoneNum = passengerPhoneNum;
        }
        @Column(name = "passenger_real_name")
        public String getPassengerRealName() {
                return passengerRealName;
        }

        public void setPassengerRealName(String passengerRealName) {
                this.passengerRealName = passengerRealName;
        }
        @Column(name = "passenger_id_num")
        public String getPassengerIdNum() {
                return passengerIdNum;
        }

        public void setPassengerIdNum(String passengerIdNum) {
                this.passengerIdNum = passengerIdNum;
        }
        @Column(name = "passenger_type")
        public Integer getPassengerType() {
                return passengerType;
        }

        public void setPassengerType(Integer passengerType) {
                this.passengerType = passengerType;
        }
        @Column(name = "passenger_address")
        public String getPassengerAddress() {
                return passengerAddress;
        }

        public void setPassengerAddress(String passengerAddress) {
                this.passengerAddress = passengerAddress;
        }
}