package com.ticket.api.service;

import com.ticket.api.vo.UserInforVo;

public interface UserInforInterface {
        public void addUser(UserInforVo userInforVo);

        public UserInforVo findByUser_phone_numAndUser_password(String user_phone_num,String user_password);

        /**
         *  根据id查找用户
         * @param id  用户id
         * @return 用户对象
         */
        public UserInforVo findById(Integer id);

}