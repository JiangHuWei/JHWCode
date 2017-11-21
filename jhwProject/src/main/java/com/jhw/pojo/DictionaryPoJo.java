package com.jhw.pojo;

public class DictionaryPoJo {
    private Integer tdid;

    private String dname;

    private String dvalue;

    private Integer parentid;

    private Integer status;

    private Integer isfixed;

    public Integer getTdid() {
        return tdid;
    }

    public void setTdid(Integer tdid) {
        this.tdid = tdid;
    }

    public String getDname() {
        return dname;
    }

    public void setDname(String dname) {
        this.dname = dname == null ? null : dname.trim();
    }

    public String getDvalue() {
        return dvalue;
    }

    public void setDvalue(String dvalue) {
        this.dvalue = dvalue == null ? null : dvalue.trim();
    }

    public Integer getParentid() {
        return parentid;
    }

    public void setParentid(Integer parentid) {
        this.parentid = parentid;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsfixed() {
        return isfixed;
    }

    public void setIsfixed(Integer isfixed) {
        this.isfixed = isfixed;
    }
}