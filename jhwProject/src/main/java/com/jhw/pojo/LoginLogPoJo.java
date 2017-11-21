package com.jhw.pojo;

import java.util.Date;

public class LoginLogPoJo {
    private Integer tllid;

    private Integer userid;

    private Integer terminalid;

    private Date loginDate;

    private String loginPlace;

    public Integer getTllid() {
        return tllid;
    }

    public void setTllid(Integer tllid) {
        this.tllid = tllid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getTerminalid() {
        return terminalid;
    }

    public void setTerminalid(Integer terminalid) {
        this.terminalid = terminalid;
    }

    public Date getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(Date loginDate) {
        this.loginDate = loginDate;
    }

    public String getLoginPlace() {
        return loginPlace;
    }

    public void setLoginPlace(String loginPlace) {
        this.loginPlace = loginPlace == null ? null : loginPlace.trim();
    }
}