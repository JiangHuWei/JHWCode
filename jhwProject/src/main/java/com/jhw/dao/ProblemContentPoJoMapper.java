package com.jhw.dao;

import com.jhw.pojo.ProblemContentPoJo;

public interface ProblemContentPoJoMapper {
    int deleteByPrimaryKey(Integer tpcid);

    int insert(ProblemContentPoJo record);

    int insertSelective(ProblemContentPoJo record);

    ProblemContentPoJo selectByPrimaryKey(Integer tpcid);

    int updateByPrimaryKeySelective(ProblemContentPoJo record);

    int updateByPrimaryKeyWithBLOBs(ProblemContentPoJo record);

    int updateByPrimaryKey(ProblemContentPoJo record);
}