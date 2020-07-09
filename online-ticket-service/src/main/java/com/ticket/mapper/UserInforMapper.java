package com.ticket.mapper;

import com.ticket.entity.UserInfor;
import com.ticket.utils.MyMapper;
import org.apache.ibatis.annotations.Param;


public interface  UserInforMapper extends MyMapper<UserInfor> {
        public void addUser(@Param("userInfor") UserInfor userInfor);
}