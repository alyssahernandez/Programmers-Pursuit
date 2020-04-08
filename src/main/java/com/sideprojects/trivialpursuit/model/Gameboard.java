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
		for (int i = 0; i <= SPACE_COUNT; i++)
		{
			Space space = new Space(i);
			
			if (i == 0)
				space.setIsCenter(true);

			if (i % 12 == 8 || i % 12 == 11)
				space.setRollAgain(true);
		
			if ((i - 6) % 12 == 0) 
				space.setNode(true);
			
			
			/*
			 * TODO BACK-END: the spaces are attached to the gameboard here. please 
			 * find a way to attach the categories to spaces in this method.
			 */
			
			
			
			output.add(space);
		}
		
		return output;
	}
	
}
