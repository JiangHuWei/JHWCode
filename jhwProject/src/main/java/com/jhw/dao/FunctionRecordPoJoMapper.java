package com.jhw.dao;

import com.jhw.pojo.FunctionRecordPoJo;

public interface FunctionRecordPoJoMapper {
    int deleteByPrimaryKey(Integer tfrid);

    int insert(FunctionRecordPoJo record);

    int insertSelective(FunctionRecordPoJo record);

    FunctionRecordPoJo selectByPrimaryKey(Integer tfrid);

    int updateByPrimaryKeySelective(FunctionRecordPoJo record);

    int updateByPrimaryKey(FunctionRecordPoJo record);
}