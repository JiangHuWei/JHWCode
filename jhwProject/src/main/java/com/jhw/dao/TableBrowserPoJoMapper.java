package com.jhw.dao;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.TableBrowserPoJo;

public interface TableBrowserPoJoMapper {
    int deleteByPrimaryKey(Integer ttbid);

    int insert(TableBrowserPoJo record);

    int insertSelective(TableBrowserPoJo record);

    TableBrowserPoJo selectByPrimaryKey(Integer ttbid);

    int updateByPrimaryKeySelective(TableBrowserPoJo record);

    int updateByPrimaryKey(TableBrowserPoJo record);
    
    /**
     * @Description (TODO 计算正在凑人数的拼桌的总浏览量)
     * @return
     */
    int totalCount();
    
    /**
     * @Description (TODO 根据拼桌id检索该拼桌的浏览量)
     * @param tableId
     * @return
     */
    int getBrowserCountByTableId(@Param("tableId")Integer tableId);
}