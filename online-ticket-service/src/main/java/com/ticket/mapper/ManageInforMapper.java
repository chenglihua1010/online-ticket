package com.ticket.mapper;


import com.ticket.entity.ManageInfor;
import com.ticket.utils.MyMapper;

import java.util.List;

public interface ManageInforMapper extends MyMapper<ManageInfor> {
        public List<ManageInfor> findAllManageTicket();

        public void addManage(ManageInfor manageInfor);
        public ManageInfor findByAccountId(String manage_accountId);
}