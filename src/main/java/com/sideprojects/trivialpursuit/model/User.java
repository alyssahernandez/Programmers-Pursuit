package com.sideprojects.trivialpursuit.model;

public class User {
	
	private Integer userId;
	private String username;
	private String idToken;
	
	
	
	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public String getUsername() {
		return username;
	}
	
	public void setUsername(String username) {
		this.username = username;
	}
	
	public String getIdToken() {
		return idToken;
	}
	
	public void setIdToken(String idToken) {
		this.idToken = idToken;
	}

	
}
