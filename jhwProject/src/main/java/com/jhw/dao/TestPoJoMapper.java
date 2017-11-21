package com.jhw.dao;

import com.jhw.pojo.TestPoJo;

public interface TestPoJoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(TestPoJo record);

    int insertSelective(TestPoJo record);
    
    
}