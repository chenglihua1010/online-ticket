package com.ticket.api.vo;



import java.io.Serializable;
import java.util.Date;

public class TrainInforVo implements Serializable{
        //主键 id
        private Integer id;
        //列车编号
        private String train_no;
        //列车车次
        private String train_num;
        //列车类型 1-普快，2-特快 ，3-动车，4-高铁
        private Integer train_type;
        //车厢
        private Integer train_carriages;
        //始发站
        private String train_start_station;
        //终点站
        private String train_end_station;
        //出发时间
        private Date train_start_time;
        //到达时间
        private Date train_end_time;
        //当日到达/次日到达
        private String train_arrive_day;
        //列车运行时间
        private String train_running_time;
        //列车运行状态 正常/晚点
        private Integer train_running_type;

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

        public Integer getTrain_type() {
                return train_type;
        }

        public void setTrain_type(Integer train_type) {
                this.train_type = train_type;
        }

        public Integer getTrain_carriages() {
                return train_carriages;
        }

        public void setTrain_carriages(Integer train_carriages) {
                this.train_carriages = train_carriages;
        }

        public String getTrain_start_station() {
                return train_start_station;
        }

        public void setTrain_start_station(String train_start_station) {
                this.train_start_station = train_start_station;
        }

        public String getTrain_end_station() {
                return train_end_station;
        }

        public void setTrain_end_station(String train_end_station) {
                this.train_end_station = train_end_station;
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

        public String getTrain_arrive_day() {
                return train_arrive_day;
        }

        public void setTrain_arrive_day(String train_arrive_day) {
                this.train_arrive_day = train_arrive_day;
        }

        public String getTrain_running_time() {
                return train_running_time;
        }

        public void setTrain_running_time(String train_running_time) {
                this.train_running_time = train_running_time;
        }

        public Integer getTrain_running_type() {
                return train_running_type;
        }

        public void setTrain_running_type(Integer train_running_type) {
                this.train_running_type = train_running_type;
        }
}