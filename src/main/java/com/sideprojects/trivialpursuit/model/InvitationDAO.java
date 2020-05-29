package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface InvitationDAO {

	public boolean doesInvitationExist(String gameCode, String invitee);
	
	public void deleteInvitation(String gameCode, String username);
	
	public void sendInvitation(String gameCode, String invitee, String invitedBy);
	
	public List<Invitation> getInvitations(String username);
	
	public void addFriend(String username, String friendName);
	
	public void acceptFriendRequest(String username, String friendName);
	
	public void removeFriend(String username, String friendName);
	
	public void cancelFriendRequest(String username, String friendName);
	
	public void rejectFriendRequest(String username, String friendName);
	
	
}
