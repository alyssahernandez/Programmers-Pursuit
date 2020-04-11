package com.sideprojects.trivialpursuit.model;

public class Category {
	
	private Integer categoryId;
	private String categoryName;
	
	public Integer getCategoryId() { return categoryId; }
	public void setCategoryId(Integer categoryID) { this.categoryId = categoryID;}
	
	public String getCategoryName() { return categoryName;}
	public void setCategoryName(String categoryName)  { this.categoryName = categoryName;}
	
	@Override
	public boolean equals(Object obj) {
		if ((obj == null) || (!(obj instanceof Category)))
			return false;
		if (super.equals(obj))
			return true;
		Category c = (Category) obj;
		return this.getCategoryId() == c.getCategoryId();
	}
	@Override
	public int hashCode() {
		return this.getCategoryId().hashCode();
	}
}
