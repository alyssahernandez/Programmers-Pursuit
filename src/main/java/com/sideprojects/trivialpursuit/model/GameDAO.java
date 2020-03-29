package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface GameDAO {
	
	//TODO

	public Game getActiveGame(String gameCode);
	
	public void createNewGame(String code); //AC changed return to void added Code arg
	
	public List<Player> getAllPlayersInAGame(Game game);
	
	public Player getActivePlayer(Game game);
	
	//AC: we shouldnt let them change game code on the fly, ommiting. 
	//public void setGameCode(Game game);
	
}
