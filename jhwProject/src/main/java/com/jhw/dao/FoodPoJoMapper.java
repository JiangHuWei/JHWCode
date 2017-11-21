package com.jhw.dao;

import com.jhw.pojo.FoodPoJo;

public interface FoodPoJoMapper {
    int deleteByPrimaryKey(Integer tpfid);

    int insert(FoodPoJo record);

    int insertSelective(FoodPoJo record);

    FoodPoJo selectByPrimaryKey(Integer tpfid);

    int updateByPrimaryKeySelective(FoodPoJo record);

    int updateByPrimaryKey(FoodPoJo record);
}