package com.jhw.dao;

import com.jhw.pojo.MPartyUserAttentPoJo;

public interface MPartyUserAttentPoJoMapper {
    int deleteByPrimaryKey(Integer tmpuaid);

    int insert(MPartyUserAttentPoJo record);

    int insertSelective(MPartyUserAttentPoJo record);

    MPartyUserAttentPoJo selectByPrimaryKey(Integer tmpuaid);

    int updateByPrimaryKeySelective(MPartyUserAttentPoJo record);

    int updateByPrimaryKey(MPartyUserAttentPoJo record);
}