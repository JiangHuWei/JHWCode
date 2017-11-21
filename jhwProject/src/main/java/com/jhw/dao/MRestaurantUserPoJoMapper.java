package com.jhw.dao;

import com.jhw.pojo.MRestaurantUserPoJo;

public interface MRestaurantUserPoJoMapper {
    int deleteByPrimaryKey(Integer tmruid);

    int insert(MRestaurantUserPoJo record);

    int insertSelective(MRestaurantUserPoJo record);

    MRestaurantUserPoJo selectByPrimaryKey(Integer tmruid);

    int updateByPrimaryKeySelective(MRestaurantUserPoJo record);

    int updateByPrimaryKey(MRestaurantUserPoJo record);
}