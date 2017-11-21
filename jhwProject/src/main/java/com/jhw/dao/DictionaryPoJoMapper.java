package com.jhw.dao;

import com.jhw.pojo.DictionaryPoJo;

public interface DictionaryPoJoMapper {
    int deleteByPrimaryKey(Integer tdid);

    int insert(DictionaryPoJo record);

    int insertSelective(DictionaryPoJo record);

    DictionaryPoJo selectByPrimaryKey(Integer tdid);

    int updateByPrimaryKeySelective(DictionaryPoJo record);

    int updateByPrimaryKey(DictionaryPoJo record);
}