package com.jhw.pojo;

import java.io.UnsupportedEncodingException;

public class CityCode {
    private Integer tccid;

    private String cityname;

    private String adcode;

    private String citycode;

    private Integer status;

    public Integer getTccid() {
        return tccid;
    }

    public void setTccid(Integer tccid) {
        this.tccid = tccid;
    }

    public String getCityname() {
        return cityname;
    }

    public void setCityname(String cityname) {
        this.cityname = cityname == null ? null : cityname.trim();
    }

    public String getAdcode() {
        return adcode;
    }

    public void setAdcode(String adcode) {
        this.adcode = adcode == null ? null : adcode.trim();
    }

    public String getCitycode() {
        return citycode;
    }

    public void setCitycode(String citycode) {
        this.citycode = citycode == null ? null : citycode.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}