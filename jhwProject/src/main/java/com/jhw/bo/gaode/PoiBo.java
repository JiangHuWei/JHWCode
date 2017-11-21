/**
 * PoisBo.java
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
 * PoisBo.java
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
 * ClassName:PoisBo
 * Function: TODO
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月14日	下午7:09:25
 *
 * @see
 */
public class PoiBo {

    /** */
    private String id;
    /** */
    private String tag;
    /** */
    private String name;
    /** */
    private String type;
    /** */
    private String typecode;
    /** */
    private String biz_type;
    /** */
    private String address;
    /** */
    private String location;
    /** */
    private List<String> distance;
//    /** */
    private String tel;
    /** */
    private List<String> postcode;
    /** */
    private String website;
    /** */
    private List<String> email;
    /** */
    private String pcode;
    /** */
    private String pname;
    /** */
    private String citycode;
    /** */
    private String cityname;
    /** */
    private String adcode;
    /** */
    private String adname;
    /** */
    private List<String> importance;
    /** */
    private List<String> shopid;
    /** */
    private String shopinfo;
    /** */
    private List<String> poiweight;
    /** */
    private String entr_location;
    /** */
    private List<String> exit_location;
    /** */
    private String navi_poiid;
    /** */
    private String gridcode;
    /** */
    private List<String> alias;
    /** 所在商圈extensions=all的时候显示 */
    private String business_area;
    /** 是否有室内地图标志,1，表示有室内相关数据0，代表没有室内相关数据,extensions=all的时候显示 */
    private String indoor_map;
    /** 团购数据*/
    private String groupbuy_num;
    /** 优惠信息数目*/
    private String discount_num;
    /**  室内地图相关数据*/
    private IndoorDataBo indoor_data;
    /** 深度信息*/
    private BizExtBo biz_ext;
    /** 照片相关信息*/
    private List<PhotosBo> photos;
    
    public String getId() {
        return id;
    }
    
    public void setId(String id) {
        this.id = id;
    }
    
    public String getTag() {
        return tag;
    }
    
