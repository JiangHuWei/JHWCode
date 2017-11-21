/**
 * CityCodeBo.java
 * com.jhw.bo
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
 * CityCodeBo.java
 * com.jhw.bo
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月16日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.bo;

import java.util.List;
import java.util.Map;

/**
 * ClassName:CityCodeBo
 * Function: TODO 城市编码业务bean（省、市、县区）
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月16日	下午3:41:51
 */
public class CityCodeBo {

    
    private String text;
    
    private String value;
    //市名拼音首字母
    private String firstCharacter; 
    //市名全拼
    private String quanpin;
    
    private List<CityCodeBo> children;
    
    
    /**
     * quanpin
     *
     * @return the quanpin
     * @since lil Ver 1.0
    */
    
    public String getQuanpin() {
        return quanpin;
    }


    
    /**
     * quanpin
     *
     * @param quanpin the quanpin to set
     * @since lil Ver 1.0
     */
    
    public void setQuanpin(String quanpin) {
        this.quanpin = quanpin;
    }


    /**
     * text
     *
     * @return the text
     * @since lil Ver 1.0
    */
    
    public String getText() {
        return text;
    }

    
    /**
     * text
     *
     * @param text the text to set
     * @since lil Ver 1.0
     */
    
    public void setText(String text) {
        this.text = text;
    }

    
    /**
     * value
     *
     * @return the value
     * @since lil Ver 1.0
    */
    
    public String getValue() {
        return value;
    }

    
    /**
     * value
     *
     * @param value the value to set
     * @since lil Ver 1.0
     */
    
    public void setValue(String value) {
        this.value = value;
    }

    /**
     * children
     *
     * @return the children
     * @since lil Ver 1.0
    */
    
    public List<CityCodeBo> getChildren() {
        return children;
    }
    
    /**
     * children
     *
     * @param children the children to set
     * @since lil Ver 1.0
     */
    
    public void setChildren(List<CityCodeBo> children) {
        this.children = children;
    }

    /**
     * firstCharacter
     *
     * @return the firstCharacter
     * @since lil Ver 1.0
    */
    
    public String getFirstCharacter() {
        return firstCharacter;
    }

    /**
     * firstCharacter
     *
     * @param firstCharacter the firstCharacter to set
     * @since lil Ver 1.0
     */
    
    public void setFirstCharacter(String firstCharacter) {
        this.firstCharacter = firstCharacter;
    }

}

