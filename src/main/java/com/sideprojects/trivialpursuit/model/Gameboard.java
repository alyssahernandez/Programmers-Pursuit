package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

	private static final int SPACE_COUNT = 72;
	private static List<Space> spaces;
	
	public List<Space> getSpaces() { return spaces; }
	public void setSpaces(List<Space> spaces) {	Gameboard.spaces = spaces;}
	
	public Gameboard() { Gameboard.spaces = generateSpaces(); }
	
	// THIS GENERATES ALL 73 SPACES AND STORES THEM AS A LIST IN THE GAMEBOARD OBJECT
	private List<Space> generateSpaces() {
		
		List<Space> output = new ArrayList<Space>();
		
		for (int i = 0; i <= SPACE_COUNT; i++)
		{
			Space space = new Space(i);
			space.setId(i);
			output.add(space);
		}
		
		return output;
	}
	
	// Also have a variation of this in the Player class.  Here, we would need to pass in the ID of a player's current space (player.getLocation.getId) and a dice roll.
	public List<Space> getReachableSpaces(int diceRoll, int currentSpaceId) 
	{
		List<Space> availableSpaces = new ArrayList<>();
		List<Integer> spaceIds = getSpaces().get(currentSpaceId).getReachableSpaces(diceRoll); 
		
		for (Integer id : spaceIds)
		{
			availableSpaces.add(getSpaces().get(id));
		}
		
		return availableSpaces;
	}

}
