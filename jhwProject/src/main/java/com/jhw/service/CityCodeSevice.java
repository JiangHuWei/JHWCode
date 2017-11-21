/**
 * CityCodeSevice.java
 * com.jhw.service
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月16日 		Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/
/**
 * CityCodeSevice.java
 * com.jhw.service
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月16日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.service;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.CityCode;

/**
 * ClassName:CityCodeSevice
 * Function: TODO
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月16日	下午4:01:11
 * @see
 */
public interface CityCodeSevice {

    /**
     * selectCityCode:
     * TODO 通过拼接的code用like查询
     * @param  @param code
     * @param  @return
     * @return List<CityCode>  
     * @throws 
     * @since  lil Ver 1.0
     */
    List<CityCode> selectCityCode(@Param("code") String code );
    
    /**
     * selectCityCode:
     * TODO 根据adcode通配符 检索所有市一级信息
     * @param  @param code
     * @param  @return
     * @return List<CityCode>  
     * @throws 
     * @since  lil Ver 1.0
     */
    List<CityCode> selectAllCityInfo(@Param("code") String code );
    
    /**
     * selectCityCode:
     * TODO 根据adcode通配符 检索所有市一级信息，并按字母顺序从   a到z排序 
     * @param  @param code
     * @param  @return
     * @return List<CityCode>  
     * @throws 
     * @since  lil Ver 1.0
     */
    List<String> selectSortAllCityName(@Param("code") String code );
}

