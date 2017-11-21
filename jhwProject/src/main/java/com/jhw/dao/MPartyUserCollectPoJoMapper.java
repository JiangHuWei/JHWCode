package com.jhw.dao;

import com.jhw.pojo.MPartyUserCollectPoJo;

public interface MPartyUserCollectPoJoMapper {
    int deleteByPrimaryKey(Integer tmpucid);

    int insert(MPartyUserCollectPoJo record);

    int insertSelective(MPartyUserCollectPoJo record);

    MPartyUserCollectPoJo selectByPrimaryKey(Integer tmpucid);

    int updateByPrimaryKeySelective(MPartyUserCollectPoJo record);

    int updateByPrimaryKey(MPartyUserCollectPoJo record);
}