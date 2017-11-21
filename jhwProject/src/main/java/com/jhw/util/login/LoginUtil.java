package com.jhw.util.login;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.apache.xpath.operations.Bool;

/**
 * @ClassName LoginUtil
 * @Description TODO(登录操作工具类)
 * @author Administrator
 * @Date 2017年9月29日 下午4:21:00
 * @version 1.0.0
 */
public class LoginUtil {

    /** 错误次数已到三次*/
    public static final String achieveThree = "three";
    /** 错误次数已到六次*/
    public static final String achieveSix = "six";
    /** 是否冻结*/
    public static final String freeze = "isfreeze";
    /** 三十分钟*/
    private final static int THIRTY_MINUTE = 30;
    /**
     * @Description (TODO 检测账号是否解冻和输入错误次数是否达到3次和6次)
     * @param session 
     * @param loginName 用户登录名称 
     * @return 
     */
    public static Map<String, Boolean> checkAccountState(HttpSession session, String loginName){
        Map<String, Boolean> result = new HashMap<>();
        String accountState = (String) session.getAttribute(loginName);
        if (accountState != null && accountState.length()>0) {   
            String[] tmpArray = accountState.split("-");
            Integer count = Integer.valueOf(tmpArray[0]);   //失败次数
            Long timeStamp = Long.valueOf(tmpArray[1]);     //上一次登录时间
            if (count == 3) {
                //用户密码输入错误次数已达三次，检查冻结时间是否超过十分钟
                Long currentTimeStamp = System.currentTimeMillis();
                long minutes = (currentTimeStamp - timeStamp)/(1000*60);
                if (minutes>THIRTY_MINUTE) {   //冻结时间已到三十分钟，解冻。
                    result.put(freeze, true);
                }else {
                    result.put(freeze, false);
                }
                result.put(achieveThree, true);
                result.put(achieveSix, false);
            }else if (count == 6) {     
                //当密码输错次数达到6次时,用户表的status字段属性被置为-1,所以此处不加约束,由数据库约束
                result.put(freeze, true);
                result.put(achieveSix, true);
            }else {
                result.put(freeze, true);
                result.put(achieveSix, false);
            }
        }else{
            result.put(freeze, true);
            result.put(achieveThree, false);
            result.put(achieveSix, false);
        }
        return result;
    }

    
    
}
