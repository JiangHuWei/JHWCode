package com.jhw.dao;

import com.jhw.pojo.MRoleMenuPoJo;

public interface MRoleMenuPoJoMapper {
    int deleteByPrimaryKey(Integer tmrmid);

    int insert(MRoleMenuPoJo record);

    int insertSelective(MRoleMenuPoJo record);

    MRoleMenuPoJo selectByPrimaryKey(Integer tmrmid);

    int updateByPrimaryKeySelective(MRoleMenuPoJo record);

    int updateByPrimaryKey(MRoleMenuPoJo record);
}