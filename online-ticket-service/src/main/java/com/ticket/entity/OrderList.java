package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "order_list")
public class OrderList implements Serializable{
        //主键 id
        private Integer id;
        //订单号
        private Integer orderId;
        //用户账号
        private String userPhoneNum;
        //乘客手机号
        private String passengerPhoneNum;
        //乘客身份证号
        private String passengerIdNum;
        //车号（列车编号)
        private String trainNo;
        //初始站站编号
        private String startSationNo;
        //初始站名字
        private String startStationName;
        //终点站编号
        private String endStationNo;
        //终点站名字
        private String endStationName;
        //车厢编号
        private String carriageNo;
        //座位号
        private String seatNo;
        //订单价格
        private String orderMoney;
        //订单时间
        private Date orderCreateTime;
        //订单状态
        private String orderStatus;
        //搭乘时间
        private Date trainStartDate;
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "order_id")
        public Integer getOrderId() {
                return orderId;
        }

        public void setOrderId(Integer orderId) {
                this.orderId = orderId;
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
        @Column(name = "passenger_id_num")
        public String getPassengerIdNum() {
                return passengerIdNum;
        }

        public void setPassengerIdNum(String passengerIdNum) {
                this.passengerIdNum = passengerIdNum;
        }

        @Column(name = "train_no")
        public String getTrainNo() {
                return trainNo;
        }

        public void setTrainNo(String trainNo) {
                this.trainNo = trainNo;
        }
        @Column(name = "start_station_no")
        public String getStartSationNo() {
                return startSationNo;
        }

        public void setStartSationNo(String startSationNo) {
                this.startSationNo = startSationNo;
        }

        @Column(name = "start_station_name")
        public String getStartStationName() {
                return startStationName;
        }

        public void setStartStationName(String startStationName) {
                this.startStationName = startStationName;
        }
        @Column(name = "end_station_no")
        public String getEndStationNo() {
                return endStationNo;
        }

        public void setEndStationNo(String endStationNo) {
                this.endStationNo = endStationNo;
        }

        @Column(name = "end_station_name")
        public String getEndStationName() {
                return endStationName;
        }

        public void setEndStationName(String endStationName) {
                this.endStationName = endStationName;
        }
        @Column(name = "carriage_no")
        public String getCarriageNo() {
                return carriageNo;
        }

        public void setCarriageNo(String carriageNo) {
                this.carriageNo = carriageNo;
        }
        @Column(name = "seat_no")
        public String getSeatNo() {
                return seatNo;
        }

        public void setSeatNo(String seatNo) {
                this.seatNo = seatNo;
        }
        @Column(name = "order_money")
        public String getOrderMoney() {
                return orderMoney;
        }


        public void setOrderMoney(String orderMoney) {
                this.orderMoney = orderMoney;
        }
        @Column(name = "order_create_time")
        public Date getOrderCreateTime() {
                return orderCreateTime;
        }

        public void setOrderCreateTime(Date orderCreateTime) {
                this.orderCreateTime = orderCreateTime;
        }

        @Column(name = "order_status")
        public String getOrderStatus() {
                return orderStatus;
        }
        public void setOrderStatus(String orderStatus) {
                this.orderStatus = orderStatus;
        }

        @Column(name = "train_start_date")
        public Date getTrainStartDate() {
                return trainStartDate;
        }
        public void setTrainStartDate(Date trainStartDate) {
                this.trainStartDate = trainStartDate;
        }
}