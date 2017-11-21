package com.jhw.util.safe;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.log4j.Logger;

/**
 * @ClassName SqlInjectionFilter
 * @Description TODO(sql注入过滤器)
 * @author Administrator
 * @Date 2017年11月1日 下午3:11:34
 * @version 1.0.0
 */
public class SqlInjectionFilter implements Filter {

    Logger logger = Logger.getLogger(SqlInjectionFilter.class);
    
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // TODO Auto-generated method stub
        logger.info("=================================SQL注入过滤器启动=================================");
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        // TODO Auto-generated method stub
//        logger.info("开始过滤");
        HttpServletRequest req=(HttpServletRequest)request;
        HttpServletResponse res=(HttpServletResponse)response;
         //获得所有请求参数名
        Enumeration params = req.getParameterNames();
        String sql = "";
        while (params.hasMoreElements()) {
            //得到参数名
            String name = params.nextElement().toString();
            //得到参数对应值
            String[] value = req.getParameterValues(name);
            for (int i = 0; i < value.length; i++) {
                sql = sql + value[i];
            }
        }
        //有sql关键字，跳转到error.html
//        if (sqlValidate(sql)) {
            if (false) {
            logger.info("！！！！！！！！！！！！！！！！！包含sql注入关键词！！！！！！！！！！！！！！！！！");
            throw new IOException("参数错误");
        } else {
//            logger.info("纯洁无暇的参数");
            chain.doFilter(request,response);
        }
    }

    @Override
    public void destroy() {
        // TODO Auto-generated method stub
        logger.info("过滤结束");
    }

    
    /**
     * @Description (TODO这里用一句话描述这个方法的作用)
     * @param str
     * @return
     */
    public boolean sqlValidate(String str) {
        str = str.toLowerCase();//统一转为小写
//        String badStr = "'|and|exec|execute|insert|select|delete|update|count|drop|*|%|chr|mid|master|truncate|" +
//                "char|declare|sitename|net user|xp_cmdshell|;|or|-|+|,|like'|and|exec|execute|insert|create|drop|" +
//                "table|from|grant|use|group_concat|column_name|" +
//                "information_schema.columns|table_schema|union|where|select|delete|update|order|by|count|*|" +
//                "chr|mid|master|truncate|char|declare|or|;|-|--|+|,|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加
        String badStr = "'|exec|execute|insert|select|delete|update|count|drop|*|%|mid|master|truncate|" +
                "char|declare|sitename|net user|xp_cmdshell|or|+|like'|and|exec|execute|insert|create|drop|" +
                "from|grant|use|group_concat|column_name|" +
                "information_schema.columns|union|where|select|delete|update|order|by|count|*|" +
                "mid|master|truncate|char|declare|or|--|like|//|/|%|#";//过滤掉的sql关键字，可以手动添加
        String[] badStrs = badStr.split("\\|");
        for (int i = 0; i < badStrs.length; i++) {
            if (str.indexOf(badStrs[i]) >= 0) {
                logger.info("sql关键词： "+badStrs[i]);
                return true;
            }
        }
        return false;
    }
}
