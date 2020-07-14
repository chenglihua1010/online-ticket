package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "train_parking_station")
public class TrainParkingStation implements Serializable{
        private static final long serialVersionUID = 2332067275497743721L;
        //主键 id
        private Integer id;
        //列车编号
        private String train_no;
        //列车车次
        private String train_num;
        //当日到达/次日到达
        private String train_arrive_day;
        //出发时间
        private Date train_start_time;
        //到达时间
        private Date train_end_time;
        //列车运行时间
        private String train_running_time;
        //站点编号
        private String station_no;
        // /站点名字
        private String station_name;

        public TrainParkingStation(){};

        public TrainParkingStation(Integer id,String train_no,String train_num, String train_arrive_day,Date train_start_time,
                                   Date train_end_time,String train_running_time,String station_no,String station_name){
                this.id=id;
                this.train_no=train_no;
                this.train_num=train_num;
                this.train_arrive_day=train_arrive_day;
                this.train_start_time=train_start_time;
                this.train_end_time=train_end_time;
                this.train_running_time=train_running_time;
                this.station_no=station_no;
                this.station_name=station_name;
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

        public String getTrain_num() {
                return train_num;
        }

        public void setTrain_num(String train_num) {
                this.train_num = train_num;
        }

        public String getTrain_arrive_day() {
                return train_arrive_day;
        }

        public void setTrain_arrive_day(String train_arrive_day) {
                this.train_arrive_day = train_arrive_day;
        }

        public Date getTrain_start_time() {
                return train_start_time;
        }

        public void setTrain_start_time(Date train_start_time) {
                this.train_start_time = train_start_time;
        }

        public Date getTrain_end_time() {
                return train_end_time;
        }

        public void setTrain_end_time(Date train_end_time) {
                this.train_end_time = train_end_time;
        }

        public String getTrain_running_time() {
                return train_running_time;
        }

        public void setTrain_running_time(String train_running_time) {
                this.train_running_time = train_running_time;
        }

        public String getStation_no() {
                return station_no;
        }

        public void setStation_no(String station_no) {
                this.station_no = station_no;
        }

        public String getStation_name() {
                return station_name;
        }

        public void setStation_name(String station_name) {
                this.station_name = station_name;
        }
}