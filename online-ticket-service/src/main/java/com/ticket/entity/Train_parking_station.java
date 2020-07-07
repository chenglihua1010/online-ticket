package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "train_parking_station")
public class Train_parking_station implements Serializable{
        //主键 id
        private Integer id;
        //列车编号
        private String trainNo;
        //列车车次
        private String trainNum;
        //当日到达/次日到达
        private String trainArriveDay;
        //出发时间
        private Date trainStartTime;
        //到达时间
        private Date trainEndTime;
        //列车运行时间
        private String trainRunningTime;
        //站点编号
        private String stationNo;
        // /站点名字
        private String stationName;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        @Column(name = "train_no")
        public String getTrainNo() {
                return trainNo;
        }

        public void setTrainNo(String trainNo) {
                this.trainNo = trainNo;
        }
        @Column(name = "train_num")
        public String getTrainNum() {
                return trainNum;
        }

        public void setTrainNum(String trainNum) {
                this.trainNum = trainNum;
        }
        @Column(name = "train_arrive_day")
        public String getTrainArriveDay() {
                return trainArriveDay;
        }

        public void setTrainArriveDay(String trainArriveDay) {
                this.trainArriveDay = trainArriveDay;
        }
        @Column(name = "train_start_time")
        public Date getTrainStartTime() {
                return trainStartTime;
        }

        public void setTrainStartTime(Date trainStartTime) {
                this.trainStartTime = trainStartTime;
        }
        @Column(name = "train_end_time")
        public Date getTrainEndTime() {
                return trainEndTime;
        }

        public void setTrainEndTime(Date trainEndTime) {
                this.trainEndTime = trainEndTime;
        }
        @Column(name = "train_running_time")
        public String getTrainRunningTime() {
                return trainRunningTime;
        }

        public void setTrainRunningTime(String trainRunningTime) {
                this.trainRunningTime = trainRunningTime;
        }
        @Column(name = "station_name")
        public String getStationNo() {
                return stationNo;
        }

        public void setStationNo(String stationNo) {
                this.stationNo = stationNo;
        }
        @Column(name = "id")
        public String getStationName() {
                return stationName;
        }

        public void setStationName(String stationName) {
                this.stationName = stationName;
        }
}