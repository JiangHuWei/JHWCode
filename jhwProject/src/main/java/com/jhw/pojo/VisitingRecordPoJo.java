package com.jhw.pojo;

import java.util.Date;

public class VisitingRecordPoJo {
    private Integer tvrid;

    private Integer beVisitedid;

    private Integer visitorid;

    private Date createDate;

    public Integer getTvrid() {
        return tvrid;
    }

    public void setTvrid(Integer tvrid) {
        this.tvrid = tvrid;
    }

    public Integer getBeVisitedid() {
        return beVisitedid;
    }

    public void setBeVisitedid(Integer beVisitedid) {
        this.beVisitedid = beVisitedid;
    }

    public Integer getVisitorid() {
        return visitorid;
    }

    public void setVisitorid(Integer visitorid) {
        this.visitorid = visitorid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}