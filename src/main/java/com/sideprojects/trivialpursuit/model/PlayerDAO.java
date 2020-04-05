package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	//AC: these are self explanitory, leaving for now
	//TODO

	public void createNewPlayer(String name);
	
	public void setPlayerPosition(Game game); 
	
	void putPlayerIntoGame(int playerId, Game game);

	void putPlayerListIntoGame(List<Player> players, Game game);
}
