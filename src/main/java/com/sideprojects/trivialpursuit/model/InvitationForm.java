package com.sideprojects.trivialpursuit.model;

import javax.validation.constraints.AssertTrue;
import javax.validation.constraints.NotNull;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;

import com.sideprojects.trivialpursuit.model.jdbc.JDBCUserDAO;

//TODO: Potentially remove this file. Validation is working fine doing it manually, and I can't seem to figure it out this way -- funky errors on the DAO query. - Brooks
public class InvitationForm {

	@Autowired
	UserDAO userDAO;
	
	private String inviteeUsername = "";
	
	public boolean validUser;
	@AssertTrue(message="User not found: Please enter a valid username.")
	public boolean isValidUser() {
		if (this.inviteeUsername.equals("") || this.inviteeUsername == null) return false;
		this.validUser = userDAO.validateUsername(this.inviteeUsername);
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
