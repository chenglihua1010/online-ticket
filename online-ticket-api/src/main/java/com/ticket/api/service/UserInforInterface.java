package com.ticket.api.service;

import com.ticket.api.vo.UserInforVo;

public interface UserInforInterface {
        public void addUser(UserInforVo userInforVo);
        public UserInforVo findByUser_phone_numAndUser_password(String user_phone_num,String user_password);
}