package com.jhw.service;

import java.text.ParseException;
import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.MTableAttentPoJo;
import com.jhw.pojo.TablePoJo;

/**
 * @ClassName TableService
 * @Description TODO(拼桌业务处理层)
 * @author Administrator
 * @Date 2017年10月23日 下午3:53:50
 * @version 1.0.0
 */
public interface TableService {

    /**
     * @Description (TODO 分页检索所有有效拼桌)
     * @param start
     * @param limit
     * @return
     */
    List<TablePoJo> selectAllTable(@Param("start") int start, @Param("limit") int limit);
    
    /**'
     * @Description (TODO 拼桌插入)
     * @param record
     * @return
     */
    boolean insertSelective(TablePoJo record,List<MTableAttentPoJo> attentUsers) throws ParseException;
    
    int insert(TablePoJo record);
    
    /**
     * @Description (TODO 查看拼桌详情)
     * @param ttid
     * @return
     */
    TablePoJo selectByPrimaryKey(Integer ttid);
    
    /**
     * @Description (TODO 根据拼桌主键删除拼桌)
     * @param ttid
     * @return
     */
    int deleteByPrimaryKey(Integer ttid);
    
    int updateByPrimaryKeySelective(TablePoJo record);

    /**
     * @Description (TODO 更新拼桌信息, 拼桌参与人更新)
     * @param record
     * @return
     */
    int updateByPrimaryKey(TablePoJo record) throws ParseException;
    
    /**
     * @Description (TODO 检索所有有效的、未成局的饭局)
     * @return
     */
    List<TablePoJo> getValidAndNotCompleteTable();
    
}
