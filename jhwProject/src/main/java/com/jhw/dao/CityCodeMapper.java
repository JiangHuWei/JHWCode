package com.jhw.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.jhw.pojo.CityCode;

public interface CityCodeMapper {
    int deleteByPrimaryKey(Integer tccid);

    int insert(CityCode record);

    int insertSelective(CityCode record);

    CityCode selectByPrimaryKey(Integer tccid);

    int updateByPrimaryKeySelective(CityCode record);

    int updateByPrimaryKey(CityCode record);
    
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