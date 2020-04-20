package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface QuestionDAO 
{
	public void setGameQuestions(Game game, List<Integer> category_IDs);
	
	public Question getUnaskedQuestionByCategory(Game game, Integer category_id);
	
	public Question getCurrentQuestion(Game game);
	
	public void setQuestionAsked(Game game, Question question);
}
