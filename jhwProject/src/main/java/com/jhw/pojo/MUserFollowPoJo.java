package com.jhw.pojo;

public class MUserFollowPoJo {
    private Integer tufid;

    private Integer followedid;

    private Integer followid;

    private Integer status;

    private String createDate;

    private String updateDate;

    public Integer getTufid() {
        return tufid;
    }

    public void setTufid(Integer tufid) {
        this.tufid = tufid;
    }

    public Integer getFollowedid() {
        return followedid;
    }

    public void setFollowedid(Integer followedid) {
        this.followedid = followedid;
    }

    public Integer getFollowid() {
        return followid;
    }

    public void setFollowid(Integer followid) {
        this.followid = followid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}