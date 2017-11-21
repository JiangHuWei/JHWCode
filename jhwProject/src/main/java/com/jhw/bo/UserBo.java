package com.jhw.bo;

import java.util.List;

import com.jhw.pojo.UserPoJo;

/**
 * 
 * @ClassName UserBo
 * @Description TODO(用户信息业务处理bean)
 * @author Administrator
 * @Date 2017年10月14日 下午5:16:30
 * @version 1.0.0
 */
public class UserBo {

    /** 学历是否认证，0：已认证； 1：未认证 */
    private int eduAuthentication;
    /** 令牌*/
    private String tokenStr;
    /**是否被选中，用在编辑页面中，例如发起人是小明,那么小明在编辑页面应该是默认被选中的*/
    private boolean userSelect = false;
    /** 用户详情信息*/
    private UserPoJo userPoJo;
    /** 用户列表*/
    private List<UserPoJo> userPoJos;
    
    public int getEduAuthentication() {
        return eduAuthentication;
    }

    public void setEduAuthentication(int eduAuthentication) {
        this.eduAuthentication = eduAuthentication;
    }

    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public boolean isUserSelect() {
        return userSelect;
    }
    
    public void setUserSelect(boolean userSelect) {
        this.userSelect = userSelect;
    }

    public UserPoJo getUserPoJo() {
        return userPoJo;
    }

    public void setUserPoJo(UserPoJo userPoJo) {
        this.userPoJo = userPoJo;
    }

    public List<UserPoJo> getUserPoJos() {
        return userPoJos;
    }

    public void setUserPoJos(List<UserPoJo> userPoJos) {
        this.userPoJos = userPoJos;
    }
    
}
