/**
 * CityCodeSeviceImpl.java
 * com.jhw.service.impl
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
 * CityCodeSeviceImpl.java
 * com.jhw.service.impl
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月16日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.service.impl;

import java.util.List;

import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.jhw.dao.CityCodeMapper;
import com.jhw.pojo.CityCode;
import com.jhw.service.CityCodeSevice;

/**
 * ClassName:CityCodeSeviceImpl
 * Function: TODO 
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月16日	下午4:02:13
 * @see 	
 */
@Service("CityCodeSevice")
public class CityCodeSeviceImpl extends BaseServiceImpl implements CityCodeSevice {

    @Autowired
    private CityCodeMapper cityCodeDao;
    
    /**
     * (non-Javadoc)
     * @see com.jhw.service.CityCodeSevice#selectCityCode(java.lang.String)
     */
    @Override
    public List<CityCode> selectCityCode(String code) {
        // TODO Auto-generated method stub
        return cityCodeDao.selectCityCode(code);
    }

    /**
     * selectCityCode:
     * TODO 根据adcode通配符 检索所有市一级信息
     * @param  @param code
     * @param  @return
     * @return List<CityCode>  
     * @throws 
     * @since  lil Ver 1.0
     */
    public List<CityCode> selectAllCityInfo(@Param("code") String code ){
        return cityCodeDao.selectAllCityInfo(code);
    }
    
    /**
     * selectCityCode:
     * TODO 根据adcode通配符 检索所有市一级信息，并按字母顺序从   a到z排序 
     * @param  @param code
     * @param  @return
     * @return List<CityCode>  
     * @throws 
     * @since  lil Ver 1.0
     */
    public List<String> selectSortAllCityName(@Param("code") String code ){
        return cityCodeDao.selectSortAllCityName(code);
    }
}

