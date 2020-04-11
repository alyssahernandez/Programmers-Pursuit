package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface CategoryDAO {
	
	public List<Category> getCategoriesByGame(Game game);
	
	public void setCategoriesByGameId(Game game, List<Integer> category_IDs);
	
}
