package com.jhw.pojo;


public class BasePoJo {

    private String token;

    /**是否被选中，用在编辑页面中，例如发起人是小明,那么小明在编辑页面应该是默认被选中的*/
    private boolean isSelected;
    
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isSelected() {
        return isSelected;
    }

    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
    
}
