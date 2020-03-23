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
			Space space = new Space();
			space.setId(i);
			output.add(space);
		}
		
		return output;
	}

}
