package com.jhw.util.servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.log4j.Logger;

import com.alibaba.fastjson.JSONObject;

/**
 * @ClassName GaoDeMapServletImpl
 * @Description TODO(高德地图web服务API调用处理)
 * @author Administrator
 * @Date 2017年11月13日 下午6:08:47
 * @version 1.0.0
 */
public class GaoDeMapServletImpl  {
//    implements ICustomerServlet
    public static Logger logger = Logger.getLogger(GaoDeMapServletImpl.class);
    
    /**
     * @Description (TODO post提交请求)
     * @param urlStr 请求url
     * @param parameterStr 封装的json格式请求参数
     * @return
     */
//    @Override
    public HttpURLConnection doServletPost(String urlStr, String parameterStr){
        try {
            // 服务地址
            URL url = new URL(urlStr);
            // 设定连接的相关参数
            HttpURLConnection connection= (HttpURLConnection) url.openConnection();
            connection.setDoOutput(true);
//            connection.setDoInput(true);
//            connection.setRequestMethod("GET");
//            connection.setRequestProperty("Connection", "Keep-Alive");
//            connection.setRequestProperty("Charsert", "UTF-8");
//            connection.setRequestProperty("Content-Type", "application/xml; charset=UTF-8");
            OutputStreamWriter out = new OutputStreamWriter(connection.getOutputStream(), "UTF-8");
            // 向服务端发送key = value对
//            out.write(parameterStr);
            out.flush();
            out.close();
            return connection;
        } catch (MalformedURLException e) {
            logger.error("GaoDeMapServletImpl.doServletPost异常： "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("GaoDeMapServletImpl.doServletPost异常： "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    /**
     * @Description (TODO 接收服务器返回结果)
     * @param connection doPost方法返回的HttpURLConnection对象
     * @return 结果字符
     */
//    @Override
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
            return strResponse;
        } catch (MalformedURLException e) {
            logger.error("GaoDeMapServletImpl.doGetServerResult异常： "+e.getMessage());
            e.printStackTrace();
        } catch (IOException e) {
            logger.error("GaoDeMapServletImpl.doGetServerResult异常： "+e.getMessage());
            e.printStackTrace();
        }
        return null;
    }
    
    
    public static void main(String args[]){
        
    }
    
    /**
     * @Description (TODO poi结果列表)
     * 开发参考 http://lbsyun.baidu.com/index.php?title=webapi/guide/webservice-placeapi
     */
    public void baiduMap(){
        String path = "http://api.map.baidu.com/place/v2/search?query=肯德基&tag=美食$快餐&region=上海&output=json"
                + "&ak=HxqyctsdgCkAKsPUfRB5BKRbhOVGEnXv&scope=2&page_size=20";
        HttpURLConnection connection = doServletPost(path, "");
        String result = doGetServerResult(connection);
        if (result != null && result.length() > 0) {
            logger.info(result);
        } 
    }
    /**
     * @Description (TODO poi详情)
     */
    public void baiduMapPOIDetail(){
        String path = "http://api.map.baidu.com/place/v2/detail?uid=8e34bab9b6145ec943d63ee7&output=json&scope=2&ak=HxqyctsdgCkAKsPUfRB5BKRbhOVGEnXv";
        HttpURLConnection connection = doServletPost(path, "");
        String result = doGetServerResult(connection);
        if (result != null && result.length() > 0) {
            logger.info(result);
        } 
    }
    
    
    
    public void gaoDeMap() {
        String gaoDePath = "http://restapi.amap.com/v3/place/text?key=2218472a9c1d25dec425c8a7349f514e&keywords=麻辣烫&output=json&city=310106&citylimit=true&extensions=all&page=10&offset=5";
        String argoundPath = "http://restapi.amap.com/v3/place/around?key=2218472a9c1d25dec425c8a7349f514e&location=116.456299,39.960767&keywords=肯德基&output=json&radius=10000&types=餐饮&extensions=all";
        HttpURLConnection connection = doServletPost(gaoDePath, "");
        String result = doGetServerResult(connection);
        logger.info(result);
    }
    
    public static class GaoDeRequestParam{
        
        private String key;
        
        private String keywords;
        
        private String types;
        
        private String city;
        
        private boolean citylimit;
        
        private Integer children;
        
        private Integer offset;
        
        private Integer page;
        
        private String building;
        
        private Integer floor;
        
        private String extensions;
        
        private String sig;
        
        private String output;
        
        private String callback;

        
        public String getKey() {
            return key;
        }

        
        public void setKey(String key) {
            this.key = key;
        }

        
        public String getKeywords() {
            return keywords;
        }

        
        public void setKeywords(String keywords) {
            this.keywords = keywords;
        }

        
        public String getTypes() {
            return types;
        }

        
        public void setTypes(String types) {
            this.types = types;
        }

        
        public String getCity() {
            return city;
        }

        
        public void setCity(String city) {
            this.city = city;
        }

        
        public boolean isCitylimit() {
            return citylimit;
        }

        
        public void setCitylimit(boolean citylimit) {
            this.citylimit = citylimit;
        }

        
        public Integer getChildren() {
            return children;
        }

        
        public void setChildren(Integer children) {
            this.children = children;
        }

        
        public Integer getOffset() {
            return offset;
        }

        
        public void setOffset(Integer offset) {
            this.offset = offset;
        }

        
        public Integer getPage() {
            return page;
        }

        
        public void setPage(Integer page) {
            this.page = page;
        }

        
        public String getBuilding() {
            return building;
        }

        
        public void setBuilding(String building) {
            this.building = building;
        }

        
        public Integer getFloor() {
            return floor;
        }

        
        public void setFloor(Integer floor) {
            this.floor = floor;
        }

        
        public String getExtensions() {
            return extensions;
        }

        
        public void setExtensions(String extensions) {
            this.extensions = extensions;
        }

        
        public String getSig() {
            return sig;
        }

        
        public void setSig(String sig) {
            this.sig = sig;
        }

        
        public String getOutput() {
            return output;
        }

        
        public void setOutput(String output) {
            this.output = output;
        }

        
        public String getCallback() {
            return callback;
        }

        
        public void setCallback(String callback) {
            this.callback = callback;
        }
    }
    
    public static class GDErrorResult{
//        {"status":"0","info":"INVALID_USER_KEY","infocode":"10001"}
        
        private String status;
        
        private String info;
        
        private String infocode;
        
        public String getStatus() {
            return status;
        }
        
        public void setStatus(String status) {
            this.status = status;
        }
        
        public String getInfo() {
            return info;
        }

        public void setInfo(String info) {
            this.info = info;
        }

        public String getInfocode() {
            return infocode;
        }

        public void setInfocode(String infocode) {
            this.infocode = infocode;
        }
        
    }
}
