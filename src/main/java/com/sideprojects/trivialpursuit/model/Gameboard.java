package com.sideprojects.trivialpursuit.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Gameboard {

	private static final int SPACE_COUNT = 72;
	private List<Space> spaces;
	private List<Category> categories;
	
	public List<Space> getSpaces() { return spaces; }
	public void setSpaces(List<Space> spaces) {	this.spaces = spaces;}

	public List<Category> getCategories() { return categories; }
	public void setCategories(List<Category> categories) { this.categories = categories; }
	
	// TODO: We're going to have to pass List<Category> into Gameboard constructor
	// TODO: Or, remove generate spaces from constructor, and pass List<Category> into generateSpaces() method.
	// TODO: In JDBC, we'll have to create a gameboard object, then call game.setGameboard() rather than generate a gameboard in game constructor
	// - Brooks
	
	public Gameboard() { spaces = generateSpaces(); }
	
	// THIS GENERATES ALL 73 SPACES AND STORES THEM AS A LIST IN THE GAMEBOARD OBJECT
	private List<Space> generateSpaces() {
		
		List<Space> output = new ArrayList<Space>();
		
		for (int i = 0; i <= SPACE_COUNT; i++)
		{
			Space space = new Space(i);
			
			// TODO: Space 0 will be handled uniquely: no category assigned. Select categorized question in Controller based on form input (reference game.getCategories, pull w/ JDBC, etc). - Brooks
			if (i == 0)
				space.setIsCenter(true);

			if (i % 12 == 8 || i % 12 == 11)
				space.setRollAgain(true);
		
			if ((i - 6) % 12 == 0) 
				space.setNode(true);
		
			// TODO #1 (priority): Need to do this differently for 2/3 category games as the pattern is off (i.e. if 2-category game, we'll have adjacent nodes w/ same category).
			// TODO #2: Once we have #1 done, put each if/else block into a helper method.
			// TODO #3: Come up with an algorithm because this sucks. - Brooks
			if (i == 1 || i == 10 || i == 16 || i == 24 || i == 29 || i == 31 || i == 39 || i == 45 || i == 50 || i == 66)
				space.setCategory(categories.get(0));
			else if (i == 2 || i == 18 || i == 25 || i == 34 || i == 40 || i == 48 || i == 53 || i == 55 || i == 63 || i == 69)
				space.setCategory(categories.get(1));
			else if (i == 3 || i == 9 || i == 14 ||i == 30 || i == 37 || i == 46 || i == 52 || i == 60 || i == 65 || i == 67)
				space.setCategory(categories.get(2));
			else if (i == 4 || i == 12 || i == 17 ||i == 19 || i == 27 || i == 33 || i == 38 || i == 54 || i == 61 || i == 70)
				space.setCategory(categories.get(3));
			else if (i == 5 || i == 7 || i == 15 ||i == 21 || i == 26 || i == 42 || i == 49 || i == 58 || i == 64 || i == 72)
				space.setCategory(categories.get(4));
			else if (i == 6 || i == 13 || i == 22 ||i == 28 || i == 36 || i == 41 || i == 43 || i == 51 || i == 57 || i == 62)
				space.setCategory(categories.get(5));
			
			output.add(space);
		}
		return output;
	}
	
	public static void main(String[] args)
	{
		System.out.println(9 / 10);
	}
}