package com.jhw.dao;

import com.jhw.pojo.OpinionTypePoJo;

public interface OpinionTypePoJoMapper {
    int deleteByPrimaryKey(Integer topid);

    int insert(OpinionTypePoJo record);

    int insertSelective(OpinionTypePoJo record);

    OpinionTypePoJo selectByPrimaryKey(Integer topid);

    int updateByPrimaryKeySelective(OpinionTypePoJo record);

    int updateByPrimaryKey(OpinionTypePoJo record);
}