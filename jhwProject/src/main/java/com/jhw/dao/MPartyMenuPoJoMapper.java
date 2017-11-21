package com.jhw.dao;

import com.jhw.pojo.MPartyMenuPoJo;

public interface MPartyMenuPoJoMapper {
    int deleteByPrimaryKey(Integer tmpmid);

    int insert(MPartyMenuPoJo record);

    int insertSelective(MPartyMenuPoJo record);

    MPartyMenuPoJo selectByPrimaryKey(Integer tmpmid);

    int updateByPrimaryKeySelective(MPartyMenuPoJo record);

    int updateByPrimaryKey(MPartyMenuPoJo record);
}