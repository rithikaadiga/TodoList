package com.rithika.util.ListUtil.entities;

import java.sql.Timestamp;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "task_details")
public class ListEntities {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="task_id")
	private Integer taskId;
	@Column(name="task_name")
	private String taskName;
	@Column(name="task_desc")
	private String taskDesc;
	@Column(name="status")
	private Boolean status;
	@Column(name="last_update")
	@DateTimeFormat(pattern="dd-MMM-YYYY hh:mm:ss")
	private Timestamp lastUpdateTs;
	@Column(name="user_name")
	private String userName;
	
	public ListEntities() {
		// TODO Auto-generated constructor stub
	}
	
	
	public ListEntities(Integer taskId, String taskName, String taskDesc, Boolean status, Timestamp lastUpdateTs, String userName) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.taskDesc = taskDesc;
		this.status = status;
		this.lastUpdateTs = lastUpdateTs;
		this.userName = userName;
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
	
	
	
}
