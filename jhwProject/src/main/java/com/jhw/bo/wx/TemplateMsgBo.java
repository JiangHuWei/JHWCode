package com.jhw.bo.wx;

import java.util.TreeMap;

import com.alibaba.fastjson.JSONObject;
import com.jhw.bo.BaseBo;

/**
 * @ClassName TemplateMsgBo
 * @Description TODO(微信接口bean，模板消息请求参数 )
 * @author Administrator
 * @Date 2017年11月9日 上午11:19:00
 * @version 1.0.0
 * @interface https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN
 * @param touser 接收者openid
 * @param template_id 模板ID
 * @param url 模板跳转链接
 * @param miniprogram 跳小程序所需数据，不需跳小程序可不用传该数据
 * @param appid 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，并且小程序要求是已发布的）
 * @param pagepath 所需跳转到小程序的具体页面路径，支持带参数,（示例index?foo=bar）
 * @param data 模板数据
 * @param color 模板内容字体颜色，不填默认为黑色
 */
public class TemplateMsgBo extends BaseBo {

    /** 接收者openid*/
    private String touser;
    /** 模板ID*/
    private String template_id;
    /** 模板跳转链接*/
    private String url;

    /** 模板跳转链接*/
//    private String topcolor;
    
    /** 跳小程序所需数据，不需跳小程序可不用传该数据*/
    private TreeMap<String, String> miniprogram;

    /** 所需跳转到的小程序appid（该小程序appid必须与发模板消息的公众号是绑定关联关系，并且小程序要求是已发布的）*/
    private TreeMap<String, TreeMap<String,String>> data;
    
    public String getTouser() {
        return touser;
    }

    public void setTouser(String touser) {
        this.touser = touser;
    }
    
    public String getTemplate_id() {
        return template_id;
    }
    
    public void setTemplate_id(String template_id) {
        this.template_id = template_id;
    }

    public String getUrl() {
        return url;
    }
    
    public void setUrl(String url) {
        this.url = url;
    }
    
//    public String getTopcolor() {
//        return topcolor;
//    }
//    
//    public void setTopcolor(String topcolor) {
//        this.topcolor = topcolor;
//    }

    public TreeMap<String, String> getMiniprogram() {
        return miniprogram;
    }
    
    public void setMiniprogram(TreeMap<String, String> miniprogram) {
        this.miniprogram = miniprogram;
    }

    public TreeMap<String, TreeMap<String, String>> getData() {
        return data;
    }

    public void setData(TreeMap<String, TreeMap<String, String>> data) {
        this.data = data;
    }

    public static void main(String[] args) {
        TemplateMsgBo bo = new TemplateMsgBo();
        bo.setTouser("touser6666");
        bo.setTemplate_id("-3NQ2jgwi--5b6i2yQ1JLdpMk1heJB1CPLSLqrdJlJY");
        bo.setUrl("https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=ACCESS_TOKEN");
        
        TreeMap<String, String> miniprogramMap = new TreeMap<>();
        miniprogramMap.put("appid", "xiaochengxuappid12345");
        miniprogramMap.put("pagepath", "index?foo=bar");
//        bo.setMiniprogram(miniprogramMap);
        
        TreeMap<String, String> first = new TreeMap<>();
        first.put("value", "恭喜你购买成功！");
        first.put("color", "#173177");
        TreeMap<String, String> keynote1 = new TreeMap<>();
        keynote1.put("value", "巧克力");
        keynote1.put("color", "#173177");
        TreeMap<String, String> keynote2 = new TreeMap<>();
        keynote2.put("value", "39.8元");
        keynote2.put("color", "#173177");
        TreeMap<String, String> keynote3 = new TreeMap<>();
        keynote3.put("value", "2014年9月22日");
        keynote3.put("color", "#173177");
        TreeMap<String, String> remark = new TreeMap<>();
        remark.put("value", "欢迎再次购买！");
        remark.put("color", "#173177");
        
        TreeMap<String, TreeMap<String,String>> dataMap = new TreeMap<>();
        dataMap.put("first", first);
        dataMap.put("keynote1", keynote1);
        dataMap.put("keynote2", keynote2);
        dataMap.put("keynote3", keynote3);
        dataMap.put("remark", remark);
        bo.setData(dataMap);
        
        String jsonObject = JSONObject.toJSONString(bo);
        System.out.println(jsonObject);
    }
    
}
