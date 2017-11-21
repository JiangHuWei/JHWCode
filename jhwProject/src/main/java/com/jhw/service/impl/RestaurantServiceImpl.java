package com.jhw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.bo.RestaurantBo;
import com.jhw.dao.RestaurantPoJoMapper;
import com.jhw.pojo.RestaurantPoJo;
import com.jhw.service.RestaurantService;

/**
 * @ClassName RestaurantServiceImpl
 * @Description TODO(餐厅信息业务处理)
 * @author Administrator
 * @Date 2017年10月24日 下午7:12:13
 * @version 1.0.0
 */
@Service("RestaurantService")
public class RestaurantServiceImpl implements RestaurantService{

    @Autowired
    private RestaurantPoJoMapper restaurantDao;

    /**
     * @Description (TODO 遍历所有餐厅，选出餐厅id等于参数，设置其为选中状态isSelect=true)
     * @param restaurantId 被选中的餐厅id, 默认传-1,表示不进行选中状态标记
     * @return 
     */
    @Override
    public List<RestaurantBo> getAllRestaurant(Integer restaurantId) {
        List<RestaurantPoJo> restaurantPoJos = restaurantDao.getAllRestaurant();
        List<RestaurantBo> resBos = new ArrayList<>();
        for(RestaurantPoJo poJo : restaurantPoJos){
            RestaurantBo resBo = new RestaurantBo();
            if (poJo.getTrid() == restaurantId) {
                resBo.setRestaurantSelect(true);
            }
            resBo.setRestaurant(poJo);
            resBos.add(resBo);
        }
        return resBos;
    }
 
    
}
