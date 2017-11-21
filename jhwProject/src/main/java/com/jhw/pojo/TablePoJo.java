package com.jhw.pojo;

import java.util.List;

public class TablePoJo extends BasePoJo{
    private Integer ttid;

    private Integer initiatorid;

    private String tableExplain;

    private String expect;

    private Integer restaurantid;

    private Integer peopleNumber;

    private Integer sexRequire;

    private String begainDate;

    private Integer checkNumber;

    private Integer attentNumber;

    private Integer collectNumber;

    private Integer commentid;

    private String createDate;

    private Integer createUserid;

    private String createName;
    
    private Integer status;
    
    private String title;
    /** 拼桌是否启动, 0：已启动，-1：各种原因解散，1：未开始，2：已完成*/
    private String startstatus;
    
    /** 一对一餐厅信息*/
    private RestaurantPoJo restaurantPoJo;
    /** 一对多参加拼桌用户信息*/
    private List<MTableAttentPoJo> userAttentPoJo;
    
    public Integer getTtid() {
        return ttid;
    }

    public void setTtid(Integer ttid) {
        this.ttid = ttid;
    }

    public Integer getInitiatorid() {
        return initiatorid;
    }

    public void setInitiatorid(Integer initiatorid) {
        this.initiatorid = initiatorid;
    }

    public String getTableExplain() {
        return tableExplain;
    }

    public void setTableExplain(String tableExplain) {
        this.tableExplain = tableExplain;
    }

    public String getExpect() {
        return expect;
    }

    public void setExpect(String expect) {
        this.expect = expect == null ? null : expect.trim();
    }

    public Integer getRestaurantid() {
        return restaurantid;
    }

    public void setRestaurantid(Integer restaurantid) {
        this.restaurantid = restaurantid;
    }

    public Integer getPeopleNumber() {
        return peopleNumber;
    }

    public void setPeopleNumber(Integer peopleNumber) {
        this.peopleNumber = peopleNumber;
    }

    public Integer getSexRequire() {
        return sexRequire;
    }

    public void setSexRequire(Integer sexRequire) {
        this.sexRequire = sexRequire;
    }

    public String getBegainDate() {
        return begainDate;
    }

    public void setBegainDate(String begainDate) {
        this.begainDate = begainDate;
    }

    public Integer getCheckNumber() {
        return checkNumber;
    }

    public void setCheckNumber(Integer checkNumber) {
        this.checkNumber = checkNumber;
    }

    public Integer getAttentNumber() {
        return attentNumber;
    }

    public void setAttentNumber(Integer attentNumber) {
        this.attentNumber = attentNumber;
    }

    public Integer getCollectNumber() {
        return collectNumber;
    }

    public void setCollectNumber(Integer collectNumber) {
        this.collectNumber = collectNumber;
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }

    public RestaurantPoJo getRestaurantPoJo() {
        return restaurantPoJo;
    }
    
    public void setRestaurantPoJo(RestaurantPoJo restaurantPoJo) {
        this.restaurantPoJo = restaurantPoJo;
    }

    public List<MTableAttentPoJo> getUserAttentPoJo() {
        return userAttentPoJo;
    }
    
    public void setUserAttentPoJo(List<MTableAttentPoJo> userAttentPoJo) {
        this.userAttentPoJo = userAttentPoJo;
    }

	/**
	 * @return the startstatus
	 */
	public String getStartstatus() {
		return startstatus;
	}

	/**
	 * @param startstatus the startstatus to set
	 */
	public void setStartstatus(String startstatus) {
		this.startstatus = startstatus;
	}
    
}