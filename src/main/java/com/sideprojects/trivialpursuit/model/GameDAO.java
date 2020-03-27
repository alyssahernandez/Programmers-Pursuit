package com.sideprojects.trivialpursuit.model;

public interface GameDAO {
	
	//TODO

	public Game getGameByCode();
	//AC: we shouldnt let them change game code on the fly, ommiting. 
	//public void setGameCode(Game game);
	
	public void createNewGame(String code); //AC changed return to void added Code arg
	public Game getActiveGame(String gameCode); // maybe change return type to Game?
}
