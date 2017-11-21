package com.jhw.service;

import java.util.List;

import com.jhw.bo.UserBo;
import com.jhw.pojo.PowerMenuPoJo;
import com.jhw.pojo.UserDictionaryPoJo;
import com.jhw.pojo.UserPoJo;

/**
 * 
 * @ClassName UserService
 * @Description TODO(用户信息管理)
 * @author Administrator
 * @Date 2017年9月22日 下午12:35:37
 * @version 1.0.0
 */
public interface UserService {

    /**
     * 
     * @Description (TODO 用户登录)
     * @param userPoJo
     * @return
     */
    public UserPoJo loginByPwd(UserPoJo userPoJo);
    
    /**
     * 
     * @Description (TODO 根据昵称更新用户status，用户密码输入错误次数等于6次时调用)
     * @param nickname
     * @return
     */
    int disableUser(String nickname);
    
    /**
     * @Description (TODO 新增用户)
     * @param record
     * @return
     */
    int insert(UserPoJo record);
    
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
    
    /**
     * @Description (TODO 获取所有有效并且是非系统用户)
     * @param start 分页的起始页数
     * @param limit 每一页的页数
     * @return
     */
    List<UserPoJo> getAllValidUser(int start,int limit);
    
    /**
     * @Description (TODO 获取所有有效普通用户,不分页，仅供后台使用)
     * @param initiatorId 被选中用户id,没有被选中用户传-1
     * @return
     */
    List<UserBo> getAllUserInfo(Integer initiatorId);
    
    /**
     * @Description (TODO 关联用户吸烟、饮酒、性别属性)
     * @param userDictionaryPoJo
     * @return
     */
    int insertUserDictionary(UserDictionaryPoJo userDictionaryPoJo);
    
    /**
     * 
     * @Description (TODO 根据用户id获取更新用户头像路径)
     * @param userPoJo
     * @return
     */
    int updateHeadImgByUserId(UserPoJo userPoJo);
    
    /**
     * 
     * @Description (TODO 根据用户id删除用户)
     * @param tuid
     * @return
     */
    int deleteByPrimaryKey(Integer tuid);
    
    /**
     * @Description (TODO 根据用户id检索用户信息)
     * @param tuid 用户主键
     * @return
     */
    UserPoJo selectByPrimaryKey(Integer tuid);
    
    /**
     * 
     * @Description (TODO 更加用户id更新用户信息,空值字段不更新)
     * @param record
     * @return
     */
    int updateByPrimaryKeySelective(UserPoJo record);
    
    /**
     * @Description (TODO 根据拼桌主键检索参与拼桌用户)
     * @param table_id
     * @return 参与拼桌用户详情
     */
    List<UserBo> selectByTableId(Integer table_id);
}
