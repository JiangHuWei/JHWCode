package com.jhw.dao;

import java.util.List;

import com.jhw.pojo.PowerMenuPoJo;

/**
 * 
 * @ClassName PowerMenuPoJoMapper
 * @Description TODO(权限菜单dao)
 * @author Administrator
 * @Date 2017年10月10日 下午2:23:52
 * @version 1.0.0
 */
public interface PowerMenuPoJoMapper {
    int deleteByPrimaryKey(Integer tpmid);

    int insert(PowerMenuPoJo record);

    int insertSelective(PowerMenuPoJo record);

    PowerMenuPoJo selectByPrimaryKey(Integer tpmid);

    int updateByPrimaryKeySelective(PowerMenuPoJo record);

    int updateByPrimaryKey(PowerMenuPoJo record);
    
    /**
     * 
     * @Description (TODO 根据用户id获取用户所属角色的菜单)
     * @param userId
     * @return
     */
    List<PowerMenuPoJo> getMenuByUserId(Integer userId);
    
    /**
     * @Description (TODO 管理员获取菜单)
     * @return
     */
    List<PowerMenuPoJo> getAdminMenu();
}