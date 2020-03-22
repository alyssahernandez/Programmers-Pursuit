package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
	private Long id;
	private String gameCode; //1. Remove "static" in case I forget. 2. AC: Database set to only have 4char code
	private boolean active;
	private Integer winnerId;
	private List<Player> activePlayers;
	private Gameboard gameboard;
	
	public Game () { this.gameboard = new Gameboard(); }
	
	public Long getGameID() {return id;}
	public void setGameID(Long gameID) {this.id = gameID;}
	
	// Not sure if getters/setters for gameboard are necessary quite yet; adding in case.  Setter certainly isn't if we're generating board in constructor.
	// public void setGameboard(Gameboard gameboard) { this.gameboard = gameboard; }
	public Gameboard getGameboard() { return gameboard; }
	
	public String getGameCode() { return gameCode;}
	public void setGameCode(String gameCode) { this.gameCode = generateGameCode(); }
	
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
	
	// SEE: Slack messages (#general) for a general overview of how order is determined.
	// 90% of this would be redundant if it were possible to do anything more than basic conditional logic in the compareTo method, but it fought me at every turn. 
	public List<Player> determinePlayerOrder(List<Player> players)
	{
		// Players are ordered based on their dice roll (highest first)
		// TODO: Change this back to a for-each if not already -- for-loop used for console tests.
		for (Player p : players) { p.setDiceRoll(); }
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
					p.setDiceRoll();
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
