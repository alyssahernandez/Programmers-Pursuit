package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface PlayerDAO {
	
	public Player getPlayer(int userId);
	
	public void setPlayerPosition(Game game, Player activePlayer);

	public void givePlayerPiePiece(int spaceId, Game game); 
	
	public void putPlayerIntoGame(Integer game_id, Integer user_id, Integer color_id);
	
	public void putFirstPlayerIntoGame(Game game, Integer user_id);

}
