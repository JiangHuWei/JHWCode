package com.jhw.dao;

import com.jhw.pojo.TablePartyWeightPoJo;

public interface TablePartyWeightPoJoMapper {
    int deleteByPrimaryKey(Integer tpwid);

    int insert(TablePartyWeightPoJo record);

    int insertSelective(TablePartyWeightPoJo record);

    TablePartyWeightPoJo selectByPrimaryKey(Integer tpwid);

    int updateByPrimaryKeySelective(TablePartyWeightPoJo record);

    int updateByPrimaryKey(TablePartyWeightPoJo record);
}