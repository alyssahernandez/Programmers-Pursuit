package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface QuestionDAO {
	
	//AC: returns a question you can use .getQuestion and .getAnswer. needs a category gotten from the JDBCCategoryDAO
	//.getCategoryFromSpace
	public Question getQuestionByCategory(Category categoryFromSpace);
	public List<Question> getQuestionsByCategory (Category category);

}
