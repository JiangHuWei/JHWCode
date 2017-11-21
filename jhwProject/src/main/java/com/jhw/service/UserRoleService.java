package com.jhw.service;

import java.util.List;

import com.jhw.pojo.MUserRolePoJo;

/**
 * 
 * @ClassName UserRoleService
 * @Description TODO(用户、角色中间表业务处理)
 * @author Administrator
 * @Date 2017年10月19日 上午11:46:59
 * @version 1.0.0
 */
public interface UserRoleService {

    /**
     * 
     * @Description (TODO 给一个用户添加多个角色)
     * @param records 多个角色
     * @return
     */
    int insertRoleByUserId(List<MUserRolePoJo> records);
    
    
}
