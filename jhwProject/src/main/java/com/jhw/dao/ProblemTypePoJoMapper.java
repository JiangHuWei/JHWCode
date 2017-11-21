package com.jhw.dao;

import com.jhw.pojo.ProblemTypePoJo;

public interface ProblemTypePoJoMapper {
    int deleteByPrimaryKey(Integer tptid);

    int insert(ProblemTypePoJo record);

    int insertSelective(ProblemTypePoJo record);

    ProblemTypePoJo selectByPrimaryKey(Integer tptid);

    int updateByPrimaryKeySelective(ProblemTypePoJo record);

    int updateByPrimaryKey(ProblemTypePoJo record);
}