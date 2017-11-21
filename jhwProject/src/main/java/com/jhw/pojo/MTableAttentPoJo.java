package com.jhw.pojo;

public class MTableAttentPoJo {
    private Integer tmtaid;

    private Integer tableId;

    private Integer userId;

    private String createDate;

    private String userName;

    private Integer status;
    /** 参与人的参与状态，0：已参加，-1：爽约，1：有事未参加*/
    private Integer attentStatus;
    /** 未参加原因*/
    private String reason;
    /** 对此参与人的评论，外键关联t_comment表主键(多个评论用逗号,隔开)*/
    private String commentId;
    
    public Integer getTmtaid() {
        return tmtaid;
    }

    public void setTmtaid(Integer tmtaid) {
        this.tmtaid = tmtaid;
    }

    public Integer getTableId() {
        return tableId;
    }

    public void setTableId(Integer tableId) {
        this.tableId = tableId;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
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