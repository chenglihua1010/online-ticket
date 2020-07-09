package com.ticket.api.vo;

public class UserInforVo {

        //主键 id
        private Integer id;
        //账号(手机号作为账号)
        private String userPhoneNum;
        //密码
        private String userPassword;
        //用户邮箱
        private String userEmail;
        //用户真实姓名
        private String userRealName;
        //0-成人，1-学生，3-儿童
        private Integer userType;
        //身份证号
        private String userIdNumber;
        //0-女，1-男
        private Integer userGender;
        //用户地址
        private String userAddress;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }
        public String getUserPhoneNum() {
                return userPhoneNum;
        }

        public void setUserPhoneNum(String userPhoneNum) {
                this.userPhoneNum = userPhoneNum;
        }
        public String getUserPassword() {
                return userPassword;
        }

        public void setUserPassword(String userPassword) {
                this.userPassword = userPassword;
        }
        public String getUserEmail() {
                return userEmail;
        }

        public void setUserEmail(String userEmail) {
                this.userEmail = userEmail;
        }
        public String getUserRealName() {
                return userRealName;
        }

        public void setUserRealName(String userRealName) {
                this.userRealName = userRealName;
        }
        public Integer getUserType() {
                return userType;
        }

        public void setUserType(Integer userType) {
                this.userType = userType;
        }
        public String getUserIdNumber() {
                return userIdNumber;
        }

        public void setUserIdNumber(String userIdNumber) {
                this.userIdNumber = userIdNumber;
        }
        public Integer getUserGender() {
                return userGender;
        }

        public void setUserGender(Integer userGender) {
                this.userGender = userGender;
        }
        public String getUserAddress() {
                return userAddress;
        }

        public void setUserAddress(String userAddress) {
                this.userAddress = userAddress;
        }
}