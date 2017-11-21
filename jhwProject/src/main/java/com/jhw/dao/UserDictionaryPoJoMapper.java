package com.jhw.dao;

import com.jhw.pojo.UserDictionaryPoJo;

public interface UserDictionaryPoJoMapper {
    int deleteByPrimaryKey(Integer tudid);

    int insert(UserDictionaryPoJo record);

    int insertSelective(UserDictionaryPoJo record);

    UserDictionaryPoJo selectByPrimaryKey(Integer tudid);

    int updateByPrimaryKeySelective(UserDictionaryPoJo record);

    int updateByPrimaryKey(UserDictionaryPoJo record);
}