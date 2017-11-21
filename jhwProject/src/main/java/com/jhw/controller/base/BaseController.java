package com.jhw.controller.base;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @ClassName BaseController
 * @Description TODO(controller基类)
 * @author Administrator
 * @Date 2017年10月11日 下午6:18:34
 * @version 1.0.0
 */
public class BaseController {

    /** 分页检索时系统每次会多取一条记录用作判断是否有下一页，实际返回给页面是10条记录 */
    protected final int LIMIT = 11;
    
    /** 1：处理成功 */
    protected final int HANDLE_SUCCESS = 1;
    /** 0：处理失败*/
    protected final int HANDLE_FAILED = 0;
    
    
    /** 1：有下一页*/
    protected final int HAS_NETX_PAGE = 1;
    /** 0：没有下一页, 即最后一页*/
    protected final int NO_NEXT_PAGE = 0;
    /** 1: 有上一页*/
    protected final int HAS_LAST_PAGE = 1;
    /** 0: 没有下一页, 即回到第一页*/
    protected final int NO_LAST_PAGE = 0;
    /** 图片类型是头像图片*/
    protected final int TYPE_HEAD_IMG = 1;
    /** 图片类型是相册图片*/
    protected final int TYPE_PHOTO_IMG = 2;
    /** 日志*/
    protected static Logger logger = Logger.getLogger(BaseController.class);
    /** 文件存放在服务器的硬盘地址*/
    protected final String FILE_UPLOAD_PATH = "E:/tomcatStore/jianghuwei";
    
    protected final String FILE_HOST_PATH = "http://192.168.1.101:8089/fileService";
    /**
     * 拼接规则：userid-head-status-number.jpg
     * 如：1001-head-0-1.jpg
     * @Description (TODO 返回存储头像地址)
     * @param fileName 文件名
     * @return
     */
    protected String getHeadImgStorePath(int userId){
        return FILE_UPLOAD_PATH+"/headImg/"+userId+"-head-0-1.jpg";
    }
    
    /**
     * 拼接规则： userid-photo-status-number.jpg
     * 如：1001-photo-0-1.jpg
     * @Description (TODO 返回存储相册地址)
     * @param fileName 文件名
     * @return 
     */
    protected String getPhotoAlbumStorePath(int userId, int number){
        return FILE_UPLOAD_PATH+"/photoAlbum/"+userId+"-photo-0-"+number+".jpg";
    }
    
    /**
     * 
     * @Description (TODO 拼接图片在文件服务器上的访问路径)
     * @param fileType 文件类型, 1:头像图片，2：相册图片
     * @param userId 用户id
     * @param number 图片序号
     * @return
     */
    protected String getHeadImgHostPath(int fileType, int userId, int number){
        switch (fileType) {
        case TYPE_HEAD_IMG:
            return FILE_HOST_PATH + "/headImg/"+userId+"-head-0-1.jpg";
        case TYPE_PHOTO_IMG:
            return FILE_HOST_PATH + "/photoAlbum/"+userId+"-photo-0-"+number+".jpg";
        }
        return null;
    }
    
    /**
     * @Description (TODO 将异常以json格式返回到前端，可以在ajax的回调中获取到 )
     * @param response
     * @param exceptInfo
     * @return
     */
    protected ModelAndView writeExcInfo(HttpServletResponse response, String exceptInfo){
        response.setCharacterEncoding("utf-8");
        try {
            PrintWriter writer = response.getWriter();
            writer.write(exceptInfo);
            writer.flush();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
    
}
