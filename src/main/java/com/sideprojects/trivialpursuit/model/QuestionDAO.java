package com.sideprojects.trivialpursuit.model;

public interface QuestionDAO {
	
	//AC: returns a question you can use .getQuestion and .getAnswer. needs a category gotten from the JDBCCategoryDAO
	//.getCategoryFromSpace
	public Question getQuestionFromCategory(Category categoryFromSpace);

}
