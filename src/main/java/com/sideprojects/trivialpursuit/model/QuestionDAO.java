package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface QuestionDAO {
	
	//public Question getQuestionByCategory(Category categoryFromSpace); -- needs to pull from game_question if asked=false
	
	public void setQuestionAsked(Game game, Question question);
	
	public void setGameQuestions(Game game, List<Integer> category_IDs);
	
	public Question getUnaskedQuestionByCategory(Game game, Integer category_id);
	
	public List<Question> getUnaskedQuestionsByCategory(Game game, Integer category_id);

}
