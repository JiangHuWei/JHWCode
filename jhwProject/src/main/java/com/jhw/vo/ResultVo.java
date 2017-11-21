package com.jhw.vo;

/**
 * 返回前端的结果描述
 * @ClassName MessageVo
 * @Description TODO(处理结果描述)
 * @author Administrator
 * @Date 2017年9月15日 下午5:29:19
 * @version 1.0.0
 */
public class ResultVo<T> {
    
    /** 令牌是否过期/失效, 1:正常， 0：过期失效*/
    private int isOverdue;
    /** 处理是否成功, 1：成功，0：失败*/
    private int isSuccess = 0;
    /** 处理结果描述*/
    private String message;
    /** 处理完成后跳转的目标页面Url*/
    private String urlStr;
    /** 结果需要分页的时候标识某一页是否有下一页; 1：有下一页，0：没有下一页*/
    private int whetherNextPage;
    /** 结果需要分页的时候标识某一页是否有上一页; 1：有上一页，0：没有上一页,回到第一页*/
    private int whetherLastPage;
    /** 当前是第几页*/
    private int pageNo;
    
    private T resultObj;
    
    private String token;
    
    public int getIsOverdue() {
        return isOverdue;
    }
    
    public void setIsOverdue(int isOverdue) {
        this.isOverdue = isOverdue;
    }

    public int getIsSuccess() {
        return isSuccess;
    }

    public void setIsSuccess(int isSuccess) {
        this.isSuccess = isSuccess;
    }

    public String getMessage() {
        return message;
    }
    
    public void setMessage(String message) {
        this.message = message;
    }
    
    public T getResultObj() {
        return resultObj;
    }
    
    public void setResultObj(T resultObj) {
        this.resultObj = resultObj;
    }
    
    public String getUrlStr() {
        return urlStr;
    }
    
    public void setUrlStr(String urlStr) {
        this.urlStr = urlStr;
    }

    public int getWhetherNextPage() {
        return whetherNextPage;
    }
    
    public void setWhetherNextPage(int whetherNextPage) {
        this.whetherNextPage = whetherNextPage;
    }

    public int getWhetherLastPage() {
        return whetherLastPage;
    }
    
    public void setWhetherLastPage(int whetherLastPage) {
        this.whetherLastPage = whetherLastPage;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
    
}
