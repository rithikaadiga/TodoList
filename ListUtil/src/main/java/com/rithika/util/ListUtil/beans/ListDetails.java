package com.rithika.util.ListUtil.beans;

import java.sql.Timestamp;


public class ListDetails {

	private Integer taskId;
	private String taskName;
	private String taskDesc;
	private Boolean status;
	private Boolean deleteStatus;
	private Timestamp lastUpdateTs;
	private String userName;
	private String message;
	
	public ListDetails() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ListDetails(Integer taskId, String taskName, String taskDesc, Boolean status,Boolean deleteStatus, Timestamp lastUpdateTs, String userName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.status = status;
		this.lastUpdateTs = lastUpdateTs;
		this.userName = userName;
		this.deleteStatus = deleteStatus;
	}



	public Integer getTaskId() {
		return taskId;
	}
	public void setTaskId(Integer taskId) {
		this.taskId = taskId;
	}
	public String getTaskName() {
		return taskName;
	}
	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}
	public String getTaskDesc() {
		return taskDesc;
	}
	public void setTaskDesc(String taskDesc) {
		this.taskDesc = taskDesc;
	}
	public Boolean getStatus() {
		return status;
	}
	public void setStatus(Boolean status) {
		this.status = status;
	}
	public Timestamp getLastUpdateTs() {
		return lastUpdateTs;
	}
	public void setLastUpdateTs(Timestamp lastUpdateTs) {
		this.lastUpdateTs = lastUpdateTs;
	}


	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}


	public String getMessage() {
		return message;
	}


	public void setMessage(String message) {
		this.message = message;
	}


	public Boolean getDeleteStatus() {
		return deleteStatus;
	}


	public void setDeleteStatus(Boolean deleteStatus) {
		this.deleteStatus = deleteStatus;
	}
	
	
	
	
}
