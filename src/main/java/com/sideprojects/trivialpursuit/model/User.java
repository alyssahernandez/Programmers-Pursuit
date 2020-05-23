package com.sideprojects.trivialpursuit.model;

import java.util.List;

public class User {
	
	private Integer userId;
	private String username;
	private String idToken;
	private String email;
	private String picture;
	private Integer gamesWon;
	private Integer gamesPlayed;
	private List<User> friends;
	private List<User> pendingFriendRequests;
	private List<User> incomingFriendRequests;
	
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

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPicture() {
		return picture;
	}

	public void setPicture(String picture) {
		this.picture = picture;
	}

	public Integer getGamesPlayed() {
		return gamesPlayed;
	}

	public void setGamesPlayed(Integer gamesPlayed) {
		this.gamesPlayed = gamesPlayed;
	}

	public Integer getGamesWon() {
		return gamesWon;
	}

	public void setGamesWon(Integer gamesWon) {
		this.gamesWon = gamesWon;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof User)))
			return false;
		if (super.equals(obj))
			return true;
		User user = (User) obj;
		return this.getUserId() == user.getUserId();
	}
	@Override
	public int hashCode() {
		return this.getUserId().hashCode();
	}

	public List<User> getPendingFriendRequests() {
		return pendingFriendRequests;
	}

	public void setPendingFriendRequests(List<User> pendingFriendRequests) {
		this.pendingFriendRequests = pendingFriendRequests;
	}

	public List<User> getIncomingFriendRequests() {
		return incomingFriendRequests;
	}

	public void setIncomingFriendRequests(List<User> incomingFriendRequests) {
		this.incomingFriendRequests = incomingFriendRequests;
	}
}
