package com.jhw.util.base64;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import sun.misc.*;

/**
 * 
 * @ClassName Base64AndImageUtil
 * @Description TODO(图片和base64相互转换)
 * @author Administrator
 * @Date 2017年10月18日 下午3:35:46
 * @version 1.0.0
 */
public class Base64AndImageUtil {

    /**
     * 
     * @Description (TODO 图片base64字符串转图片并存储)
     * @param imgStr base64编码字符串
     * @param path 图片路径-具体到文件
     * @return
     */
    @SuppressWarnings("restriction")
    public static boolean generateImage(String imgStr, String path) {
        if (imgStr == null)
        {
            return false;
        }
        imgStr = imgStr.replaceAll("data:image/png;base64,", "");
        BASE64Decoder decoder = new BASE64Decoder();
        byte[] b = null;
        try {
            b = decoder.decodeBuffer(imgStr);
            for (int i = 0; i < b.length; ++i) {
                if (b[i] < 0) {
                b[i] += 256;
                }
            }
            // 生成文件
            File imageFile = new File(path);
            imageFile.createNewFile();
            if (!imageFile.exists()) {
                imageFile.createNewFile();
            }
            OutputStream imageStream = new FileOutputStream(imageFile);
            imageStream.write(b);
            imageStream.flush();
            imageStream.close();
            return true;
        } catch (Exception e) {
            return false;
        }
    }
    
    /**
     * @Description (TODO 根据图片地址吧图片转为base64字符串)
     * @param imgFile 图片路径
     * @return base64字符串
     */
    @SuppressWarnings("restriction")
    public static String getImageStr(String imgFile) {
        InputStream inputStream = null;
        byte[] data = null;
        try {
            inputStream = new FileInputStream(imgFile);
            data = new byte[inputStream.available()];
            inputStream.read(data);
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        // 加密
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
    
    
}
