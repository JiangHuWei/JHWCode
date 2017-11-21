/**
 * MenuManageController.java
 * com.jhw.controller.weixin
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
 * MenuManageController.java
 * com.jhw.controller.weixin
 * Function：TODO 
 *
 *   ver   date	  author
 * ──────────────────────────────────
 *       2017年11月15日  Administrator
 *
 * Copyright (c) 2017, TNT All Rights Reserved.
*/

package com.jhw.controller.weixin;

import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.wx.AccessTokenParamBo;
import com.jhw.bo.wx.ButtonMenuBo;
import com.jhw.bo.wx.HandleResultBo;
import com.jhw.controller.base.BaseController;
import com.jhw.util.servlet.WeiXinServlet;
import com.jhw.util.weixin.UrlConfig_wx;
import com.mysql.fabric.xmlrpc.base.Array;

/**
 * ClassName:MenuManageController
 * Function: TODO 微信自定义菜单管理
 *
 * @author   lil
 * @version  
 * @Date	 2017年11月15日	下午7:34:21
 * @see
 */
@Controller
@RequestMapping("/wx_menu")
public class MenuManageController extends BaseController {

    public String tokenVal = "edtnK0doI-iDMmYtepWzyG8rJ-E4-9orEodzGE8pwyMwoVxjl8W4mJgkwCPpcPnCAnVKWriyp2OQquE1Wt6b34oEKrnQAO93F3Sp-t2ex7bxA-iFJhwpRyPXpaAYdAYQKRBhAAAPWG";
    
    @RequestMapping("/addMenu")
    @ResponseBody
    public String createButtonMenu(HttpServletRequest request){
        HandleResultBo resultBo = new HandleResultBo();
        List<ButtonMenuBo> button = new ArrayList<>();
        ButtonMenuBo toIndexBut = new ButtonMenuBo();
        toIndexBut.setName("江湖味");
        toIndexBut.setType("click");
        toIndexBut.setKey("V1001_INDEX");
        ButtonMenuBo actionBut = new ButtonMenuBo();
        actionBut.setName("活动");
        actionBut.setType("click");
        actionBut.setKey("V1001_action");
        ButtonMenuBo abountBut = new ButtonMenuBo();
        abountBut.setName("关于");
        abountBut.setType("click");
        abountBut.setKey("V1001_about");
        button.add(toIndexBut);
        button.add(actionBut);
        button.add(abountBut);
        Map<String, List<ButtonMenuBo>> buttonBeans = new HashMap<>();
        buttonBeans.put("button", button);
        WeiXinServlet weiXinServlet = new WeiXinServlet();
//        String token = weiXinServlet.getAccessTokenStr("");
//        if (token == null) {
//            return "Token为null";
//        }
        logger.info("请求参数: "+JSONObject.toJSONString(button));
        String reString = weiXinServlet.doServletPost(UrlConfig_wx.getCreateMenuUrl(tokenVal), JSONObject.toJSONString(buttonBeans));
        logger.info("获取菜单结果："+reString);
        
        return JSONObject.toJSONString(resultBo);
    }
    
    
    public static void main(String args[]){
        
        List<ButtonMenuBo> button = new ArrayList<>();
        ButtonMenuBo toIndexBut = new ButtonMenuBo();
        toIndexBut.setName("江湖味");
        toIndexBut.setType("click");
        toIndexBut.setKey("V1001_INDEX");
        ButtonMenuBo actionBut = new ButtonMenuBo();
        actionBut.setName("活动");
        actionBut.setType("click");
        actionBut.setKey("V1001_action");
        ButtonMenuBo abountBut = new ButtonMenuBo();
        abountBut.setName("关于");
        abountBut.setType("click");
        abountBut.setKey("V1001_about");
        button.add(toIndexBut);
        button.add(actionBut);
        button.add(abountBut);
        Map<String, List<ButtonMenuBo>> buttonBeans = new HashMap<>();
        buttonBeans.put("button", button);
        
        logger.info(JSONObject.toJSONString(buttonBeans));
        
    }
}

