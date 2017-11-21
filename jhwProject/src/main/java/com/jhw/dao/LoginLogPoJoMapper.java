package com.jhw.dao;

import com.jhw.pojo.LoginLogPoJo;

public interface LoginLogPoJoMapper {
    int deleteByPrimaryKey(Integer tllid);

    int insert(LoginLogPoJo record);

    int insertSelective(LoginLogPoJo record);

    LoginLogPoJo selectByPrimaryKey(Integer tllid);

    int updateByPrimaryKeySelective(LoginLogPoJo record);

    int updateByPrimaryKey(LoginLogPoJo record);
}