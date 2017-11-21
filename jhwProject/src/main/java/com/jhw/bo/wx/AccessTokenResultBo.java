package com.jhw.bo.wx;

import com.jhw.bo.BaseBo;


/**
 * @ClassName AccessTokenBo
 * @Description TODO(微信接口bean，微信access_token获取结果bean)
 * @author Administrator
 * @Date 2017年11月8日 下午5:54:33
 * @version 1.0.0
 * @interface https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=APPID&secret=APPSECRET
 * @param grant_type 获取access_token填写client_credential
 * @param appid 第三方用户唯一凭证
 * @param secret 第三方用户唯一凭证密钥，即appsecret
 */
public class AccessTokenResultBo extends BaseBo {

    
    /** 获取到的凭证*/
    private String access_token;
    
    /** 凭证有效时间，单位：秒*/
    private String expires_in;
    
    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }
    
    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }
    
}
