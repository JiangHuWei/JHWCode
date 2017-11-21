package com.jhw.pojo;

import java.util.Date;

public class MTableUserCollectPoJo {
    private Integer tmtucid;

    private Integer tableid;

    private Integer userid;

    private Date createDate;

    private String userName;

    private Date updateDate;

    private Integer status;

    public Integer getTmtucid() {
        return tmtucid;
    }

    public void setTmtucid(Integer tmtucid) {
        this.tmtucid = tmtucid;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}