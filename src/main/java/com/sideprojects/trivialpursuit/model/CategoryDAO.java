package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface CategoryDAO {
	
	//AC: returns a Category which you can .getName and such. needs int of Space from the users choice of where to go.
	public Category getCategoryFromSpace(int userChoiceSpaceID);
	
	public List<Category> getCategoriesByGame(Game game);
	
	public void setCategoriesByGameId(Game game, List<Integer> category_IDs);
	
}
