package com.sideprojects.trivialpursuit.model;
import java.util.List;
import java.util.Random;

public class Player implements Comparable<Player> { // Compares Players (for sort order) based on desired criteria. See "compareTo" below.
	private int playerId;
	private String name;
	private Space location;
	private int diceRoll;
	
	public int getId() { return playerId; }
	public void setId(int playerId) { this.playerId = playerId; }
	
	public Space getLocation() { return location;}
	public void setLocation(Space location) {this.location = location; }
	
	public String getName() {return name; }
	public void setName(String name) { this.name = name; }
	
	// Either way works, just a matter of if you want to pass a roll in or use their current roll (stored in private field) -- Brooks
	public List<Integer> getReachableSpaces() { return location.getReachableSpaces(diceRoll); }
	public List<Integer> getReachableSpacesFromRoll(int diceRoll) { return location.getReachableSpaces(diceRoll); }
	
	// These utilizes Jeff's original "getReachableSpaceS()" method, which returns a map, just in case we want them.  - Brooks
	public List<Integer> getReachableSpacesV2() { return location.getReachableSpaces().get(diceRoll); }
	public List<Integer> getReachableSpacesFromRollV2(int diceRoll) { return location.getReachableSpaces().get(diceRoll); }
	
	// Same with the reachable spaces, it depends on how you want to approach it @ Controller Team -- Brooks
	public int getDiceRoll() { return generateDiceRoll(); }
	public int getDiceRoll2() { return diceRoll; }
	public void setDiceRoll(int diceRoll) { this.diceRoll = diceRoll; } 
	
	public int generateDiceRoll()
	{
		int minDiceRoll = 1;
		int maxDiceRoll = 6;
		Random r = new Random();
		return r.nextInt((maxDiceRoll - minDiceRoll) + 1) + minDiceRoll;
	}

	// Comparing players based on dice roll to determine an initial order (accounting for ties occurs in Game.determinePlayerOrder()). Granted, this isn't the best use of Comparable by any stretch, but I'm lazy and don't want to write a sorting algorithm. 
	@Override
	public int compareTo(Player p) {
		if (this.getDiceRoll() > p.getDiceRoll())
			return -1;
		else if (this.getDiceRoll() < p.getDiceRoll())
			return 1;
		else 
			return 0;
	}
}
