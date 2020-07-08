package com.ticket.entity;

import org.springframework.data.annotation.AccessType;
import org.springframework.data.annotation.Id;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@AccessType(AccessType.Type.PROPERTY)
@Table(name = "manage_infor")
public class ManageInfor implements Serializable {
        //主键 id
        private Integer id;
        //管理员账号
        private String manage_accountId;
        //管理员密码
        private String manage_password;
        //管理员权限
        private String manage_type;

        public Integer getId() {
                return id;
        }

        public void setId(Integer id) {
                this.id = id;
        }

        public String getManage_accountId() {
                return manage_accountId;
        }

        public void setManage_accountId(String manage_accountId) {
                this.manage_accountId = manage_accountId;
        }

        public String getManage_password() {
                return manage_password;
        }

        public void setManage_password(String manage_password) {
                this.manage_password = manage_password;
        }

        public String getManage_type() {
                return manage_type;
        }

        public void setManage_type(String manage_type) {
                this.manage_type = manage_type;
        }
}