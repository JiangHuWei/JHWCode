package com.jhw.controller.backstage;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSON;
import com.jhw.controller.base.BaseController;
import com.jhw.pojo.TablePoJo;
import com.jhw.pojo.UserPoJo;
import com.jhw.util.token.TokenUtil;
import com.sun.xml.messaging.saaj.packaging.mime.internet.HeaderTokenizer.Token;

/**
 * 
 * @ClassName UtilController
 * @Description TODO(页面中转控制)
 * @author Administrator
 * @Date 2017年10月20日 下午12:29:51
 * @version 1.0.0
 */
@Controller
@RequestMapping("/util")
public class UtilController extends BaseController{

    
    /**
     * @Description (TODO 页面中转到用户信息编辑页面 user_info_edit.jsp)
     * @param request
     * @param urlStr
     * @param resultObj
     * @return
     */
    @RequestMapping(value="/transfer_2_useredit")
    @ResponseBody
    public ModelAndView transferToUserEdit(HttpServletRequest request , String urlStr, String resultObj){
        ModelAndView modelAndView = new ModelAndView();
        if (urlStr!=null && resultObj != null && resultObj.length()>0) {
            try {
                UserPoJo userPoJo = JSON.parseObject(resultObj, UserPoJo.class);
                modelAndView.setViewName(urlStr);
                modelAndView.addObject("result", userPoJo);
                return modelAndView;
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
        return null;
    }
    
    @RequestMapping(value="/transfer_2_tabledetail")
    @ResponseBody
    public ModelAndView transferToTableDetail(HttpServletRequest request , String urlStr, String resultObj){
        ModelAndView modelAndView = new ModelAndView();
        if (urlStr!=null && resultObj != null && resultObj.length()>0) {
            try {
                TablePoJo resultPoJo = JSON.parseObject(resultObj, TablePoJo.class);
                modelAndView.setViewName(urlStr);
                modelAndView.addObject("result", resultPoJo);
                return modelAndView;
            } catch (Exception e) {
                logger.info(e.getMessage());
            }
        }
        return null;
    }
    
    private final String TOKEN_STR = "jhw666";
    
    /**
     * @Description (TODO 微信token验证 处理)
     * @param request
     * @param signature
     * @param timestamp
     * @param nonce
     * @param echostr
     * @return
     */
    @RequestMapping("/wx_validator")
    @ResponseBody
    public String toValidatorWXToken(HttpServletRequest request,String signature, String timestamp, String nonce,String echostr){
        logger.info("signature: "+signature+"  --  timestamp："+timestamp+"  -- nonce："+nonce+"  -- echostr："+echostr);
        String sortResult = TokenUtil.wxSort(TOKEN_STR, timestamp, nonce);
        logger.info("字典排序："+sortResult);
        String shaResult = TokenUtil.SHA1(sortResult);
        logger.info("签名结果："+shaResult);
        if (shaResult!=null && shaResult.length()>0 && signature.equals(shaResult)) {
            logger.info("微信接口token验证通过");
            
            
            return echostr;
        }else{
            logger.info("微信接口token验证失败");
            return "";
        }
    }
    
}
