package com.jhw.pojo;

import java.util.Date;

public class FunctionRecordPoJo {
    private Integer tfrid;

    private Integer functionid;

    private Date createDate;

    private String ip;

    public Integer getTfrid() {
        return tfrid;
    }

    public void setTfrid(Integer tfrid) {
        this.tfrid = tfrid;
    }

    public Integer getFunctionid() {
        return functionid;
    }

    public void setFunctionid(Integer functionid) {
        this.functionid = functionid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}