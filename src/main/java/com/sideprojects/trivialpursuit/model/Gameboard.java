package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class Gameboard {

	private static final int SPACE_COUNT = 72;
	private List<Space> spaces;
	
	public List<Space> getSpaces() { return spaces; }
	public void setSpaces(List<Space> spaces) {	this.spaces = spaces;}
	
	public Gameboard() { spaces = generateSpaces(); }
	
	// THIS GENERATES ALL 73 SPACES AND STORES THEM AS A LIST IN THE GAMEBOARD OBJECT
	private List<Space> generateSpaces() {
		
		List<Space> output = new ArrayList<Space>();
		
		//TODO: generate categories
		//TODO: update booleans (isRollAgain, isNode, etc.); don't need to generate categories for this.
		for (int i = 0; i <= SPACE_COUNT; i++)
		{
			Space space = new Space(i);
			output.add(space);
		}
		
		return output;
	}
}
