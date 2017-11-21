package com.jhw.pojo;

import java.util.Date;

public class MRestaurantUserPoJo {
    private Integer tmruid;

    private Integer userid;

    private Integer restaurantid;

    private Date createDate;

    private String createName;

    private Date updateDate;

    public Integer getTmruid() {
        return tmruid;
    }

    public void setTmruid(Integer tmruid) {
        this.tmruid = tmruid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Integer restaurantid) {
        this.restaurantid = restaurantid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }
}