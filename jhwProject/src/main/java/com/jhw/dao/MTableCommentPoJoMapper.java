package com.jhw.dao;

import com.jhw.pojo.MTableCommentPoJo;

public interface MTableCommentPoJoMapper {
    int deleteByPrimaryKey(Integer tmtcid);

    int insert(MTableCommentPoJo record);

    int insertSelective(MTableCommentPoJo record);

    MTableCommentPoJo selectByPrimaryKey(Integer tmtcid);

    int updateByPrimaryKeySelective(MTableCommentPoJo record);

    int updateByPrimaryKey(MTableCommentPoJo record);
}