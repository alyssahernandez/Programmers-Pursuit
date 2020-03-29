package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	//AC: these are self explanitory, leaving for now
	//TODO

	public void getPlayerById(Long id);
	
	public void createNewPlayer(String name);
	
	public void getPlayerByName(String name);
	
	public void setPlayerByName();
	
	public Integer getPlayerPosition(Player player); // maybe pass in a Space or integer (for spaceId)
	
	public void setPlayerPosition(Player player, Game game); 
	
	public Player getPlayerByGameId(Game game);
	
	public void setPlayerByGameId(Game game);

	List<Player> getAllPlayersInAGame(int gameID);

	void putPlayerIntoGame(int playerId, int gameId);

	void putPlayerListIntoGame(List<Player> players, int gameId);
}
