/**
 * WebApiResultBo.java
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
 * WebApiResultBo.java
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

import com.jhw.bo.BaseBo;

/**
 * ClassName:WebApiResultBo
 * Function: TODO 高德地图Web API检索结果业务bean
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午6:59:38
 *
 * @see 	
 */

public class WebApiResultBo extends BaseBo {

    /** 结果状态  0：请求失败；1：请求成功*/
    private String status;
    /** 搜索方案数目(最大值为1000)*/
    private String count;
    /** 返回状态说明 status为0时，info返回错误原因，否则返回“OK”。*/
    private String info;
    /** */
    private String infocode;
    /** 城市建议列表,当用户输入的词语为泛搜索词的时候，将显示城市列表*/
    private SuggestionBo suggestion;
    /** 搜索POI信息列表*/
    private List<PoiBo> pois;

    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getCount() {
        return count;
    }
    
    public void setCount(String count) {
        this.count = count;
    }
    
    public String getInfocode() {
        return infocode;
    }

    public void setInfocode(String infocode) {
        this.infocode = infocode;
    }

    public SuggestionBo getSuggestion() {
        return suggestion;
    }

    public void setSuggestion(SuggestionBo suggestion) {
        this.suggestion = suggestion;
    }
    
    public List<PoiBo> getPois() {
        return pois;
    }

    public void setPois(List<PoiBo> pois) {
        this.pois = pois;
    }
    
}

