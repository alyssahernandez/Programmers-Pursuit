package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface GameDAO {

	public Game getActiveGame(String gameCode);
	
	public void createNewGame(String code, Integer user_id);
	
	public List<Player> getAllPlayersInAGame(Game game);
	
	public Player getActivePlayer(Game game);	
	
	public void setActivePlayer(Game game, boolean isCorrectAnswer);
	
	public void setActivePlayerDiceRoll(Game game, int diceRoll);
	
	public void setIsAnsweringQuestion(Game game, Boolean isAnsweringQuestion);
	
	public void setHasSelectedCategory(Game game, Boolean hasSelectedCategory);
	
	public void setIsGameActive(Game game, Boolean isActive);
	
	public void setWinner(Game game);
	
	public String getWinner(Game game);
	
	public Game getCompletedGame(String gameCode);
	
	public Game getUnstartedGame(String gameCode);
	
	// TODO: put these in InvitationDAO / methods in InvitationJDBC, etc.
	public void sendInvitation(Integer game_id, String invitee, String invitedBy);
	
	public List<Invitation> getInvitations(String username);
	
}
