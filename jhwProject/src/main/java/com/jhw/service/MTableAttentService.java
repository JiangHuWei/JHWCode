package com.jhw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.MTableAttentPoJo;

public interface MTableAttentService {

    MTableAttentPoJo selectByPrimaryKey(Integer tmtaid);
 
    int insert(MTableAttentPoJo record);
    
    /**
     * @Description (TODO 根据拼桌主键检索所有该拼桌参与人)
     * @param tableId
     * @return
     */
    List<MTableAttentPoJo> selectAllUserByTableId(Integer tableId);

    
    /**
     * @Description (TODO 根据主键更新该记录status)
     * @param statusVal
     * @param tmtaidVal
     * @return
     */
    int updateStatusById(Integer statusVal, Integer tmtaidVal);
    
    /**
     * @Description (TODO 根据tableid和userid检查对应拼桌人是否存在)
     * @param tableId
     * @param userId
     * @return
     */
    MTableAttentPoJo selectByTableAndUser(@Param("tableId")Integer tableId, @Param("userId")Integer userId);
    
    /**
     * @Description (TODO 根据拼桌id检索该拼桌的所有参与人)
     * @param tableId
     * @return
     */
    List<MTableAttentPoJo> getValidTakePartIn(@Param("tableId")Integer tableId);
}
