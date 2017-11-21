package com.jhw.service.impl;

import com.jhw.dao.MTableAttentPoJoMapper;
import com.jhw.pojo.MTableAttentPoJo;
import com.jhw.service.*;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

@Service("MTableAttentService")
public class MTableAttentServiceImpl implements MTableAttentService {
    
    @Autowired
    private MTableAttentPoJoMapper tableAttentDao;
    
    @Override
    public MTableAttentPoJo selectByPrimaryKey(Integer tmtaid) {
        // TODO Auto-generated method stub
        return tableAttentDao.selectByPrimaryKey(tmtaid);
    }

    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int insert(MTableAttentPoJo record) {
        // TODO Auto-generated method stub
        return tableAttentDao.insert(record);
    }
    
    /**
     * @Description (TODO 根据拼桌主键检索所有该拼桌参与人)
     * @param tableId
     * @return
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public List<MTableAttentPoJo> selectAllUserByTableId(Integer tableId){
        return tableAttentDao.selectAllUserByTableId(tableId);
    }
    
    /**
     * @Description (TODO 根据主键更新该记录status)
     * @param statusVal 0：有效, -1：无效
     * @param tmtaidVal 主键
     * @return
     */
    @Override
    @Transactional(propagation=Propagation.REQUIRED)
    public int updateStatusById(Integer statusVal, Integer tmtaidVal){
        return tableAttentDao.updateStatusById(statusVal, tmtaidVal);
    }
    
    /**
     * @Description (TODO 根据tableid和userid检查对应拼桌人是否存在)
     * @param tableId
     * @param userId
     * @return
     */
    @Transactional(propagation=Propagation.REQUIRED)
    public MTableAttentPoJo selectByTableAndUser(@Param("tableId")Integer tableId, @Param("userId")Integer userId){
        return tableAttentDao.selectByTableAndUser(tableId, userId);
    }
    
    /**
     * @Description (TODO 根据拼桌id检索该拼桌的所有参与人)
     * @param tableId
     * @return
     */
    public List<MTableAttentPoJo> getValidTakePartIn(@Param("tableId")Integer tableId){
    	return tableAttentDao.getValidTakePartIn(tableId);
    }
    
}
