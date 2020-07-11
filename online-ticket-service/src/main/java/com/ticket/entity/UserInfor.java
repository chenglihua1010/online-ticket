package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;
@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "user_infor")
public class UserInfor implements Serializable{
        //主键 id
        private Integer id;
        //账号(手机号作为账号)
        private String user_phone_num;
        //密码
        private String user_password;
        //用户邮箱
        private String user_email;
        //用户真实姓名
        private String user_real_name;
        //0-成人，1-学生，3-儿童
        private Integer user_type;
        //身份证号
        private String user_id_number;

        //测试不同名，数据传输
//        private String userIdNumber;
        //0-女，1-男
        private Integer user_gender;
        //用户地址
        private String user_address;


        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }

        public String getUser_phone_num() {
                return user_phone_num;
        }

        public void setUser_phone_num(String user_phone_num) {
                this.user_phone_num = user_phone_num;
        }

        public String getUser_address() {
                return user_address;
        }

        public void setUser_address(String user_address) {
                this.user_address = user_address;
        }

        public String getUser_password() {
                return user_password;
        }

        public void setUser_password(String user_password) {
                this.user_password = user_password;
        }

        public String getUser_email() {
                return user_email;
        }

        public void setUser_email(String user_email) {
                this.user_email = user_email;
        }

        public Integer getUser_gender() {
                return user_gender;
        }

        public void setUser_gender(Integer user_gender) {
                this.user_gender = user_gender;
        }

        public Integer getUser_type() {
                return user_type;
        }

        public void setUser_type(Integer user_type) {
                this.user_type = user_type;
        }

        public String getUser_real_name() {
                return user_real_name;
        }

        public void setUser_real_name(String user_real_name) {
                this.user_real_name = user_real_name;
        }

        public String getUser_id_number() {
                return user_id_number;
        }

        public void setUser_id_number(String user_id_number) {
                this.user_id_number = user_id_number;
        }

        public void setId(Integer id) {
                this.id = id;
        }
}