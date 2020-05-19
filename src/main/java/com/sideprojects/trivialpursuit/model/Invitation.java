package com.sideprojects.trivialpursuit.model;

public class Invitation {
	
	private Integer invitationId;
	private String invitee;
	private String invitedBy;
	private Integer gameId;
	
	public Integer getInvitationId() {
		return invitationId;
	}
	public void setInvitationId(Integer invitationId) {
		this.invitationId = invitationId;
	}
	public String getInvitee() {
		return invitee;
	}
	public void setInvitee(String invitee) {
		this.invitee = invitee;
	}
	public String getInvitedBy() {
		return invitedBy;
	}
	public void setInvitedBy(String invitedBy) {
		this.invitedBy = invitedBy;
	}
	public Integer getGameId() {
		return gameId;
	}
	public void setGameId(Integer gameId) {
		this.gameId = gameId;
	}
	
	

}
