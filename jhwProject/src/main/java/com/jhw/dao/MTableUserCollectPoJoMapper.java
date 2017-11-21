package com.jhw.dao;

import com.jhw.pojo.MTableUserCollectPoJo;

public interface MTableUserCollectPoJoMapper {
    int deleteByPrimaryKey(Integer tmtucid);

    int insert(MTableUserCollectPoJo record);

    int insertSelective(MTableUserCollectPoJo record);

    MTableUserCollectPoJo selectByPrimaryKey(Integer tmtucid);

    int updateByPrimaryKeySelective(MTableUserCollectPoJo record);

    int updateByPrimaryKey(MTableUserCollectPoJo record);
}