package com.jhw.util.uuid;

import java.util.UUID;

/**
 * 
 * @ClassName UUIdUtil
 * @Description TODO(UUID生成管理)
 * @author Administrator
 * @Date 2017年9月22日 下午12:45:42
 * @version 1.0.0
 */
public class UUIdUtil {

    /**
     * 
     * @Description (TODO 获取一个UUID)
     * @return 
     */
    public static String getUUid(){
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString(); 
        String uuidStr=str.replace("-", "");
        return uuidStr;
    }
    
    public static void main(String[]args) {
        
        System.out.println(getUUid());
    }
    
}
