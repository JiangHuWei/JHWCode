package com.jhw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.MTableAttentPoJo;

public interface MTableAttentPoJoMapper {
    int deleteByPrimaryKey(Integer tmtaid);

    int insert(MTableAttentPoJo record);

    int insertSelective(MTableAttentPoJo record);

    MTableAttentPoJo selectByPrimaryKey(Integer tmtaid);

    int updateByPrimaryKeySelective(MTableAttentPoJo record);

    int updateByPrimaryKey(MTableAttentPoJo record);
    
    /**
     * @Description (TODO 根据拼桌主键检索所有该拼桌参与人)
     * @param tableId
     * @return
     */
    List<MTableAttentPoJo> selectAllUserByTableId(Integer tableId);
    
    /**
     * @Description (TODO 根据主键更新该记录status)
     * @param statusVal 0：有效, -1：无效
     * @param tmtaidVal 主键
     * @return
     */
    int updateStatusById(@Param("statusVal") Integer statusVal, @Param("tmtaidVal") Integer tmtaidVal);
    
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