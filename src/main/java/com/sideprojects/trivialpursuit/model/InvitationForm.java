package com.sideprojects.trivialpursuit.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;

import com.sideprojects.trivialpursuit.model.jdbc.JDBCUserDAO;

public class InvitationForm {

	@Autowired
	UserDAO userDAO;
	
	@NotBlank(message="Please enter a username")
	@NotNull(message="Please enter a username")
	private String inviteeUsername;
	
	private boolean validUser;
	@AssertTrue(message="User not found. Please enter a valid username")
	public boolean getValidUser() {
		if (inviteeUsername == "" || inviteeUsername == null) return false;
		
		this.validUser = false;
		return this.validUser;
	}

	public String getInviteeUsername() {
		return inviteeUsername;
	}

	public void setInviteeUsername(String inviteeUsername) {
		this.inviteeUsername = inviteeUsername;
	}

	public void setValidUser(Boolean validUser) {
		this.validUser = validUser;
	}
	

}
