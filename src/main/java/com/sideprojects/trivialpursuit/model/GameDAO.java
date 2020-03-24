package com.sideprojects.trivialpursuit.model;

public interface GameDAO {
	
	//TODO

	public void getGameByCode();
	public void setGameCode(Game game);
	
	public Long setNewGame();
	public Game getActiveGame(String gameCode); // maybe change return type to Game?
}
