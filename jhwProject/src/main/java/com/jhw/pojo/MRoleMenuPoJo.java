package com.jhw.pojo;

import java.util.Date;

/**
 * 
 * @ClassName MRoleMenuPoJo
 * @Description TODO(角色菜单中间表pojo)
 * @author Administrator
 * @Date 2017年10月10日 上午11:33:05
 * @version 1.0.0
 */
public class MRoleMenuPoJo {
    private Integer tmrmid;

    private Integer roleid;

    private Integer menuid;

    private Date createDate;

    private Integer createUserid;

    private String createUsername;

    private Date updateDate;

    private Integer updateUserid;

    private String updateUsername;

    private Integer allowEdit;

    private Integer allowDelete;

    public Integer getTmrmid() {
        return tmrmid;
    }

    public void setTmrmid(Integer tmrmid) {
        this.tmrmid = tmrmid;
    }

    public Integer getRoleid() {
        return roleid;
    }

    public void setRoleid(Integer roleid) {
        this.roleid = roleid;
    }

    public Integer getMenuid() {
        return menuid;
    }

    public void setMenuid(Integer menuid) {
        this.menuid = menuid;
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