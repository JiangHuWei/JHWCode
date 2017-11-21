package com.jhw.dao;

import com.jhw.pojo.PartyPoJo;

public interface PartyPoJoMapper {
    int deleteByPrimaryKey(Integer tpid);

    int insert(PartyPoJo record);

    int insertSelective(PartyPoJo record);

    PartyPoJo selectByPrimaryKey(Integer tpid);

    int updateByPrimaryKeySelective(PartyPoJo record);

    int updateByPrimaryKey(PartyPoJo record);
}