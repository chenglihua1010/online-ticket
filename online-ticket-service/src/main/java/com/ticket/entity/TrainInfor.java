package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "train_infor")
public class TrainInfor implements Serializable{
        //主键 id
        private Integer id;
        //列车编号
        private String traiNo;
        //列车车次
        private String trainNum;
        //列车类型 1-普快，2-特快 ，3-动车，4-高铁
        private Integer trainType;
        //车厢
        private Integer trainCarriages;
        //始发站
        private String trainStartStation;
        //终点站
        private String trainEndStation;
        //出发时间
        private Date trainStartTime;
        //到达时间
        private Date trainEndTime;
        //当日到达/次日到达
        private String trainArriveDay;
        //列车运行时间
        private String trainRunningTime;
        //列车运行状态 正常/晚点
        private String trainRunningType;
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
        public String getTraiNo() {
                return traiNo;
        }

        public void setTraiNo(String traiNo) {
                this.traiNo = traiNo;
        }
        @Column(name = "train_num")
        public String getTrainNum() {
                return trainNum;
        }

        public void setTrainNum(String trainNum) {
                this.trainNum = trainNum;
        }
        @Column(name = "train_type")
        public Integer getTrainType() {
                return trainType;
        }

        public void setTrainType(Integer trainType) {
                this.trainType = trainType;
        }
        @Column(name = "train_carriages")
        public Integer getTrainCarriages() {
                return trainCarriages;
        }

        public void setTrainCarriages(Integer trainCarriages) {
                this.trainCarriages = trainCarriages;
        }
        @Column(name = "train_start_station")
        public String getTrainStartStation() {
                return trainStartStation;
        }

        public void setTrainStartStation(String trainStartStation) {
                this.trainStartStation = trainStartStation;
        }
        @Column(name = "train_end_station")
        public String getTrainEndStation() {
                return trainEndStation;
        }

        public void setTrainEndStation(String trainEndStation) {
                this.trainEndStation = trainEndStation;
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
        @Column(name = "train_arrive_day")
        public String getTrainArriveDay() {
                return trainArriveDay;
        }

        public void setTrainArriveDay(String trainArriveDay) {
                this.trainArriveDay = trainArriveDay;
        }
        @Column(name = "train_running_time")
        public String getTrainRunningTime() {
                return trainRunningTime;
        }

        public void setTrainRunningTime(String trainRunningTime) {
                this.trainRunningTime = trainRunningTime;
        }
        @Column(name = "train_running_type")
        public String getTrainRunningType() {
                return trainRunningType;
        }

        public void setTrainRunningType(String trainRunningType) {
                this.trainRunningType = trainRunningType;
        }
}