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
	
	public void setPlayerPosition(Player player); // return Space??
	
	public void setPlayerPiesAttained(Integer piesAttained); // I don't think we have to store "categories pie pieces attained" individually; we can store them collectively, and store them in the DB as 0-6;
	public Integer getPlayerPiesAttained(); // return integer
	
	public Player getPlayerByGameId(Game game);
	public void setPlayerByGameId(Game game);

	List<Player> getAllPlayersInAGame(int gameID);

	void putPlayersIntoGame(int playerId, int gameId);
}
