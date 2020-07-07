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
        private String manageAccountId;
        //管理员密码
        private String managePassword;
        //管理员权限
        private String manageType;

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        public Integer getId() {
                return id;
        }
        public void setId(Integer id) {
                this.id = id;
        }

        @Column(name = "manage_accoutId")
        public String getManageAccountId() {
                return manageAccountId;
        }

        public void setManageAccountId(String manageAccountId) {
                this.manageAccountId = manageAccountId;
        }
        @Column(name = "manage_password")
        public String getManagePassword() {
                return managePassword;
        }

        public void setManagePassword(String managePassword) {
                this.managePassword = managePassword;
        }
        @Column(name = "manage_type")
        public String getManageType() {
                return manageType;
        }

        public void setManageType(String manageType) {
                this.manageType = manageType;
        }
}