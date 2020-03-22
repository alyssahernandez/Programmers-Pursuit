package com.sideprojects.trivialpursuit.model;

//AC: all categorys will have these getters to get the ID and the name wherever we want to use them
public class Category {
	private int categoryID;
	private String categoryName;
	
	public int getCategoryID() {
		return categoryID;
	}
	public void setCategoryID(int categoryID) {
		this.categoryID = categoryID;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

}
