package com.jhw.pojo;

import java.util.Date;

public class PartyPoJo {
    private Integer tpid;

    private Integer initiator;

    private Integer peopleType;

    private String address;

    private String partyDate;

    private String introduce;

    private Integer commentid;

    private Integer createUserid;

    private String createDate;

    private String createUsername;
    
    private String title;
    /** 聚会有效状态，0：有效， -1：无效*/
    private Integer status; 
    /** 聚会是否启动, 0：已启动，-1：各种原因解散，1：未开始，2：已完成*/
    private Integer startstatus;
    
    private int sexRequire;

    public Integer getTpid() {
        return tpid;
    }

    public void setTpid(Integer tpid) {
        this.tpid = tpid;
    }

    public Integer getInitiator() {
        return initiator;
    }

    public void setInitiator(Integer initiator) {
        this.initiator = initiator;
    }

    public Integer getPeopleType() {
        return peopleType;
    }

    public void setPeopleType(Integer peopleType) {
        this.peopleType = peopleType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPartyDate() {
        return partyDate;
    }

    public void setPartyDate(String partyDate) {
        this.partyDate = partyDate;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce == null ? null : introduce.trim();
    }

    public Integer getCommentid() {
        return commentid;
    }

    public void setCommentid(Integer commentid) {
        this.commentid = commentid;
    }

    public Integer getCreateUserid() {
        return createUserid;
    }

    public void setCreateUserid(Integer createUserid) {
        this.createUserid = createUserid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateUsername() {
        return createUsername;
    }

    public void setCreateUsername(String createUsername) {
        this.createUsername = createUsername == null ? null : createUsername.trim();
    }
    
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getSexRequire() {
        return sexRequire;
    }
    
    public void setSexRequire(int sexRequire) {
        this.sexRequire = sexRequire;
    }

	/**
	 * @return the status
	 */
	public Integer getStatus() {
		return status;
	}

	/**
	 * @param status the status to set
	 */
	public void setStatus(Integer status) {
		this.status = status;
	}

	/**
	 * @return the startstatus
	 */
	public Integer getStartstatus() {
		return startstatus;
	}

	/**
	 * @param startstatus the startstatus to set
	 */
	public void setStartstatus(Integer startstatus) {
		this.startstatus = startstatus;
	}
}