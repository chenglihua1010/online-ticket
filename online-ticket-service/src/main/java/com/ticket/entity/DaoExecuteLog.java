package com.ticket.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

//@Entity(name = "ops_dao_errorlog")
public class DaoExecuteLog implements Serializable{
    private static final long serialVersionUID = 2332867275497153721L;
    private Long id;
    private String trackId;
    private String serviceId;
    private String methodId;
    private String userId;
    private Integer urt;
    private Integer clientId;
    private String serverId;

    private String appDomain;
    private String localHostIp;
    private String daoClassName;
    private String daoMethodName;
    private Integer lineNum;
    private String sqlText;
    private Integer succeed;

    private String exceptionMsg;
    private String exceptionStackTrace;

    private Date createTime;
    private long reqTime;
    private long resTime;
    private Long costMilliSeconds;

    @Id
    @GeneratedValue(strategy=IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAppDomain() {
        return appDomain;
    }

    public void setAppDomain(String appDomain) {
        this.appDomain = appDomain;
    }

    public String getTrackId() {
        return trackId;
    }

    public void setTrackId(String trackId) {
        this.trackId = trackId;
    }

    public String getDaoClassName() {
        return daoClassName;
    }

    public void setDaoClassName(String daoClassName) {
        this.daoClassName = daoClassName;
    }

    public String getDaoMethodName() {
        return daoMethodName;
    }

    public void setDaoMethodName(String daoMethodName) {
        this.daoMethodName = daoMethodName;
    }

    public Long getCostMilliSeconds() {
        return costMilliSeconds;
    }

    public void setCostMilliSeconds(Long costMilliSeconds) {
        this.costMilliSeconds = costMilliSeconds;
    }

    public Integer getSucceed() {
        return succeed;
    }

    public void setSucceed(Integer succeed) {
        this.succeed = succeed;
    }

    public String getSqlText() {
        return sqlText;
    }

    public void setSqlText(String sqlText) {
        this.sqlText = sqlText;
    }

    public Integer getLineNum() {
        return lineNum;
    }

    public void setLineNum(Integer lineNum) {
        this.lineNum = lineNum;
    }

    public String getExceptionMsg() {
        return exceptionMsg;
    }

    public void setExceptionMsg(String exceptionMsg) {
        this.exceptionMsg = exceptionMsg;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public long getReqTime() {
        return reqTime;
    }

    public void setReqTime(long reqTime) {
        this.reqTime = reqTime;
    }

    public long getResTime() {
        return resTime;
    }

    public void setResTime(long resTime) {
        this.resTime = resTime;
    }

    public String getServiceId() {
        return serviceId;
    }

    public void setServiceId(String serviceId) {
        this.serviceId = serviceId;
    }

    public String getMethodId() {
        return methodId;
    }

    public void setMethodId(String methodId) {
        this.methodId = methodId;
    }

    public String getExceptionStackTrace() {
        return exceptionStackTrace;
    }

    public void setExceptionStackTrace(String exceptionStackTrace) {
        this.exceptionStackTrace = exceptionStackTrace;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getUrt() {
        return urt;
    }

    public void setUrt(Integer urt) {
        this.urt = urt;
    }

    public String getLocalHostIp() {
        return localHostIp;
    }

    public void setLocalHostIp(String localHostIp) {
        this.localHostIp = localHostIp;
    }

    public Integer getClientId() {
        return clientId;
    }

    public void setClientId(Integer clientId) {
        this.clientId = clientId;
    }

    public String getServerId() {
        return serverId;
    }

    public void setServerId(String serverId) {
        this.serverId = serverId;
    }
}
