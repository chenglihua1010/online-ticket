package com.ticket.service.impl;


import com.alibaba.dubbo.config.annotation.Service;
import com.ticket.api.service.ManageInforInterface;
import com.ticket.api.vo.ManageInforVo;
import com.ticket.entity.ManageInfor;
import com.ticket.mapper.ManageInforMapper;
import com.ticket.utils.BaseService;
import org.springframework.beans.factory.annotation.Autowired;


import java.util.List;


@Service
public class ManageInforImpl extends BaseService implements ManageInforInterface{

        @Autowired
        ManageInforMapper manageInforMapper;

        @Override
        public List<ManageInforVo> findAllManageTicket() {
                List<ManageInfor> manageInforList = manageInforMapper.findAllManageTicket();

                List<ManageInforVo> manageInforVoList=transferObjectIgnoreCaseList(manageInforList,ManageInforVo.class);
                return manageInforVoList;
        }

        @Override
        public void addManage(ManageInforVo manageInforVo) {

                ManageInfor manageInfor=transferObjectIgnoreCase(manageInforVo,ManageInfor.class);
                manageInforMapper.addManage(manageInfor);
        }

        @Override
        public ManageInforVo findByAccountId(String manage_accountId) {
                ManageInfor manageInfor=manageInforMapper.findByAccountId(manage_accountId);
                ManageInforVo manageInforVo=transferObjectIgnoreCase(manageInfor,ManageInforVo.class);
                return manageInforVo;
        }
}