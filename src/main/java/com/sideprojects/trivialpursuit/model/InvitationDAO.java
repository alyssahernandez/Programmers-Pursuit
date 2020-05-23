package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface InvitationDAO {

	public boolean doesInvitationExist(String gameCode, String invitee);
	
	public void deleteInvitation(String gameCode, String username);
	
	public void sendInvitation(String gameCode, String invitee, String invitedBy);
	
	public List<Invitation> getInvitations(String username);
}
