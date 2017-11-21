package com.jhw.dao;

import com.jhw.pojo.VisitingRecordPoJo;

public interface VisitingRecordPoJoMapper {
    int deleteByPrimaryKey(Integer tvrid);

    int insert(VisitingRecordPoJo record);

    int insertSelective(VisitingRecordPoJo record);

    VisitingRecordPoJo selectByPrimaryKey(Integer tvrid);

    int updateByPrimaryKeySelective(VisitingRecordPoJo record);

    int updateByPrimaryKey(VisitingRecordPoJo record);
}