package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.Question;
import com.sideprojects.trivialpursuit.model.QuestionDAO;

@Component
public class JDBCQuestionDAO implements QuestionDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCQuestionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	// Returns a randomly selected question & updates the DB to "asked" so that it can't be selected again.
	public Question getUnaskedQuestionByCategory(Game game, Integer category_id)
	{
		Question question = null;
		List<Question> questions = getUnaskedQuestionsByCategory(game, category_id);
		if (questions == null || questions.size() == 0)
			return null;
		//TODO: @Controller, if null is returned, tell users the game is over because they're out of questions for a category.
		
		int questionIndex = getQuestionIndex(questions);
		question = questions.get(questionIndex);
		// setQuestionAsked(game, question);  //TODO: uncomment setQuestionAsked() once we have more questions in DB.
		return question;
	}
	
	// Uses private "getQuestionsByCategory()" method below to set questions in game_question. //TODO: This is what will be used in Controller @ Kiran. - Brooks
	@Override
	public void setGameQuestions(Game game, List<Integer> category_IDs)
	{
		List<Question> questions = getQuestionsByCategory(category_IDs);
		String query = "INSERT INTO game_question (game_id, question_id, asked) VALUES (?, ?, false)";
		
		for (Question q : questions)
			jdbcTemplate.update(query, game.getGameID(), q.getQuestionID());
	}
	
	// Gets questions by a list of category_id's to store in game_question.
	private List<Question> getQuestionsByCategory(List<Integer> category_IDs)
	{
		List<Question> questions = new ArrayList<>();
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		
		for (Integer cat_id : category_IDs)
		{
			SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, cat_id);
			
			while (results.next()) 
			{
				Question questionFromCategory = new Question();
				questionFromCategory.setQuestionID(results.getInt("question_id"));
				questionFromCategory.setCategoryID(results.getInt("category_id"));
				questionFromCategory.setQuestion(results.getString("question"));
				questionFromCategory.setAnswer(results.getString("answer"));
				questions.add(questionFromCategory);
			}
		}
		return questions;
	}
	
	// Pulls a list of unasked questions, from which we'll pull a single question in getUnaskedQuestion above.
	private List<Question> getUnaskedQuestionsByCategory(Game game, Integer category_id)
	{
		String query = "SELECT * FROM question INNER JOIN game_question ON (question.question_id = game_question.question_id) " + 
						"WHERE game_question.game_id = ? AND question.category_id = ? AND game_question.asked = false";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, game.getGameID(), category_id);
		
		List<Question> questions = new ArrayList<>();
		Question question = new Question();
		
		while (rowSet.next())
		{
			question.setAnswer(rowSet.getString("answer"));
			question.setCategoryID(rowSet.getInt("category_id"));
			question.setQuestion(rowSet.getString("question"));
			question.setQuestionID(rowSet.getInt("question_id"));
			questions.add(question);
		}
		return questions;
	}
	
	// Updates the pulled question to "asked" in the DB so that we don't pull it again.
	private void setQuestionAsked(Game game, Question question)
	{
		String query = "UPDATE game_question SET asked = true WHERE game_id = ? AND question_id = ?";
		jdbcTemplate.update(query, game.getGameID(), question.getQuestionID());
	}
	
	// Helper method to get a random index to reference from a List<Question> (to select a random question, given our List<Question> pulled from DB will have the same order every time)
	private int getQuestionIndex(List<Question> questions)
	{	
		int questionIndex = 0;
		if (questions.size() > 1) 
		{		
			int minQuestionIndex = 0;
			int maxQuestionIndex = questions.size() - 1;
			Random r = new Random();
			questionIndex = r.nextInt((maxQuestionIndex - minQuestionIndex) + 1) + minQuestionIndex;		
		}
		return questionIndex;
	}
}
