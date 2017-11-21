package com.jhw.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.bo.UserBo;
import com.jhw.dao.PowerMenuPoJoMapper;
import com.jhw.dao.UserPoJoMapper;
import com.jhw.pojo.PowerMenuPoJo;
import com.jhw.pojo.UserDictionaryPoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.service.UserService;

/**
 * @ClassName UserServiceImpl
 * @Description TODO(用户信息管理)
 * @author Administrator
 * @Date 2017年9月22日 下午12:34:23
 * @version 1.0.0
 */
@Service("UserService")
public class UserServiceImpl implements UserService {

    @Autowired
    private UserPoJoMapper userDao;
    
    @Autowired
    private PowerMenuPoJoMapper powerMenuDao;
    
    /**
     * 用户登录
     */
    @Override
    public UserPoJo loginByPwd(UserPoJo userPoJo) {
        // TODO Auto-generated method stub
        return userDao.loginByPwd(userPoJo);
    }

    /**
     * 根据昵称更新用户status，用户密码输入错误次数等于6次时调用
     */
    @Override
    public int disableUser(String nickname) {
        // TODO Auto-generated method stub
        return userDao.disableUser(nickname);
    }

    /**
     * 
     * @Description (TODO 根据用户id获取用户所属角色的菜单)
     * @param userId
     * @return
     */
    @Override
    public List<PowerMenuPoJo> getMenuByUserId(Integer userId) {
        // TODO Auto-generated method stub
        return powerMenuDao.getMenuByUserId(userId);
    }

    /**
     * 获取所有有效用户的非系统用户
     */
    @Override
    public List<UserPoJo> getAllValidUser(int start,int limit) {
        // TODO Auto-generated method stub
        return userDao.getAllValidUser(start,limit);
    }

    /**
     * @Description (TODO 获取所有有效普通用户,不分页，仅供后台使用)
     * @param initiatorId 被选中用户id,没有被选中用户传-1
     * @return
     */
    @Override
    public List<UserBo> getAllUserInfo(Integer initiatorId){
        List<UserPoJo> userPoJos = userDao.getAllUserInfo();
        List<UserBo> userBos = new ArrayList<>();
        if (userPoJos == null) {
            return userBos;
        }
        for(UserPoJo poJo:userPoJos){
            UserBo bo = new UserBo();
            if (poJo.getTuid() == initiatorId) {
                bo.setUserSelect(true);
            }
            bo.setUserPoJo(poJo);
            userBos.add(bo);
        }
        return userBos;
    }
    
    /**
     * @Description (TODO 新增用户)
     * @param record
     * @return 新增记录主键
     */
    @Override
    public int insert(UserPoJo record) {
        // TODO Auto-generated method stub
        return userDao.insert(record);
    }

    /**
     * @Description (TODO 关联用户吸烟、饮酒、性别属性)
     * @param userDictionaryPoJo
     * @return
     */
    @Override
    public int insertUserDictionary(UserDictionaryPoJo userDictionaryPoJo) {
        // TODO Auto-generated method stub
        return userDao.insertUserDictionary(userDictionaryPoJo);
    }

    @Override
    public int updateHeadImgByUserId(UserPoJo userPoJo) {
        // TODO Auto-generated method stub
        return userDao.updateHeadImgByUserId(userPoJo);
    }

    @Override
    public int deleteByPrimaryKey(Integer tuid) {
        // TODO Auto-generated method stub
        return userDao.deleteByPrimaryKey(tuid);
    }

    @Override
    public UserPoJo selectByPrimaryKey(Integer tuid) {
        // TODO Auto-generated method stub
        return userDao.selectByPrimaryKey(tuid);
    }

    @Override
    public int updateByPrimaryKeySelective(UserPoJo record) {
        // TODO Auto-generated method stub
        return userDao.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<PowerMenuPoJo> getAdminMenu() {
        // TODO Auto-generated method stub
        return powerMenuDao.getAdminMenu();
    }

    /**
     * @Description (TODO 根据拼桌主键检索参与拼桌用户)
     * @param table_id
     * @return 参与拼桌用户详情
     */
    public List<UserBo> selectByTableId(Integer table_id){
        List<UserBo> bos = new ArrayList<>();
        List<UserPoJo> userPoJos = userDao.getAllUserInfo();
        List<UserPoJo> attentUserPojo = userDao.selectByTableId(table_id); 
        if (attentUserPojo == null) {
            return bos;
        }
        for(UserPoJo userPoJo : userPoJos){
            UserBo userBo = new UserBo();
            if (table_id>0) {
                for(UserPoJo attentUser : attentUserPojo){
                    if (attentUser.getTuid() == userPoJo.getTuid()) {
                        userBo.setUserSelect(true);
                    }
                }
            }
            userBo.setUserPoJo(userPoJo);
            bos.add(userBo);
        }
        return bos;
    }
    
}
