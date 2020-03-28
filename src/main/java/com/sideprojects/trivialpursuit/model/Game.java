package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
	private int id;
	private String gameCode; 
	private boolean active;
	private Integer winnerId;
	private List<Player> activePlayers;
	private Gameboard gameboard;
	private int nextPlayerUpIndex;
	
	public Player getNextPlayerUp()
	{
		// Throw Exception?
		if (activePlayers == null)
			return null;
		
		Player p = null;
		
		if (nextPlayerUpIndex < activePlayers.size())
		{
			p = activePlayers.get(nextPlayerUpIndex);
			nextPlayerUpIndex++;
		}
		else
		{
			nextPlayerUpIndex = 0;
			p = activePlayers.get(nextPlayerUpIndex);
		}
		
		return p;
	}
	
	public Game () { this.gameboard = new Gameboard(); }
	
	public int getGameID() {return id;}
	public void setGameID(int gameID) {this.id = gameID;}
	
	// Not sure if getters/setters for gameboard are necessary quite yet; adding in case.  Setter certainly isn't if we're generating board in constructor.
	// public void setGameboard(Gameboard gameboard) { this.gameboard = gameboard; }
	public Gameboard getGameboard() { return gameboard; }
	public void setGameboard(Gameboard gameboard) { this.gameboard = gameboard; } 
	
	public String getNewGameCode() { return generateGameCode(); }
	public String getGameCode() { return gameCode; }
	public void setGameCode(String gameCode) { this.gameCode = gameCode.toUpperCase(); } // genGameCode() probably shouldn't be in the setter.
	
	public int getWinnerId() { return winnerId; }
	public void setWinnerId(int winnerID) { this.winnerId = winnerID; }
	
	public boolean isActive() {return active;}
	public void setActive(boolean active) {this.active = active;}
	
	public List<Player> getActivePlayers() { return activePlayers; }
	public void setActivePlayers(List<Player> activePlayers) {this.activePlayers = determinePlayerOrder(activePlayers); }
	
	public void getNewPlayer(Player player) { activePlayers.add(player); } // could also call getActivePlayers().add(player);
	public void removeActivePlayer(Player player) { activePlayers.remove(player); } // could also just call getActivePlayers().remove(player);
	
	// Generates a unique 6-digit hexadecimal code (e.g. B04R9A)
	//TODO: Check if game code already exists via query. Upon our INSERT query for a newly created game, (returning game_id), generate this code. Query a SELECT to compare pre-existing game codes; if none exist, UPDATE/SET the game code based on game_id (it will be null initially).  Probably a better way to go about this.
	private String generateGameCode()
	{
		String zeros = "000000";
	    Random r = new Random();
	    String s = String.format("%06x", r.nextInt(0x1000000));
	    gameCode = (zeros.substring(s.length()) + s).toUpperCase();
	    return gameCode;
	}
	
	// TODO: This needs major refactoring (pull out diceRolls given they'll be passed in based on user input), tho it doesn't seem we're currently utilizing a player order beyond lobby order of entry.
	// TODO: Let me know what your thoughts are on the necessity of this, and I'll adjust accordingly. -- Brooks
	public List<Player> determinePlayerOrder(List<Player> players)
	{
		// Players are ordered based on their dice roll (highest first)
		for (Player p : players) { p.getDiceRoll(); }
		Collections.sort(players);

		int highRoll = 0;			
		for (Player p : players)
			if (p.getDiceRoll() > highRoll)
				highRoll = p.getDiceRoll();
		
		List<Player> playersToRollAgain = new ArrayList<>();
		for (Player p : players)
			if (p.getDiceRoll() == highRoll)
				playersToRollAgain.add(p);
		
		while (true)
		{
			if (playersToRollAgain.size() > 1)
			{
				highRoll = 0;
				for (Player p : playersToRollAgain){
					p.getDiceRoll();
					if (p.getDiceRoll() > highRoll)
						highRoll = p.getDiceRoll();
				}
				List<Player> toRemove = new ArrayList<>();
				for (Player p : playersToRollAgain) 
				{
					if (p.getDiceRoll() == highRoll)
						continue;
					else
						toRemove.add(p);
				}
				if (!(toRemove.equals(null)))
					playersToRollAgain.removeAll(toRemove);
				
				if (playersToRollAgain.size() > 1)
					continue;
				else 
				{
					if (players.get(0).equals(playersToRollAgain.get(0)))
						break;
					else {
						players.remove(playersToRollAgain.get(0));
						players.add(0, playersToRollAgain.get(0));
					}
				}
			}
			else
				break;
		}
		return players;
	}
}