    public void setTag(String tag) {
        this.tag = tag;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getType() {
        return type;
    }
    public void setType(String type) {
        this.type = type;
    }
    
    public String getTypecode() {
        return typecode;
    }
    
    public void setTypecode(String typecode) {
        this.typecode = typecode;
    }
    
    public String getBiz_type() {
        return biz_type;
    }
    
    public void setBiz_type(String biz_type) {
        this.biz_type = biz_type;
    }
    
    public String getAddress() {
        return address;
    }
    
    public void setAddress(String address) {
        this.address = address;
    }
    
    public String getLocation() {
        return location;
    }
    
    public void setLocation(String location) {
        this.location = location;
    }
    
    public List<String> getDistance() {
        return distance;
    }
    
    public void setDistance(List<String> distance) {
        this.distance = distance;
    }
//    
    public String getTel() {
        return tel;
    }
    
    public void setTel(String tel) {
        this.tel = tel;
    }
    
    public List<String> getPostcode() {
        return postcode;
    }
    
    public void setPostcode(List<String> postcode) {
        this.postcode = postcode;
    }
    
    public String getWebsite() {
        return website;
    }
    
    public void setWebsite(String website) {
        this.website = website;
    }
    
    public List<String> getEmail() {
        return email;
    }
    
    public void setEmail(List<String> email) {
        this.email = email;
    }
    
    /**
     * pcode
     *
     * @return the pcode
     * @since lil Ver 1.0
    */
    
    public String getPcode() {
        return pcode;
    }
    
    /**
     * pcode
     *
     * @param pcode the pcode to set
     * @since lil Ver 1.0
     */
    
    public void setPcode(String pcode) {
        this.pcode = pcode;
    }
    
    /**
     * pname
     *
     * @return the pname
     * @since lil Ver 1.0
    */
    
    public String getPname() {
        return pname;
    }
    
    /**
     * pname
     *
     * @param pname the pname to set
     * @since lil Ver 1.0
     */
    
    public void setPname(String pname) {
        this.pname = pname;
    }
    
    /**
     * citycode
     *
     * @return the citycode
     * @since lil Ver 1.0
    */
    
    public String getCitycode() {
        return citycode;
    }
    
    /**
     * citycode
     *
     * @param citycode the citycode to set
     * @since lil Ver 1.0
     */
    
    public void setCitycode(String citycode) {
        this.citycode = citycode;
    }
    
    /**
     * cityname
     *
     * @return the cityname
     * @since lil Ver 1.0
    */
    
    public String getCityname() {
        return cityname;
    }
    
    /**
     * cityname
     *
     * @param cityname the cityname to set
     * @since lil Ver 1.0
     */
    
    public void setCityname(String cityname) {
        this.cityname = cityname;
    }
    
    /**
     * adcode
     *
     * @return the adcode
     * @since lil Ver 1.0
    */
    
    public String getAdcode() {
        return adcode;
    }
    
    /**
     * adcode
     *
     * @param adcode the adcode to set
     * @since lil Ver 1.0
     */
    
    public void setAdcode(String adcode) {
        this.adcode = adcode;
    }

    public List<String> getImportance() {
        return importance;
    }

    public void setImportance(List<String> importance) {
        this.importance = importance;
    }

    public List<String> getShopid() {
        return shopid;
    }

    public void setShopid(List<String> shopid) {
        this.shopid = shopid;
    }

    public String getShopinfo() {
        return shopinfo;
    }
    
    public void setShopinfo(String shopinfo) {
        this.shopinfo = shopinfo;
    }
    
    public List<String> getPoiweight() {
        return poiweight;
    }

    public void setPoiweight(List<String> poiweight) {
        this.poiweight = poiweight;
    }
    
    public String getAdname() {
        return adname;
    }
    
    public void setAdname(String adname) {
        this.adname = adname;
    }
    
    public String getEntr_location() {
        return entr_location;
    }
    
    public void setEntr_location(String entr_location) {
        this.entr_location = entr_location;
    }
    
    public List<String> getExit_location() {
        return exit_location;
    }
    
    public void setExit_location(List<String> exit_location) {
        this.exit_location = exit_location;
    }
    
    public String getNavi_poiid() {
        return navi_poiid;
    }
    
    public void setNavi_poiid(String navi_poiid) {
        this.navi_poiid = navi_poiid;
    }
    
    public String getGridcode() {
        return gridcode;
    }
    
    public void setGridcode(String gridcode) {
        this.gridcode = gridcode;
    }
    
    public List<String> getAlias() {
        return alias;
    }
    
    public void setAlias(List<String> alias) {
        this.alias = alias;
    }
    
    public String getBusiness_area() {
        return business_area;
    }
    
    public void setBusiness_area(String business_area) {
        this.business_area = business_area;
    }
    
    public String getIndoor_map() {
        return indoor_map;
    }
    
    public void setIndoor_map(String indoor_map) {
        this.indoor_map = indoor_map;
    }
    
    public String getGroupbuy_num() {
        return groupbuy_num;
    }

    public void setGroupbuy_num(String groupbuy_num) {
        this.groupbuy_num = groupbuy_num;
    }
    
    public String getDiscount_num() {
        return discount_num;
    }
    
    public void setDiscount_num(String discount_num) {
        this.discount_num = discount_num;
    }
    
    public IndoorDataBo getIndoor_data() {
        return indoor_data;
    }
    
    public void setIndoor_data(IndoorDataBo indoor_data) {
        this.indoor_data = indoor_data;
    }
    
    public BizExtBo getBiz_ext() {
        return biz_ext;
    }
    
    public void setBiz_ext(BizExtBo biz_ext) {
        this.biz_ext = biz_ext;
    }
    
    public List<PhotosBo> getPhotos() {
        return photos;
    }

    public void setPhotos(List<PhotosBo> photos) {
        this.photos = photos;
    }
}

