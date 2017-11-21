package com.jhw.dao;

import java.util.List;

import com.jhw.pojo.MUserRolePoJo;

public interface MUserRolePoJoMapper {
    int deleteByPrimaryKey(Integer turid);

    int insert(MUserRolePoJo record);

    int insertSelective(MUserRolePoJo record);

    MUserRolePoJo selectByPrimaryKey(Integer turid);

    int updateByPrimaryKeySelective(MUserRolePoJo record);

    int updateByPrimaryKey(MUserRolePoJo record);
    
    /**
     * 
     * @Description (TODO 给一个用户添加多个角色)
     * @param records 多个角色
     * @return
     */
    int insertRoleByUserId(List<MUserRolePoJo> records);
}