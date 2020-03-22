package com.sideprojects.trivialpursuit.model;

public class Game {
	private int gameID;
	private String gameCode; //AC: Database set to only have 4char code
	private boolean active;
	private int winnerID;
	private int active_player_id;
	
	public int getGameID() {
		return gameID;
	}
	public void setGameID(int gameID) {
		this.gameID = gameID;
	}
	public String getGameCode() {
		return gameCode;
	}
	public void setGameCode(String gameCode) {
		this.gameCode = gameCode;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}
	public int getWinnerID() {
		return winnerID;
	}
	public void setWinnerID(int winnerID) {
		this.winnerID = winnerID;
	}
	public int getActive_player_id() {
		return active_player_id;
	}
	public void setActive_player_id(int active_player_id) {
		this.active_player_id = active_player_id;
	}
	
	

}
