package com.ticket.api.service;


import com.ticket.api.vo.ManageInforVo;
import java.util.List;

public interface ManageInforInterface {
        //查
        public List<ManageInforVo> findAllManageTicket();
        //增
        public void addManage(ManageInforVo manageInforVo);
        //查byaccountId
        public ManageInforVo findByAccountId(String manage_accountId);
}