package com.ticket.service.impl;

import com.ticket.dao.impl.ManageInforDaoImpl;
import com.ticket.service.ManageInforInterface;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@Transactional
@Service("manageInforImpl")
public class ManageInforImpl implements ManageInforInterface {
        private ManageInforDaoImpl manageInforDaoImpl;
        @Resource(name = "manageDaoImpl")
        public void setManageDaoImpl(ManageInforDaoImpl manageInforDaoImpl) {
                this.manageInforDaoImpl = manageInforDaoImpl;
        }
}