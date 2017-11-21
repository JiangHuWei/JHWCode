package com.jhw.util.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.util.List;
import java.util.Map;

import org.apache.log4j.Logger;

/**
 * 
 * ClassName:BaseServlet
 * Function: TODO 自定义Servlet, 模拟Servlet的POST、GET提交
 *
 * @author  lil
 * @version 
 * @since   lil Ver 1.0
 * @Date	2017年11月14日	下午5:07:02
 *
 * @see
 */
public class BaseServlet {

	public static Logger logger = Logger.getLogger(BaseServlet.class);
    
	 /***
     * doServletGet:
     * TODO Servlet GET请求
     * @param  @param url 请求地址
     * @param  @param parameters
     * @return void  
     * @throws 
     * @since  lil Ver 1.0
     */
	public static String doServletGet(String url, Map<String, String> parameters) {
		String result = "";						// 返回的结果
		BufferedReader in = null;				// 读取响应输入流
		StringBuffer sb = new StringBuffer();	// 存储参数
		String params = "";						// 编码之后的参数
		try {
			// 编码请求参数--主要处理参数中的中文
			if (parameters.size() == 1) {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(URLEncoder.encode(parameters.get(name), "UTF-8"));
				}
				params = sb.toString();
			} else {
				for (String name : parameters.keySet()) {
					sb.append(name).append("=").append(URLEncoder.encode(parameters.get(name), "UTF-8"))
							.append("&");
				}
				String temp_params = sb.toString();
				params = temp_params.substring(0, temp_params.length() - 1);
			}
			String full_url = url + "?" + params;
			logger.info(full_url);
			// 创建URL对象
			URL connURL = new URL(full_url);
			// 打开URL连接
			HttpURLConnection httpConn = (HttpURLConnection) connURL.openConnection();
			// 设置通用属性
			httpConn.setRequestProperty("Accept", "*/*");
			httpConn.setRequestProperty("Connection", "Keep-Alive");
			httpConn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 8.0; Windows NT 6.1)");
			// 建立实际的连接
			httpConn.connect();
			// 响应头部获取
			Map<String, List<String>> headers = httpConn.getHeaderFields();
			// 遍历所有的响应头字段
			for (String key : headers.keySet()) {
				logger.info(key + "\t：\t" + headers.get(key));
			}
			// 定义BufferedReader输入流来读取URL的响应,并设置编码方式
			in = new BufferedReader(new InputStreamReader(httpConn.getInputStream(), "UTF-8"));
			String line;
			// 读取返回的内容
			while ((line = in.readLine()) != null) {
				result += line;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (in != null) {
					in.close();
				}
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
		return result;
	}  
	
	
    /**
     * @Description (TODO post提交请求)
     * @param urlStr 请求url
     * @param parameterStr 封装的json格式请求参数
     * @return
     */
    public String doServletPost(String urlStr, String parameterStr){
        try {
            // 服务地址
            URL url = new URL(urlStr);
            // 设定连接的相关参数
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            // 向服务端发送key = value对
            out.write(parameterStr);
            out.flush();
            out.close();
            // 获取服务端的反馈
            String strLine="";
            String strResponse ="";
            InputStream in =connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while((strLine =reader.readLine()) != null) {
                strResponse +=strLine +"\n";
            }
            logger.info("jce: "+strResponse);
            return strResponse;
        } catch (MalformedURLException e) {
            logger.error("WeiXinServletImpl.doServletPost异常： "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("WeiXinServletImpl.doServletPost异常： "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * @Description (TODO 接收服务器返回结果)
     * @param connection doPost方法返回的HttpURLConnection对象
     * @return 结果字符
     */
    public String doGetServerResult(HttpURLConnection connection){
        try {
            if (connection == null) {
                return null;
            }
            // 获取服务端的反馈
            String strLine="";
            String strResponse ="";
            InputStream in =connection.getInputStream();
            BufferedReader reader = new BufferedReader(new InputStreamReader(in));
            while((strLine =reader.readLine()) != null) {
                strResponse +=strLine +"\n";
            }
            logger.info("jce: "+strResponse);
            return strResponse;
        } catch (MalformedURLException e) {
            logger.error("WeiXinServletImpl.doGetServerResult异常： "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("WeiXinServletImpl.doGetServerResult异常： "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
}
