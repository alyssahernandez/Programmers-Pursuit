package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class Game {
	private Integer gameId;
	private Integer winnerId;
	private Integer activePlayerId;
	private Integer activePlayerRoll;
	private String gameCode;
	private Boolean active;
	private Boolean isActivePlayerAnsweringQuestion;
	private Boolean hasActivePlayerSelectedCategory;
	private Boolean isPublic;
	private Question question;
	private Player activePlayer;
	private Gameboard gameboard;
	private List<Player> activePlayers;
	private List<Category> categories;

	// Getters & Setters
	public Integer getGameID() {
		return gameId;
	}

	public void setGameID(Integer gameID) {
		this.gameId = gameID;
	}

	public Integer getWinnerId() {
		return winnerId;
	}

	public void setWinnerId(Integer winnerID) {
		this.winnerId = winnerID;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(Boolean active) {
		this.active = active;
	}

	public boolean getIsActivePlayerAnsweringQuestion() {
		return isActivePlayerAnsweringQuestion;
	}

	public void setIsActivePlayerAnsweringQuestion(Boolean isActivePlayerAnsweringQuestion) {
		this.isActivePlayerAnsweringQuestion = isActivePlayerAnsweringQuestion;
	}

	public boolean getHasActivePlayerSelectedCategory() {
		return hasActivePlayerSelectedCategory;
	}

	public void setHasActivePlayerSelectedCategory(Boolean hasActivePlayerSelectedCategory) {
		this.hasActivePlayerSelectedCategory = hasActivePlayerSelectedCategory;
	}

	public List<Player> getActivePlayers() {
		return activePlayers;
	}

	public void setActivePlayers(List<Player> activePlayers) {
		this.activePlayers = activePlayers;
	}

	public Player getActivePlayer() {
		return activePlayer;
	}

	public void setActivePlayer(Player activePlayer) {
		this.activePlayer = activePlayer;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public Integer getActivePlayerRoll() {
		return activePlayerRoll;
	}

	public void setActivePlayerRoll(Integer activePlayerRoll) {
		this.activePlayerRoll = activePlayerRoll;
	}

	public List<Category> getCategories() {
		return categories;
	}

	public List<Category> getUniqueCategories() {
		return new ArrayList<Category>(new HashSet<Category>(categories));
	}

	public void setCategories(List<Category> categories) {
		this.categories = categories;
	}

	public Gameboard getGameboard() {
		return gameboard;
	}

	public void setGameboard(Gameboard gameboard) {
		this.gameboard = gameboard;
	}

	// TODO: Rather than pass in List<category>, just pass in "categories" to
	// Gameboard constructor
	public void createGameboard(List<Category> categoriesInGame) {
		this.gameboard = new Gameboard(categoriesInGame);
	}

	public String getGameCode() {
		return gameCode;
	}

	public String getNewGameCode() {
		return gameCode = generateGameCode();
	}

	public void setGameCode(String gameCode) {
		this.gameCode = gameCode.toUpperCase();
	} // genGameCode() probably shouldn't be in the setter.

	// Generates a unique 6-digit hexadecimal code (e.g. B04R9A)
	public static String generateGameCode() {
		String zeros = "000000";
		Random r = new Random();
		String s = String.format("%06x", r.nextInt(0x1000000));
		String game_code = (zeros.substring(s.length()) + s).toUpperCase();
		return game_code;
	}

	// TODO: Rework this for beta -- it's not useful at present (can't have
	// setDiceRoll() in here + parts will need to be in Controller)
	// TODO: Add sorting algo for initial roll (this only handles tie for highest
	// roll), or re-implement Comparable/compareTo in Player on dice roll (not
	// ideal)
	// TODO: Store all player dice rolls in DB, or keep them in session. Either way,
	// we'll need a reference to all of them to sort them.
	// - Brooks
	
	public List<Player> determinePlayerOrder(List<Player> players) {
		for (Player p : players) {
			p.setDiceRoll(Dice.getDiceRoll());
		}
		// Collections.sort(players);

		int highRoll = 0;
		for (Player p : players)
			if (p.getDiceRoll() > highRoll)
				highRoll = p.getDiceRoll();

		List<Player> playersToRollAgain = new ArrayList<>();
		for (Player p : players)
			if (p.getDiceRoll() == highRoll)
				playersToRollAgain.add(p);

		while (true) {
			if (playersToRollAgain.size() > 1) {
				highRoll = 0;
				for (Player p : playersToRollAgain) {
					p.setDiceRoll(Dice.getDiceRoll());
					if (p.getDiceRoll() > highRoll)
						highRoll = p.getDiceRoll();
				}
				List<Player> toRemove = new ArrayList<>();
				for (Player p : playersToRollAgain) {
					if (p.getDiceRoll() == highRoll)
						continue;
					else
						toRemove.add(p);
				}
				if (!(toRemove.equals(null)))
					playersToRollAgain.removeAll(toRemove);

				if (playersToRollAgain.size() > 1)
					continue;
				else {
					if (players.get(0).equals(playersToRollAgain.get(0)))
						break;
					else {
						players.remove(playersToRollAgain.get(0));
						players.add(0, playersToRollAgain.get(0));
					}
				}
			} else
				break;
		}
		return players;
	}

	public Boolean getIsPublic() {
		return isPublic;
	}

	public void setIsPublic(Boolean isPublic) {
		this.isPublic = isPublic;
	}
}
