/**
 * SuggestionBo.java
 * com.jhw.bo.gaode
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月14日 		Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/
/**
 * SuggestionBo.java
 * com.jhw.bo.gaode
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月14日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.bo.gaode;

import java.util.List;
import java.util.Map;

/**
 * ClassName:SuggestionBo
 * Function: TODO
 *
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月14日	下午7:02:48
 *
 * @see
 */
/**
 * ClassName:SuggestionBo
 * Function: TODO 城市建议列表,当用户输入的词语为泛搜索词的时候，将显示城市列表
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午7:02:48
 *
 * @see 	
 */

public class SuggestionBo {

    /** 唯一ID*/
    private List<String> keywords;
    /** 城市列表*/
    private List<String> cities;
    
    public List<String> getKeywords() {
        return keywords;
    }
    
    public void setKeywords(List<String> keywords) {
        this.keywords = keywords;
    }
    
    public List<String> getCities() {
        return cities;
    }
    
    public void setCities(List<String> cities) {
        this.cities = cities;
    }
    
}

