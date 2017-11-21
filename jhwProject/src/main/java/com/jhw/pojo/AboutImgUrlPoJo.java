package com.jhw.pojo;

public class AboutImgUrlPoJo {
    private Integer tauid;

    private Integer userid;

    private String imgUrl;

    private String imgName;

    private Integer status;

    public Integer getTauid() {
        return tauid;
    }

    public void setTauid(Integer tauid) {
        this.tauid = tauid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl == null ? null : imgUrl.trim();
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName == null ? null : imgName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}