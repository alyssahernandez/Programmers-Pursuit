package com.sideprojects.trivialpursuit.model;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Player implements Comparable<Player> { //TODO: This is probably unnecessary for Alpha. The idea is to take advantage of Collections.sort to order players based on their initial dice roll (rolled to determine order)
	private Integer playerId;
	private String name;
	private long color;
	private Space location;
	private int diceRoll;
	//TODO: Declare Pie Piece field(s) -- not sure if separate properties, a List of booleans, etc etc.
	
	public Integer getId() { return playerId; }
	public void setId(Integer playerId) { this.playerId = playerId; }
		
	public String getName() {return name; }
	public void setName(String name) { this.name = name; }
	
	public long getColor() { return color; }
	public void setColor(long color) { this.color = color; }
	
	public Space getLocation() { return location;}
	public void setLocation(Space location) {this.location = location; }
	
	public int getNewDiceRoll() { return generateDiceRoll(); }
	public int getLastDiceRoll() { return diceRoll; } 
	public void setDiceRoll(int diceRoll) { this.diceRoll = diceRoll; } 
	
	//TODO: A variation of this is also in the Gameboard class (and could also go in Game class). Let me know what's easiest for Controller team.
	// I'm not sure how to go about this in the Player class without passing in a gameboard object (which contains the List of spaces (with user-determined categories/questions) that we're accessing & generates their IDs, which is what Jeff's method that returns a List<Integer> (and this method by extension) relies on.
	// In the controller, you would pass in game.getGameboard() into this method.
	// I'll get to it later, but I also want to make Gameboard an Iterable, so that we can just call:  for (Space s : gameboard) wherever needed / if needed.
	
	public List<Space> getReachableSpaces(Gameboard gameboard) // could also pass in a Game object and call game.getGameboard() within. 
	{
		List<Space> availableSpaces = new ArrayList<>();
		List<Integer> spaceIds = getLocation().getReachableSpaces(getLastDiceRoll()); 
		
		for (Integer id : spaceIds)
		{
			availableSpaces.add(gameboard.getSpaces().get(id));
		}
		
		return availableSpaces;
	}
	
	public List<Integer> getReachableSpacesV1() { return location.getReachableSpaces(diceRoll); }
	public List<Integer> getReachableSpacesFromRollV1(int diceRoll) { return location.getReachableSpaces(diceRoll); }
	
	public List<Integer> getReachableSpacesV2() { return location.getReachableSpaces().get(diceRoll); }
	public List<Integer> getReachableSpacesFromRollV2(int diceRoll) { return location.getReachableSpaces().get(diceRoll); }
	
	public int generateDiceRoll()
	{
		int minDiceRoll = 1;
		int maxDiceRoll = 6;
		Random r = new Random();
		diceRoll = r.nextInt((maxDiceRoll - minDiceRoll) + 1) + minDiceRoll;
		return diceRoll;
	}

	//TODO: Per the comment @ top near the interface implementation, this is not needed for now (nor the method in Game.java)
	// Comparing players based on dice roll to determine an initial order (accounting for ties occurs in Game.determinePlayerOrder()). Granted, this isn't the best use of Comparable by any stretch, but I'm lazy and don't want to write a sorting algorithm. 
	@Override
	public int compareTo(Player p) {
		if (this.getLastDiceRoll() > p.getLastDiceRoll())
			return -1;
		else if (this.getLastDiceRoll() < p.getLastDiceRoll())
			return 1;
		else 
			return 0;
	}
}
