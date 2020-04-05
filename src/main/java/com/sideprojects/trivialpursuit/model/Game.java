package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class Game {
	private Integer gameId;
	private String gameCode; 
	private Boolean active;
	private Integer winnerId;
	private Integer activePlayerId;
	private List<Player> activePlayers;
	private Player activePlayer;
	private Gameboard gameboard;
	
	// TODO: Should we store this as a list of questions, or just pull a single question given we're doing a full DB pull on every interaction?
	// I previously had List<Question> in the Category class, but I think it makes more sense here. 
	// All ways are doable, just lmk -- Brooks
	private Question question;
	private List<Question> questions;

	public Game () { this.gameboard = new Gameboard(); }
	
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
	
	//TODO: Remove one of these pairs of gets/sets depending on whether we go with List<Question> or Question (see above) -- Brooks
	public Question getQuestion() { return question;}
	public void setQuestion(Question question) { this.question = question; }
	
	public List<Question> getQuestions() { return questions; }
	public void setQuestions(List<Question> questions) { this.questions = questions; }
	
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
	
	// TODO: Fix for BETA!
	// TODO: This needs major refactoring (pull out diceRolls given they'll be passed in based on user input), tho it doesn't seem we're currently utilizing a player order beyond lobby order of entry.
	public List<Player> determinePlayerOrder(List<Player> players)
	{
		// Players are ordered based on their dice roll (highest first)
		for (Player p : players) { p.getNewDiceRoll(); }
		Collections.sort(players);

		int highRoll = 0;			
		for (Player p : players)
			if (p.getLastDiceRoll() > highRoll)
				highRoll = p.getLastDiceRoll();
		
		List<Player> playersToRollAgain = new ArrayList<>();
		for (Player p : players)
			if (p.getLastDiceRoll() == highRoll)
				playersToRollAgain.add(p);
		
		while (true)
		{
			if (playersToRollAgain.size() > 1)
			{
				highRoll = 0;
				for (Player p : playersToRollAgain){
					p.getNewDiceRoll();
					if (p.getLastDiceRoll() > highRoll)
						highRoll = p.getLastDiceRoll();
				}
				List<Player> toRemove = new ArrayList<>();
				for (Player p : playersToRollAgain) 
				{
					if (p.getNewDiceRoll() == highRoll)
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
	
	// TODO: Will be used if we go with List<Question> (see above) - Brooks
	/*
	 	public Question getNewQuestion()
		{ 	
			if (questions.equals(null)) { return null; }
			return questions.get(getQuestionIndex());
		}
		
		private int getQuestionIndex() 
		{
			int minQuestionIndex = 0;
			int maxQuestionIndex = questions.size() - 1;
			Random r = new Random();
			int index = r.nextInt((maxQuestionIndex - minQuestionIndex) + 1) + minQuestionIndex;
			return index;
		}
	 */

}
