package com.sideprojects.trivialpursuit.model;

public interface CategoryDAO {
	
	//AC: returns a Category which you can .getName and such. needs int of Space from the users choice of where to go.
	public Category getCategoryFromSpace(int userChoiceSpaceID);
	
	public Category getCategoryByGameId(Game game);
	public void setCategoryByGameId(Game game);
	
	//TODO: Select categories based on user-chosen categories (2, 3, or 6 categories -- to divide up the gameboard evenly)
	
}
