package com.ticket.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.UserInforInterface;
import com.ticket.api.vo.UserInforVo;
import com.ticket.entity.UserInfor;
import com.ticket.mapper.UserInforMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


@Service
public class UserInforImpl extends BaseService implements UserInforInterface {


        @Autowired//调用mapper，通过调用mapper中的方法，向数据库操作，完成功能
        UserInforMapper userInforMapper;

        @Override
        public void addUser(UserInforVo userInforVo) {
                //transferObjectIgnoreCase("a",B.class)将a转换为B类型 将api的Vo(外部的类)转换为service的Entity(内部自己识别的类)
                UserInfor userInfor=transferObjectIgnoreCase(userInforVo,UserInfor.class);
                userInforMapper.addUser(userInfor);
        }

        @Override
        public UserInforVo findByUser_phone_numAndUser_password(String user_phone_num, String user_password) {
                UserInfor userInfor=userInforMapper.findByUser_phone_numAndUser_password(user_phone_num,user_password);
                UserInforVo userInforVo=transferObjectIgnoreCase(userInfor,UserInforVo.class);
                return userInforVo;
        }


}