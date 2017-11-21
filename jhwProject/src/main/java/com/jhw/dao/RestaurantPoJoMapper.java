package com.jhw.dao;

import java.util.List;

import com.jhw.bo.RestaurantBo;
import com.jhw.pojo.RestaurantPoJo;

public interface RestaurantPoJoMapper {
    int deleteByPrimaryKey(Integer trid);

    int insert(RestaurantPoJo record);

    int insertSelective(RestaurantPoJo record);

    RestaurantPoJo selectByPrimaryKey(Integer trid);

    int updateByPrimaryKeySelective(RestaurantPoJo record);

    int updateByPrimaryKey(RestaurantPoJo record);
    
    /**
     * @Description (TODO 获取所有餐厅信息,只拱管理后台使用)
     * @return
     */
    List<RestaurantPoJo> getAllRestaurant();
}