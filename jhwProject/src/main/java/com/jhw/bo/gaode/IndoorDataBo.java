/**
 * IndoorDataBo.java
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
 * IndoorDataBo.java
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

/**
 * ClassName:IndoorDataBo 
 * Function: TODO 室内地图相关数据,当indoor_map=0时，字段为空
     extensions=all的时候显示 
 *
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月14日	下午7:14:21
 *
 * @see
 */
public class IndoorDataBo {

    /** */
    private String cpid;
    /** */
    private String floor;
    /** */
    private String truefloor;
    /** */
    private String cmsid;
    
    public String getCpid() {
        return cpid;
    }
    
    public void setCpid(String cpid) {
        this.cpid = cpid;
    }
    
    public String getFloor() {
        return floor;
    }
    
    public void setFloor(String floor) {
        this.floor = floor;
    }
    
    public String getTruefloor() {
        return truefloor;
    }
    
    public void setTruefloor(String truefloor) {
        this.truefloor = truefloor;
    }
    
    public String getCmsid() {
        return cmsid;
    }
    
    public void setCmsid(String cmsid) {
        this.cmsid = cmsid;
    }
    
}

