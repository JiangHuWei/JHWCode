package com.jhw.pojo;

import java.util.Date;

public class FoodPoJo {
    private Integer tpfid;

    private Integer menuofuser;

    private String foodname;

    private String fooddescribe;

    private String foodimgurl;

    private String mark;

    private Integer commentid;

    private Integer createUserid;

    private String createDate;

    private String createUsername;

    private Integer updateUserid;

    private Date updateDate;

    private String updateUsername;

    private Integer status;
    
    public Integer getTpfid() {
        return tpfid;
    }

    public void setTpfid(Integer tpfid) {
        this.tpfid = tpfid;
    }

    public Integer getMenuofuser() {
        return menuofuser;
    }

    public void setMenuofuser(Integer menuofuser) {
        this.menuofuser = menuofuser;
    }

    public String getFoodname() {
        return foodname;
    }

    public void setFoodname(String foodname) {
        this.foodname = foodname == null ? null : foodname.trim();
    }

    public String getFooddescribe() {
        return fooddescribe;
    }

    public void setFooddescribe(String fooddescribe) {
        this.fooddescribe = fooddescribe == null ? null : fooddescribe.trim();
    }

    public String getFoodimgurl() {
        return foodimgurl;
    }

    public void setFoodimgurl(String foodimgurl) {
        this.foodimgurl = foodimgurl == null ? null : foodimgurl.trim();
    }

    public String getMark() {
        return mark;
    }

    public void setMark(String mark) {
        this.mark = mark == null ? null : mark.trim();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername == null ? null : createUsername.trim();
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername == null ? null : updateUsername.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
}