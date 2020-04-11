package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
	private Integer gameId;
	private Integer winnerId;
	private Integer activePlayerId;
	private Integer activePlayerRoll;
	private String gameCode; 
	private Boolean active;
	private List<Player> activePlayers;
	private Player activePlayer;
	private Gameboard gameboard;
	private List<Category> categories;
	
	// TODO: Single Question or List<Question>?? LMK @ Controller - Brooks
	private Question question;
	private List<Question> questions;

	public Game () { 
		
	}
	
//	public Game(List<Category> categories) {
//		this.gameboard = new Gameboard(categories);
//	}
	
	// Getters & Setters
	public Integer getGameID() {return gameId;}
	public void setGameID(Integer gameID) {this.gameId = gameID;}
	
	public Gameboard getGameboard() { return gameboard; }
	public void setGameboard(Gameboard gameboard) { this.gameboard = gameboard; } 
	
	public String getNewGameCode() { return gameCode = generateGameCode(); }
	public String getGameCode() { return gameCode; }
	public void setGameCode(String gameCode) { this.gameCode = gameCode.toUpperCase(); } // genGameCode() probably shouldn't be in the setter.
	
	public int getWinnerId() { return winnerId; }
	public void setWinnerId(int winnerID) { this.winnerId = winnerID; }
	
	public Boolean isActive() {return active;}
	public void setActive(Boolean active) {this.active = active;}
	
	public List<Player> getActivePlayers() { return activePlayers; }
	public void setActivePlayers(List<Player> activePlayers) {this.activePlayers = activePlayers; }
	
	public Player getActivePlayer() { return activePlayer; }
	public void setActivePlayer(Player activePlayer) { this.activePlayer = activePlayer; }
	
	public Integer getActivePlayerId() { return activePlayerId; }
	public void setActivePlayerId(Integer activePlayerid) { this.activePlayerId = activePlayerid; }
	
	public Question getQuestion() { return question;}
	public void setQuestion(Question question) { this.question = question; }
	
	public List<Question> getQuestions() { return questions; }
	public void setQuestions(List<Question> questions) { this.questions = questions; }
	
	public Integer getActivePlayerRoll() { return activePlayerRoll; }
	public void setActivePlayerRoll(Integer activePlayerRoll) { this.activePlayerRoll = activePlayerRoll; }
	
	public List<Category> getCategories() { return categories; }
	public void setCategories(List<Category> categories) { this.categories = categories; }
	
	//
	public void createGameboard(List<Category> categoriesInGame) {
		this.gameboard = new Gameboard(categoriesInGame);
	}
	
	// Generates a unique 6-digit hexadecimal code (e.g. B04R9A)
	private String generateGameCode()
	{
		String zeros = "000000";
	    Random r = new Random();
	    String s = String.format("%06x", r.nextInt(0x1000000));
	    gameCode = (zeros.substring(s.length()) + s).toUpperCase();
	    return gameCode;
	}
	
	// TODO: Rework this for beta -- it's not useful at present (can't have setDiceRoll() in here + parts will need to be in Controller)
	// TODO: Add sorting algo for initial roll (this only handles tie for highest roll), or re-implement Comparable/compareTo in Player on dice roll (not ideal)
	// TODO: Store all player dice rolls in DB, or keep them in session. Either way, we'll need a reference to all of them to sort them.
	// - Brooks
	public List<Player> determinePlayerOrder(List<Player> players)
	{
		for (Player p : players) { p.setDiceRoll(Dice.getDiceRoll()); }
		// Collections.sort(players);

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
					p.setDiceRoll(Dice.getDiceRoll());
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
