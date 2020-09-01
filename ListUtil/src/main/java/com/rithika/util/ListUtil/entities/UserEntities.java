package com.rithika.util.ListUtil.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "user_login_details")
public class UserEntities {

	@Id
	@Column(name="user_name")
	private String userName;
	@Column(name="password")
	private String password;
	
	
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userId) {
		this.userName = userId;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}


}
