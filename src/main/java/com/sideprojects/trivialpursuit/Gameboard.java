package com.sideprojects.trivialpursuit;

import java.util.ArrayList;
import java.util.List;

public class Gameboard {

	private static List<Space> spaces;
	
	public static List<Space> getSpaces() {
		return spaces;
	}

	public void setSpaces(List<Space> spaces) {
		Gameboard.spaces = spaces;
	}
	
	public Gameboard() {
		Gameboard.spaces = generateSpaces();
	}
	
	private List<Space> generateSpaces() {
		
		List<Space> output = new ArrayList<Space>();
		
		for (int i = 0; i <= 72; i++) {
			output.add(new Space(i));
		}
		
		return output;
		
	}

}
