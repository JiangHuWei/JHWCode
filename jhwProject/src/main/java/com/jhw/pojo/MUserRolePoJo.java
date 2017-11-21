package com.jhw.pojo;

import java.util.Date;

/**
 * 
 * @ClassName MUserRolePoJo
 * @Description TODO(用户角色中间表pojo)
 * @author Administrator
 * @Date 2017年10月10日 上午11:30:26
 * @version 1.0.0
 */
public class MUserRolePoJo {
    private Integer turid;

    private Integer userid;

    private Integer roleid;

    private Date createDate;

    private Integer createUserid;

    private String createUsername;

    private Date updateDate;

    private Integer updateUserid;

    private String updateUsername;

    private Integer allowEdit;

    private Integer allowDelete;

    public Integer getTurid() {
        return turid;
    }

    public void setTurid(Integer turid) {
        this.turid = turid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername == null ? null : createUsername.trim();
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Integer getUpdateUserid() {
        return updateUserid;
    }

    public void setUpdateUserid(Integer updateUserid) {
        this.updateUserid = updateUserid;
    }

    public String getUpdateUsername() {
        return updateUsername;
    }

    public void setUpdateUsername(String updateUsername) {
        this.updateUsername = updateUsername == null ? null : updateUsername.trim();
    }

    public Integer getAllowEdit() {
        return allowEdit;
    }

    public void setAllowEdit(Integer allowEdit) {
        this.allowEdit = allowEdit;
    }

    public Integer getAllowDelete() {
        return allowDelete;
    }

    public void setAllowDelete(Integer allowDelete) {
        this.allowDelete = allowDelete;
    }
}