package com.jhw.service;

import org.apache.ibatis.annotations.Param;

/**
 * @ClassName TableBrowserService
 * @Description TODO(拼桌浏览量统计业务层)
 * @author Jce
 * @Date 2017年11月20日 下午7:26:49
 * @version 1.0.0
 */
public interface TableBrowserService {

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
