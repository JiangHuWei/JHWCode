/**
 * ButtonMenuBo.java
 * com.jhw.bo.wx
 *
 * Function： TODO 
 *
 *   ver     date      		author
 * ──────────────────────────────────
 *   		 2017年11月15日 		Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/
/**
 * ButtonMenuBo.java
 * com.jhw.bo.wx
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月15日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.jhw.bo.wx;

import java.util.List;

import com.jhw.bo.BaseBo;

/**
 * ClassName:ButtonMenuBo
 * Function: TODO
 *
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月15日	下午7:41:58
 * @see
 */
public class ButtonMenuBo {

    /** 菜单的响应动作类型，view表示网页类型，click表示点击类型，miniprogram表示小程序类型*/
    private String type;
    /** 菜单标题，不超过16个字节，子菜单不超过60个字节*/
    private String name;
    /** 菜单KEY值，用于消息接口推送，不超过128字节*/
    private String key;
    /** 网页链接，用户点击菜单可打开链接，不超过1024字节。type为miniprogram时，不支持小程序的老版本客户端将打开本url。*/
    private String url;
    /** 调用新增永久素材接口返回的合法media_id*/
    private String media_id;
    /** 小程序的appid（仅认证公众号可配置）*/
    private String appid;
    /** 小程序的页面路径*/
    private String pagepath;
    /** 二级菜单数组，个数应为1~5个*/
    private List<ButtonMenuBo> sub_button;
    
    /**
     * type
     *
     * @return the type
     * @since lil Ver 1.0
    */
    
    public String getType() {
        return type;
    }
    
    /**
     * type
     *
     * @param type the type to set
     * @since lil Ver 1.0
     */
    
    public void setType(String type) {
        this.type = type;
    }
    
    /**
     * name
     *
     * @return the name
     * @since lil Ver 1.0
    */
    
    public String getName() {
        return name;
    }
    
    /**
     * name
     *
     * @param name the name to set
     * @since lil Ver 1.0
     */
    
    public void setName(String name) {
        this.name = name;
    }
    
    /**
     * key
     *
     * @return the key
     * @since lil Ver 1.0
    */
    
    public String getKey() {
        return key;
    }
    
    /**
     * key
     *
     * @param key the key to set
     * @since lil Ver 1.0
     */
    
    public void setKey(String key) {
        this.key = key;
    }
    
    /**
     * url
     *
     * @return the url
     * @since lil Ver 1.0
    */
    
    public String getUrl() {
        return url;
    }
    
    /**
     * url
     *
     * @param url the url to set
     * @since lil Ver 1.0
     */
    
    public void setUrl(String url) {
        this.url = url;
    }
    
    /**
     * media_id
     *
     * @return the media_id
     * @since lil Ver 1.0
    */
    
    public String getMedia_id() {
        return media_id;
    }
    
    /**
     * media_id
     *
     * @param media_id the media_id to set
     * @since lil Ver 1.0
     */
    
    public void setMedia_id(String media_id) {
        this.media_id = media_id;
    }
    
    /**
     * appid
     *
     * @return the appid
     * @since lil Ver 1.0
    */
    
    public String getAppid() {
        return appid;
    }
    
    /**
     * appid
     *
     * @param appid the appid to set
     * @since lil Ver 1.0
     */
    
    public void setAppid(String appid) {
        this.appid = appid;
    }
    
    public String getPagepath() {
        return pagepath;
    }
    
    public void setPagepath(String pagepath) {
        this.pagepath = pagepath;
    }
    
    public List<ButtonMenuBo> getSub_button() {
        return sub_button;
    }
    
    public void setSub_button(List<ButtonMenuBo> sub_button) {
        this.sub_button = sub_button;
    }
    
}

