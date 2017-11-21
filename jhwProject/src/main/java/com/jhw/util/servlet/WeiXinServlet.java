package com.jhw.util.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.wx.AccessTokenParamBo;
import com.jhw.bo.wx.AccessTokenResultBo;
import com.jhw.bo.wx.HandleResultBo;
import com.jhw.bo.wx.TemplateMsgBo;
import com.jhw.bo.wx.UserListResultBo;
import com.jhw.util.weixin.UrlConfig_wx;

/**
 * 
 * @ClassName CustomeServlet
 * @Description TODO(自定义post数据提交与结果接收)
 * @author Administrator
 * @Date 2017年11月8日 下午7:34:02
 * @version 1.0.0
 * 
 * https://api.weixin.qq.com/cgi-bin/token
 * grant_type=client_credential&appid=wx6b196164128e8a90&secret=973ede448dc2ec148a439f57498ae312
 */
public class WeiXinServlet extends BaseServlet{

    public static Logger logger = Logger.getLogger(WeiXinServlet.class);
    
//    /**
//     * @Description (TODO post提交请求)
//     * @param urlStr 请求url
//     * @param parameterStr 封装的json格式请求参数
//     * @return
//     */
//    @Override
//    public HttpURLConnection doServletPost(String urlStr, String parameterStr){
//        try {
//            // 服务地址
//            URL url = new URL(urlStr);
//            // 设定连接的相关参数
//            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
//            connection.setDoOutput(true);
//            connection.setRequestMethod("POST");
//            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
//            // 向服务端发送key = value对
//            out.write(parameterStr);
//            out.flush();
//            out.close();
//            return connection;
//        } catch (MalformedURLException e) {
//            logger.error("WeiXinServletImpl.doServletPost异常： "+e.getMessage());
//            e.printStackTrace();
//        } catch (IOException e) {
//            logger.error("WeiXinServletImpl.doServletPost异常： "+e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
//    
//    /**
//     * @Description (TODO 接收服务器返回结果)
//     * @param connection doPost方法返回的HttpURLConnection对象
//     * @return 结果字符
//     */
//    @Override
//    public String doGetServerResult(HttpURLConnection connection){
//        try {
//            if (connection == null) {
//                return null;
//            }
//            // 获取服务端的反馈
//            String strLine="";
//            String strResponse ="";
//            InputStream in =connection.getInputStream();
//            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
//            while((strLine =reader.readLine()) != null) {
//                strResponse +=strLine +"\n";
//            }
//            logger.info("jce: "+strResponse);
//            return strResponse;
//        } catch (MalformedURLException e) {
//            logger.error("WeiXinServletImpl.doGetServerResult异常： "+e.getMessage());
//            e.printStackTrace();
//        } catch (IOException e) {
//            logger.error("WeiXinServletImpl.doGetServerResult异常： "+e.getMessage());
//            e.printStackTrace();
//        }
//        return null;
//    }
    
