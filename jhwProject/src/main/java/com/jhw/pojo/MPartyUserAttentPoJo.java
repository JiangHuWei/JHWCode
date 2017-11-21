package com.jhw.pojo;

import java.util.Date;

public class MPartyUserAttentPoJo {
    private Integer tmpuaid;

    private Integer partyid;

    private Integer userid;

    private String createDate;

    private String createName;
    
    private float cost;
    /** 参与人的参与状态，0：已参加，-1：爽约，1：有事未参加*/
    private Integer attentStatus;
    /** */
    private String reason;
    /**对此参与人的评论，外键关联t_comment表主键(多个评论用逗号,隔开)*/
    private String commentId;
    
    
    public Integer getTmpuaid() {
        return tmpuaid;
    }

    public void setTmpuaid(Integer tmpuaid) {
        this.tmpuaid = tmpuaid;
    }

    public Integer getPartyid() {
        return partyid;
    }

    public void setPartyid(Integer partyid) {
        this.partyid = partyid;
    }

    public Integer getUserid() {
        return userid;
    }

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }

    public String getCreateName() {
        return createName;
    }

    public void setCreateName(String createName) {
        this.createName = createName == null ? null : createName.trim();
    }
    
    public float getCost() {
        return cost;
    }
    
    public void setCost(float cost) {
        this.cost = cost;
    }

	/**
	 * @return the attentStatus
	 */
	public Integer getAttentStatus() {
		return attentStatus;
	}

	/**
	 * @param attentStatus the attentStatus to set
	 */
	public void setAttentStatus(Integer attentStatus) {
		this.attentStatus = attentStatus;
	}

	/**
	 * @return the reason
	 */
	public String getReason() {
		return reason;
	}

	/**
	 * @param reason the reason to set
	 */
	public void setReason(String reason) {
		this.reason = reason;
	}

	/**
	 * @return the commentId
	 */
	public String getCommentId() {
		return commentId;
	}

	/**
	 * @param commentId the commentId to set
	 */
	public void setCommentId(String commentId) {
		this.commentId = commentId;
	}
    
}