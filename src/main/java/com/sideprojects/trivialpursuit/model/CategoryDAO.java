package com.sideprojects.trivialpursuit.model;

public interface CategoryDAO {
	
	//AC: returns a Category which you can .getName and such. needs int of Space from the users choice of where to go.
	public Category getCategoryFromSpace(int userChoiceSpaceID);
	
}
