package com.jhw.util.weixin;

/***
 * @ClassName UrlConfig_wx
 * @Description TODO(微信业务请求URL配置类)
 * @author Administrator
 * @Date 2017年11月10日 上午11:53:05
 * @version 1.0.0
 */
public class UrlConfig_wx {
    
    /** 微信access_token获取地址*/
    public static final String ACCESS_TOKEN_URL = "https://api.weixin.qq.com/cgi-bin/token";
    
    /**
     * @Description (TODO 获取用户列表请求URL, 用户列表中包含了用户的openid)
     * @param tokenStr 微信分配令牌
     * @return
     */
    public static String getUserListUrl(String tokenStr){
        if (tokenStr == null || tokenStr.length() < 10) {
            return null;
        }
        return "https://api.weixin.qq.com/cgi-bin/user/get?access_token="+tokenStr;
    }
    
    /**
     * @Description (TODO 获取发送模板消息请求URL)
     * @param tokenStr 微信分配令牌
     * @return
     */
    public static String getSendTemplateMsgUrl(String tokenStr){
        if (tokenStr == null || tokenStr.length() < 10) {
            return null;
        }
        return "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token="+tokenStr;
    }
    
    /**
     * getCreateMenuUrl:
     * TODO 获取创建菜单url
     * @param  @param tokenStr  微信分配令牌
     */
    public static String getCreateMenuUrl(String tokenStr){
        if (tokenStr == null || tokenStr.length() < 10) {
            return null;
        }
        return "https://api.weixin.qq.com/cgi-bin/menu/create?access_token="+tokenStr;
    }
    
    
    
    
    
    
    
}
