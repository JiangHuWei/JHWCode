/**
 * RestaurantSearchController.java
 * com.jhw.controller.wxh5
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
 * RestaurantSearchController.java
 * com.jhw.controller.wxh5
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月14日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/


package com.jhw.controller.wxh5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.gaode.PoiBo;
import com.jhw.bo.gaode.WebApiResultBo;
import com.jhw.controller.base.BaseController;
import com.jhw.util.servlet.GaoDeServlet;
import com.sun.mail.imap.protocol.Status;

/**
 * ClassName:RestaurantSearchController
 * Function: TODO 餐厅检索页面
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午6:30:47
 *
 * @see 	
 */
@Controller
@RequestMapping("/restaurant_search")
public class RestaurantSearchController extends BaseController {
    
    public static final String STATUS = "1";
    
    /**
     * searchRestaurantByName:
     * TODO 根据餐厅名关键词检索餐厅
     * @param  @param request
     * @param  @return
     * @return ModelAndView  
     * @throws 
     * @since  lil Ver 1.0
     */
    @RequestMapping("/searchbyname")
    @ResponseBody
    public ModelAndView searchRestaurantByName(HttpServletRequest request, String keyword){
        ModelAndView modelAndView = new ModelAndView();
        if (keyword == null || keyword.length() == 0) {
            modelAndView.setViewName("/index");
            return modelAndView;
        }
        Map<String, String> param = new HashMap<>();
        param.put("keywords", keyword);
//        param.put("types", "美食");
        param.put("city", "310106");
        param.put("page", "1");
        String result = GaoDeServlet.keyWordSearch(param);
        if (result == null || result.length() == 0) {
            modelAndView.setViewName("/index");
            return modelAndView;
        }
        WebApiResultBo webApiResultBo = JSONObject.parseObject(result, WebApiResultBo.class);
        if (webApiResultBo != null && STATUS.equals(webApiResultBo.getStatus())) {
            List<PoiBo> poiBos = webApiResultBo.getPois();
            if (poiBos !=null && poiBos.size() > 0) {
                modelAndView.setViewName("/jsp/wxh5/restaurant_search_result");
                modelAndView.addObject("poiBos",poiBos);
                return modelAndView;
            }
        }
        modelAndView.setViewName("/index");
        return modelAndView;
    }
    
    
}

