package com.jhw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.TablePoJo;

public interface TablePoJoMapper {
    int deleteByPrimaryKey(Integer ttid);

    int insert(TablePoJo record);

    int insertSelective(TablePoJo record);

    TablePoJo selectByPrimaryKey(Integer ttid);

    int updateByPrimaryKeySelective(TablePoJo record);

    int updateByPrimaryKey(TablePoJo record);
    
    /**
     * @Description (TODO 分页检索所有有效拼桌)
     * @param start
     * @param limit
     * @return
     */
    List<TablePoJo> selectAllTable(@Param("start") int start, @Param("limit") int limit);

    /**
     * @Description (TODO 检索所有有效的、未成局的饭局)
     * @return
     */
    List<TablePoJo> getValidAndNotCompleteTable();
}