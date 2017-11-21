package com.jhw.util.token;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;
import java.util.Date;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @ClassName TokenManage
 * @Description TODO(token令牌处理)
 * @author Administrator
 * @Date 2017年9月22日 下午3:41:06
 * @version 1.0.0
 */
public class TokenUtil {

    static Logger mLogger = LoggerFactory.getLogger(TokenUtil.class);
    
    
    /**
     * @Description (TODO token登录验证令牌是否失效)
     * @param session 
     * @param tokenStr 客户端传递的令牌
     * @return true: 有效, false：已失效
     */
    public static boolean doValidateTokenInfo(HttpSession session, String tokenStr){
        //token登录验证
        if (tokenStr == null || tokenStr.length() == 0) {
            return false;
        }
        String valueStr = (String) session.getAttribute(tokenStr);
        if (valueStr == null || valueStr.length() == 0) {
            mLogger.info("令牌失效");
            return false;
        }
        String[] idAndTimeStamp = valueStr.split("-");
        if (idAndTimeStamp == null || idAndTimeStamp[1]==null) {
            mLogger.info("令牌失效");
            return false;
        }
        Long oldTimeStamp = Long.valueOf(idAndTimeStamp[1]);
        Long currentTimeStamp = new Date().getTime();
        long day = (int) ((currentTimeStamp - oldTimeStamp)/(1000*60*60*24));
        if (day>3) {
            mLogger.info("令牌过期");
            //令牌过期，删除session中的令牌值
            session.removeAttribute(tokenStr);
            return false;
        }else{
            return true;
        }
        //第一次登录，token构建与存储
    }
    
    /**
     * @Description (TODO 根据用户id、时间戳、UserPoJo的json构建value值)
     * @param session
     * @param userId
     * @param timeStamp
     * @return
     */
    public static String structureTokenValue(String userId, String timeStamp, String userPojoJson){
        if (userId!=null && timeStamp!=null) {
            return userId+"-"+timeStamp+"-"+userPojoJson;
        }else {
            return null;
        }
    }
    
    /**
     * @Description (TODO 解析token的value值, 数组下标0是用户id,下标1是时间戳)
     * @param tokenVal
     * @return
     */
    public static String[] analiseTokenValue(String tokenVal){
        if (tokenVal == null || tokenVal.length() == 0) {
            return null;
        }
        String[] idAndTimeStamp = tokenVal.split("-");
        if (idAndTimeStamp == null || idAndTimeStamp.length == 0) {
            return null;
        }
        return idAndTimeStamp;
    }
    
    /**
     * @Description (TODO 字典排序)
     * @param token
     * @param timestamp
     * @param nonce
     * @return
     */
    public static String wxSort(String token, String timestamp, String nonce){
        try {
            String[] strArray = {token, timestamp, nonce};
            Arrays.sort(strArray);
            StringBuilder sBuilder = new StringBuilder();
            for(String str : strArray){
                sBuilder.append(str);
            }
            return sBuilder.toString();
        } catch (Exception e) {
            // TODO: handle exception
            mLogger.error("TokenUtil.wxSort异常："+e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
    /**
     * @Description (TODO sha1加密)
     * @param str
     * @return
     */
    public static String SHA1(String decript) {
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-1");
            digest.update(decript.getBytes());
            byte messageDigest[] = digest.digest();
            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            // 字节数组转换为 十六进制 数
            for (int i = 0; i < messageDigest.length; i++) {
                String shaHex = Integer.toHexString(messageDigest[i] & 0xFF);
                if (shaHex.length() < 2) {
                    hexString.append(0);
                }
                hexString.append(shaHex);
            }
            return hexString.toString();
        } catch (NoSuchAlgorithmException e) {
            // TODO Auto-generated catch block
            mLogger.error("TokenUtil.SHA1异常：" + e.getMessage());
            e.printStackTrace();
            return null;
        }
    }
    
}
