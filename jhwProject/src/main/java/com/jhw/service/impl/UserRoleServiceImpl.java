package com.jhw.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.dao.MUserRolePoJoMapper;
import com.jhw.pojo.MUserRolePoJo;
import com.jhw.service.UserRoleService;

/**
 * 
 * @ClassName UserRoleServiceImpl
 * @Description TODO(用户、角色中间表业务处理实现)
 * @author Administrator
 * @Date 2017年10月19日 上午11:48:07
 * @version 1.0.0
 */
@Service("UserRoleService")
public class UserRoleServiceImpl implements UserRoleService {

    @Autowired
    private MUserRolePoJoMapper userRoleDao;
    
    @Override
    public int insertRoleByUserId(List<MUserRolePoJo> records) {
        // TODO Auto-generated method stub
        return userRoleDao.insertRoleByUserId(records);
    }

}
