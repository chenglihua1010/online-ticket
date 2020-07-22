package com.ticket.mapper;

import com.ticket.entity.UserInfor;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;


public interface  UserInforMapper extends MyMapper<UserInfor> {
        //Todo 入参传递（@Param）
        public void addUser(@Param("userInfor")UserInfor userInfor);
        public UserInfor findByUser_phone_numAndUser_password(@Param("user_phone_num") String user_phone_num,@Param("user_password") String user_password);

        public UserInfor findById(@Param("id")Integer id);

}