package com.jhw.service;

import java.util.List;

import com.jhw.bo.RestaurantBo;
import com.jhw.pojo.RestaurantPoJo;

/**
 * @ClassName RestaurantService
 * @Description TODO(这里用一句话描述这个类的作用)
 * @author Administrator
 * @Date 2017年11月3日 下午4:25:51
 * @version 1.0.0
 */
public interface RestaurantService {

    
    /**
     * @Description (TODO 检索所有有效餐厅信息)
     * @return
     */
    List<RestaurantBo> getAllRestaurant(Integer restaurantId);

}
