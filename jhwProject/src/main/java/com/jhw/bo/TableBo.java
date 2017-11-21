package com.jhw.bo;

import java.util.List;

import com.jhw.pojo.TablePoJo;

/**
 * @ClassName TableBo
 * @Description TODO(拼桌业务bean)
 * @author Administrator
 * @Date 2017年11月4日 下午12:23:46
 * @version 1.0.0
 */
public class TableBo {
    /** */
    
    /** 令牌*/
    private String tokenStr;
    /** 拼桌pojo*/
    private TablePoJo tablePoJo;
    /** 拼桌集合*/
    private List<TablePoJo> tablePoJos;
    
    public String getTokenStr() {
        return tokenStr;
    }

    public void setTokenStr(String tokenStr) {
        this.tokenStr = tokenStr;
    }

    public TablePoJo getTablePoJo() {
        return tablePoJo;
    }

    public void setTablePoJo(TablePoJo tablePoJo) {
        this.tablePoJo = tablePoJo;
    }

    public List<TablePoJo> getTablePoJos() {
        return tablePoJos;
    }

    public void setTablePoJos(List<TablePoJo> tablePoJos) {
        this.tablePoJos = tablePoJos;
    }
    
}
