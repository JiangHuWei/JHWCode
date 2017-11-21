/**
 * GaoDeServlet.java
 * com.jhw.util.servlet
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
 * GaoDeServlet.java
 * com.jhw.util.servlet
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月14日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.util.servlet;

import java.util.Map;

/**
 * ClassName:GaoDeServlet
 * Function: TODO 高德地图API处理Servlet
 *
 * @author   lil
 * @version  
 * @since    lil Ver 1.0
 * @Date	 2017年11月14日	下午5:12:27
 * @see
 */
public class GaoDeServlet extends BaseServlet{

    /** 用户在高德地图官网申请Web服务API类型KEY*/
    private static final String KEY = "2218472a9c1d25dec425c8a7349f514e";
    /** 返回数据格式为json*/
    private static final String RESULT_FORMAT = "JSON";
    /** 每页记录数*/
    private static final String OFFSET = "25";
    /** 此项默认返回基本地址信息；取值为all返回地址信息、附近POI、道路以及道路交叉口信息。 */
    private static final String EXTENSIONS = "all";        
    
    /**
     * keyWordSearch:
     * TODO 高德地图Web API 关键词检索
     * @param params 请求参数,调用端只需要添加keywords, types, city
     * @return String  
     * @throws 
     * @since  lil Ver 1.0
     */
    public static String keyWordSearch(Map<String, String> params){
        String url = "http://restapi.amap.com/v3/place/text";
        params.put("key", KEY);
        params.put("output", RESULT_FORMAT);
        params.put("offset", OFFSET);
        params.put("extensions", EXTENSIONS);
        params.put("citylimit", "true");
        params.put("children", "1");
        String result = doServletGet(url, params);
        logger.info(result);
        return result;
    }
    
    /**
     * roundSearch:
     * TODO 周边搜索
     * @param params 请求参数,调用时只需要添加location(中心点坐标)，keywords(查询关键字)，
     *               types(查询POI类型)，city(查询城市)，radius(查询半径)，sortrule(排序规则)
     * @param 
     * @return String  
     * @throws 
     * @since  lil Ver 1.0
     */
    public static String roundSearch(Map<String, String> params){
        String url = "http://restapi.amap.com/v3/place/around";
        params.put("key", KEY);
        params.put("output", RESULT_FORMAT);
        params.put("offset", OFFSET);
        params.put("extensions", EXTENSIONS);
        params.put("citylimit", "true");
        params.put("children", "1");
        String result = doServletGet(url, params);
        logger.info(result);
        return result;
    }
    
    /**
     * idSearch:
     * TODO ID查询
     * @param params 请求参数,调用时需要添加id(兴趣点ID)
     * @return String  
     * @throws 
     * @since  lil Ver 1.0
     */
    public static String idSearch(Map<String, String> params){
        String url = "http://restapi.amap.com/v3/place/detail";
        params.put("key", KEY);
        params.put("output", RESULT_FORMAT);
        String result = doServletGet(url, params);
        logger.info(result);
        return result;
    }
    
    
}