    /**
     * @Description (TODO 发送模板消息)
     * @param urlStr 模板消息发送请求地址
     * @param templateMsgBo 请求参数bean
     * @return HandleResultBo
     */
    public HandleResultBo sendModelMessage(String tokenVal,TemplateMsgBo templateMsgBo){
        UserListResultBo userListResultBo = getUserList(tokenVal);
        // 发送模板消息
        TemplateMsgBo msgBo = new TemplateMsgBo();
        if (userListResultBo != null) {
            TreeMap<String, List<String>> openIdObjs = userListResultBo.getData();
            List<String> openidList = openIdObjs.get("openid");
            for (String tmp : openidList) {
                msgBo.setTouser(tmp);
                msgBo.setTemplate_id("-3NQ2jgwi--5b6i2yQ1JLdpMk1heJB1CPLSLqrdJlJY");
                msgBo.setUrl("http://101.132.155.221/");
                TreeMap<String, TreeMap<String, String>> data = new TreeMap<>();
                TreeMap<String, String> firstMap = new TreeMap<>();
                firstMap.put("value", "下午茶888");
                firstMap.put("color", "#173177");
                data.put("first", firstMap);
                TreeMap<String, String> keynote1Map = new TreeMap<>();
                keynote1Map.put("value", "没事坐下来喝点东西聊聊天");
                keynote1Map.put("color", "#173177");
                data.put("keynote1", keynote1Map);
                TreeMap<String, String> keynote2Map = new TreeMap<>();
                keynote2Map.put("value", "2017-11-10");
                keynote2Map.put("color", "#173177");
                data.put("keynote2", keynote2Map);
                TreeMap<String, String> keynote3Map = new TreeMap<>();
                keynote3Map.put("value", "环智大厦一点点");
                keynote3Map.put("color", "#173177");
                data.put("keynote3", keynote3Map);
                TreeMap<String, String> remarkMap = new TreeMap<>();
                remarkMap.put("value", "模板消息测试,666");
                remarkMap.put("color", "#173177");
                data.put("remark", remarkMap);
                msgBo.setData(data);
                logger.info(JSONObject.toJSONString(msgBo));
            }
        }
        String templateMsgResultStr = doServletPost(UrlConfig_wx.getSendTemplateMsgUrl(tokenVal), JSONObject.toJSONString(msgBo));
        if (templateMsgResultStr != null && templateMsgResultStr.length() > 0) {
            HandleResultBo handleResultBo = JSONObject.parseObject(templateMsgResultStr,HandleResultBo.class);
            if (handleResultBo != null) {
                logger.info(handleResultBo.getErrcode() + "  " + handleResultBo.getErrmsg());
                return handleResultBo;
            }
        }
        return null;
    }
    
    /**
     * @Description (TODO 获取关注了公众号的用户信息,其中包含了用户的openid)
     * @param tokenVal
     * @return
     */
    public UserListResultBo getUserList(String tokenVal){
        UserListResultBo userListResultBo = null;
        String userListResultStr = doServletPost(UrlConfig_wx.getUserListUrl(tokenVal), "");
        if (userListResultStr !=null && userListResultStr.length() > 0) {
            userListResultBo = JSONObject.parseObject(userListResultStr, UserListResultBo.class);
            if (userListResultBo!=null) {
                TreeMap<String, List<String>> openIdObjs = userListResultBo.getData();
                List<String> openidList = openIdObjs.get("openid");
                if (openidList!=null && openidList.size()>0) {
                    return userListResultBo;
                }
            }
        }
        return userListResultBo;
    }
    
    /**
     * @Description (TODO 获取access_token ,每个access_token有效期只有2小时)
     * @param tokenParamStr 获取token请求参数JSON
     * @return
     */
    public String getAccessTokenStr(String tokenParamStr){
//        AccessTokenParamBo paramBo = new AccessTokenParamBo();
//        paramBo.setGrant_type("client_credential");
//        paramBo.setAppid("wx6b196164128e8a90");
//        paramBo.setSecret("973ede448dc2ec148a439f57498ae312");
        //------------------------------------------------------------------------------------------------------
        String tokenStr = null;
//        HttpURLConnection connection = doServletPost(UrlConfig_wx.ACCESS_TOKEN_URL, JSONObject.toJSONString(paramBo));
        Map<String, String> parameters = new HashMap<>();
        parameters.put("grant_type", "client_credential");
        parameters.put("appid", "wx6b196164128e8a90");
        parameters.put("secret", "973ede448dc2ec148a439f57498ae312");
        tokenStr = doServletGet(UrlConfig_wx.ACCESS_TOKEN_URL, parameters);
        if (tokenStr !=null && tokenStr.length() > 0) {
            int ifError = tokenStr.indexOf("errcode");
            if (ifError > 0) {
                logger.error("WeiXinServlet.getAccessTokenStr获取token错误："+tokenStr);
                return null;
            } else {
                AccessTokenResultBo tokenBo = JSONObject.parseObject(tokenStr, AccessTokenResultBo.class);
                if (tokenBo == null) {
                    logger.error("解析token异常");
                    return null;
                }
                if (tokenBo.getAccess_token() != null) {
                    logger.info("TOKEN: "+tokenBo.getAccess_token());
                    return tokenBo.getAccess_token();
                }
            }
        }
        return null;
    }
    
    
}
