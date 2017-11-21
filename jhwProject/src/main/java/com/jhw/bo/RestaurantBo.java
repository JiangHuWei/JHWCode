package com.jhw.bo;

import java.util.List;

import com.jhw.pojo.RestaurantPoJo;

/**
 * 
 * @ClassName RestaurantBo
 * @Description TODO(餐厅详情业务bean)
 * @author Administrator
 * @Date 2017年11月3日 下午12:10:45
 * @version 1.0.0
 */
public class RestaurantBo  {

    /** 餐厅信息增删改查是否成功*/
    private boolean isSuccess = false;
    /** 令牌*/
    private String tokenStr;
    /**是否被选中，用在编辑页面中，例如发起人是小明,那么小明在编辑页面应该是默认被选中的*/
    private boolean restaurantSelect = false;
    /** 餐厅详情pojo*/
    private RestaurantPoJo restaurant;
    /** 餐厅列表*/
    private List<RestaurantPoJo> restaurantList;
    
    public boolean isSuccess() {
        return isSuccess;
    }
    
    public void setSuccess(boolean isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getTokenStr() {
        return tokenStr;
    }
    
    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }
    
    public boolean isRestaurantSelect() {
        return restaurantSelect;
    }
    
    public void setRestaurantSelect(boolean restaurantSelect) {
        this.restaurantSelect = restaurantSelect;
    }

    public RestaurantPoJo getRestaurant() {
        return restaurant;
    }
    
    public void setRestaurant(RestaurantPoJo restaurant) {
        this.restaurant = restaurant;
    }
    
    public List<RestaurantPoJo> getRestaurantList() {
        return restaurantList;
    }
    
    public void setRestaurantList(List<RestaurantPoJo> restaurantList) {
        this.restaurantList = restaurantList;
    }
}
