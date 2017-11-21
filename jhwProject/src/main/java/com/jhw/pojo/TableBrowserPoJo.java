package com.jhw.pojo;

public class TableBrowserPoJo {
    private Integer ttbid;

    private Integer tableid;

    private Integer count;

    private Integer status;

    private String datetime;

    private String ip;

    public Integer getTtbid() {
        return ttbid;
    }

    public void setTtbid(Integer ttbid) {
        this.ttbid = ttbid;
    }

    public Integer getTableid() {
        return tableid;
    }

    public void setTableid(Integer tableid) {
        this.tableid = tableid;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getDatetime() {
        return datetime;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime == null ? null : datetime.trim();
    }

    public String getIp() {
        return ip;
    }

    public void setIp(String ip) {
        this.ip = ip == null ? null : ip.trim();
    }
}