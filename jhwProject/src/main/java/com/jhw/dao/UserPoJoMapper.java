package com.jhw.dao;

import java.util.List;

import javax.jws.soap.SOAPBinding.Use;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.UserDictionaryPoJo;
import com.jhw.pojo.UserPoJo;

public interface UserPoJoMapper {
    int deleteByPrimaryKey(Integer tuid);

    /**
     * @Description (TODO 新增用户)
     * @param record
     * @return 新增记录主键
     */
    int insert(UserPoJo record);

    int insertSelective(UserPoJo record);

    UserPoJo selectByPrimaryKey(Integer tuid);

    int updateByPrimaryKeySelective(UserPoJo record);

    int updateByPrimaryKey(UserPoJo record);
    
    /**
     * @Description (TODO 通过昵称和密码登录, 用于后台登录 )
     * @param userPoJo
     * @return
     */
    UserPoJo loginByPwd(UserPoJo userPoJo);
    
    /**
     * @Description (TODO 获取所有有效普通用户,不分页，仅供后台使用)
     * @return
     */
    List<UserPoJo> getAllUserInfo();
    
    /**
     * 
     * @Description (TODO 根据昵称更新用户status，用户密码输入错误次数等于6次时调用)
     * @param nickname
     * @return
     */
    int disableUser(String nickname);
    
    /**
     * 
     * @Description (TODO 获取所有有效用户的非系统用户)
     * @return
     */
    List<UserPoJo> getAllValidUser(@Param("start")int start,@Param("limit")int limit);
    
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
     * @Description (TODO 根据拼桌主键检索参与拼桌用户)
     * @param table_id
     * @return 参与拼桌用户详情
     */
    List<UserPoJo> selectByTableId(Integer table_id);

}