package com.jhw.dao;

import com.jhw.pojo.OpinionDetailPoJo;

public interface OpinionDetailPoJoMapper {
    int deleteByPrimaryKey(Integer todid);

    int insert(OpinionDetailPoJo record);

    int insertSelective(OpinionDetailPoJo record);

    OpinionDetailPoJo selectByPrimaryKey(Integer todid);

    int updateByPrimaryKeySelective(OpinionDetailPoJo record);

    int updateByPrimaryKeyWithBLOBs(OpinionDetailPoJo record);

    int updateByPrimaryKey(OpinionDetailPoJo record);
}