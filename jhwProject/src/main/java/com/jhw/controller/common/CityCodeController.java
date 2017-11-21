/**
 * CityCodeController.java
 * com.jhw.controller.common
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
 * CityCodeController.java
 * com.jhw.controller.common
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月16日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.controller.common;

import java.text.Collator;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.CityCodeBo;
import com.jhw.controller.base.BaseController;
import com.jhw.pojo.CityCode;
import com.jhw.service.CityCodeSevice;
import com.jhw.util.character.CHToPyUtil;


/**
 * ClassName:CityCodeController
 * Function: TODO
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月16日	下午3:39:14
 * @see
 */
@Controller
@RequestMapping("/citycode")
public class CityCodeController extends BaseController {

    @Autowired
    private CityCodeSevice cityCodeService;
    
    
    /**
     * getCityCode:
     * TODO
     * @param  @param request
     * @param  @return
     * @return String  
     * @throws 
     * @since  lil Ver 1.0
     */
    @RequestMapping(value="/loadcode",produces="application/json; charset=utf-8")
    @ResponseBody
    public String getCityCode(HttpServletRequest request){
        List<CityCodeBo> cityCodeBos = new ArrayList<>();
        
        String searchProvinceWord = "%0000";
        List<CityCode> provinces = cityCodeService.selectCityCode(searchProvinceWord);
        for(CityCode code : provinces){     //取到的是省
            String provinceCode = code.getAdcode();
            String pbegin = provinceCode.substring(0, 2);
            String searchCityWord = pbegin+"__00";
            List<CityCode> citys = cityCodeService.selectCityCode(searchCityWord);
            if (citys == null || citys.size() == 0) {
                logger.info("没有检索到市");
            }
            
            CityCodeBo provinceBo = new CityCodeBo();
            provinceBo.setText(code.getCityname());
            provinceBo.setValue(code.getAdcode());
            List<CityCodeBo> childrenCitys = new ArrayList<>();
            for(int i=0; i<citys.size();i++){ //取到的是市
                String cityCode = citys.get(i).getAdcode();
                String cbegin = cityCode.substring(0, 4);
                String searchCountyWord = cbegin+"__";
                List<CityCode> counties = cityCodeService.selectCityCode(searchCountyWord);
                if (counties == null || counties.size() == 0) {
                    logger.info("没有检索到县区");
                }
                
                CityCodeBo cityCodeBo = new CityCodeBo();
                cityCodeBo.setText(citys.get(i).getCityname());
                cityCodeBo.setValue(citys.get(i).getAdcode());
                
                List<CityCodeBo> childrenCountys = new ArrayList<>();
                for(int j=0; j<counties.size(); j++){     //取到的是县区
                    CityCodeBo countyBo = new CityCodeBo();
                    countyBo.setText(counties.get(j).getCityname());
                    countyBo.setValue(counties.get(j).getAdcode());
                    if (j==0) {
                        continue;
                    }
                    childrenCountys.add(countyBo);
                }
                if (i==0) {
                    continue;
                }
                cityCodeBo.setChildren(childrenCountys);
                childrenCitys.add(cityCodeBo);
            } 
            provinceBo.setChildren(childrenCitys);
            cityCodeBos.add(provinceBo);
        }
        return JSONObject.toJSONString(cityCodeBos);
    }
    
    /**
     * getCityNameBySort:
     * TODO 检索所有市一级，获取市名称和其首字母，并按首字母排序
     * @param  @param request
     * @param  @return
     * @return String  
     */
    @RequestMapping(value="sort_city_name", produces="application/json; charset=utf-8")
    @ResponseBody
    public String getCityNameBySort(HttpServletRequest request){
        String searchProvinceWord = "____00";
        List<CityCode> cityCodes = cityCodeService.selectAllCityInfo(searchProvinceWord);
        List<String> cityNames = cityCodeService.selectSortAllCityName(searchProvinceWord);
        
        List<CityCodeBo> cityCodeBos = new ArrayList<>();
        for(int j=0; j<cityNames.size(); j++){
            for (int i = 0; i < cityCodes.size(); i++) {
                if (cityNames.get(j).equals(cityCodes.get(i).getCityname())) {
                    CityCodeBo tmp = new CityCodeBo();
                    tmp.setText(cityNames.get(j));
                    tmp.setValue(cityCodes.get(i).getAdcode());
                    String zimu = CHToPyUtil.ch2py(cityNames.get(j));
                    tmp.setQuanpin(zimu);
                    tmp.setFirstCharacter(zimu.substring(0, 1).toUpperCase());
                    cityCodeBos.add(tmp);
                }
            }
        }
        return JSONObject.toJSONString(cityCodeBos);
    }
    
    public static void main(String args[]){
        String str = "我是啊啊";
        
        
        logger.info(CHToPyUtil.ch2py(str));
    }
}

