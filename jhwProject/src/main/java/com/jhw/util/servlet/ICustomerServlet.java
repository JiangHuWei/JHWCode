package com.jhw.util.servlet;

import java.net.HttpURLConnection;

import org.apache.log4j.Logger;

/**
 * @ClassName ICustomerServlet
* @Description TODO(自定义servlet接口, 完成post提交和服务端数据接收)
 * @author Administrator
 * @Date 2017年11月10日 上午11:25:08
 * @version 1.0.0
 */
public interface ICustomerServlet {

    public static Logger logger = Logger.getLogger(ICustomerServlet.class);

    /**
     * @Description (TODO post提交请求)
     * @param urlStr
     *            请求url
     * @param parameterStr
     *            封装的json格式请求参数
     * @return
     */
    public HttpURLConnection doServletPost(String urlStr, String parameterStr);

    /**
     * @Description (TODO 接收服务器返回结果)
     * @param connection doPost方法返回的HttpURLConnection对象
     * @return 结果字符
     */
    public String doGetServerResult(HttpURLConnection connection);
    
    
}
