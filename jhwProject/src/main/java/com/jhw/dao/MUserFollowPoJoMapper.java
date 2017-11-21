package com.jhw.dao;

import com.jhw.pojo.MUserFollowPoJo;

public interface MUserFollowPoJoMapper {
    int deleteByPrimaryKey(Integer tufid);

    int insert(MUserFollowPoJo record);

    int insertSelective(MUserFollowPoJo record);

    MUserFollowPoJo selectByPrimaryKey(Integer tufid);

    int updateByPrimaryKeySelective(MUserFollowPoJo record);

    int updateByPrimaryKey(MUserFollowPoJo record);
}