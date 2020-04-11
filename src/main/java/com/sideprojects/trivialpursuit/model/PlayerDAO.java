package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	public void createPlayers(List<String> names);
	
	public void createPlayer(String playerName);
	
	void putPlayersIntoGame(Game game, List<Player> players);
	
	public void setPlayerPosition(Game game, Player activePlayer); 

}
