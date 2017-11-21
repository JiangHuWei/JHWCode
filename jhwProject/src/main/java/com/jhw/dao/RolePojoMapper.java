package com.jhw.dao;

import com.jhw.pojo.RolePojo;

public interface RolePojoMapper {
    int deleteByPrimaryKey(Integer trid);

    int insert(RolePojo record);

    int insertSelective(RolePojo record);

    RolePojo selectByPrimaryKey(Integer trid);

    int updateByPrimaryKeySelective(RolePojo record);

    int updateByPrimaryKey(RolePojo record);
}