package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	//AC: these are self explanitory, leaving for now
	//TODO

	public void createNewPlayer(String name);
	
	public void setPlayerPosition(Player player, Game game); 
	
	void putPlayerIntoGame(int playerId, int gameId);

	void putPlayerListIntoGame(List<Player> players, int gameId);
}
