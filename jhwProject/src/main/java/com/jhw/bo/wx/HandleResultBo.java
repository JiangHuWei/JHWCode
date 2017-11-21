package com.jhw.bo.wx;

import com.jhw.bo.BaseBo;

/**
 * @ClassName HandleResultBo
 * @Description TODO(微信接口bean，处理结果bean)
 * @author Administrator
 * @Date 2017年11月9日 下午2:51:03
 * @version 1.0.0
 */
public class HandleResultBo extends BaseBo {

    /** 错误码, 0表示处理成功*/
    private Integer errcode;
    
    /** 错误消息*/
    private String errmsg;
    
    /** 消息id*/
    private String msgid;
    
    public Integer getErrcode() {
        return errcode;
    }
    
    public void setErrcode(Integer errcode) {
        this.errcode = errcode;
    }
    
    public String getErrmsg() {
        return errmsg;
    }
    
    public void setErrmsg(String errmsg) {
        this.errmsg = errmsg;
    }
    
    public String getMsgid() {
        return msgid;
    }

    public void setMsgid(String msgid) {
        this.msgid = msgid;
    }
    
    
}
