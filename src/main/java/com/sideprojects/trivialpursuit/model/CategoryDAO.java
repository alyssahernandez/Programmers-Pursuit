package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface CategoryDAO {
	
	//AC: returns a Category which you can .getName and such. needs int of Space from the users choice of where to go.
	public Category getCategoryFromSpace(int userChoiceSpaceID);
	
	public void setCategoryByGameId(Game game);
	
	public List<Category> getCategoriesByGameId(Game game);
	
	//TODO: Select categories based on user-chosen categories (2, 3, or 6 categories -- to divide up the gameboard evenly)
	// AC: this work has been done in table category_space. all categorys have 12 spaces each. so all user needs is the 
	//first method above
	
}
