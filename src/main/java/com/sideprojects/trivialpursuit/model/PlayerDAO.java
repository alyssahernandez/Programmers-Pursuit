package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	public Player getPlayer(int userId);
	
	public void createPlayers(List<String> names);
	
	public void createPlayer(int userId, String playerName);
	
	public void putPlayerIntoGame(Game game, Player player);
	
	public void setPlayerPosition(Game game, Player activePlayer);

	public void givePlayerPiePiece(int spaceId, Game game); 


}
