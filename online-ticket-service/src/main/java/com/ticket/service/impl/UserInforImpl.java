package com.ticket.service.impl;

import com.ticket.dao.impl.UserInforDaoImpl;
import com.ticket.service.UserInforInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("userInforImpl")
public class UserInforImpl implements UserInforInterface {
        private UserInforDaoImpl userInforDaoImpl;

        @Resource(name = "userInforDaoImpl")
        public void setUserInforDaoImpl(UserInforDaoImpl userInforDaoImpl) {
                this.userInforDaoImpl = userInforDaoImpl;
        }
        public void addUser(){
                userInforDaoImpl.addUser();
        }
}