package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.Question;
import com.sideprojects.trivialpursuit.model.QuestionDAO;

@Component
public class JDBCQuestionDAO implements QuestionDAO {
	
	private JdbcTemplate jdbcTemplate;
	private CategoryDAO categoryDAO;

	@Autowired
	public JDBCQuestionDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}
	
	@Override
	public Question getUnaskedQuestionByCategory(Game game, Integer category_id)
	{
		Question question = null;
		List<Question> questions = getUnaskedQuestionsByCategory(game, category_id);
		
		if (questions == null || questions.size() == 0)
			return null;
		//TODO: @Controller, if null is returned, tell users the game is over because they're out of questions for a category.
		
		int questionIndex = getQuestionIndex(questions.size());
		question = questions.get(questionIndex);
		
		String query = "UPDATE game_question SET is_current_question = true WHERE game_question.game_id = ? AND game_question.question_id = ?";
		jdbcTemplate.update(query, game.getGameID(), question.getQuestionID());
		
		return question;
	}
	
	public Question getCurrentQuestion(Game game)
	{
		Question question = new Question();
		
		String query = "SELECT * FROM question INNER JOIN game_question ON question.question_id = game_question.question_id " +
					   "WHERE game_question.game_id = ? AND game_question.is_current_question = true";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, game.getGameID());
		if (rowSet.next())
		{
			List<String> possibleAnswers = new ArrayList<>();
			question.setAnswer(rowSet.getString("correct_answer"));
			question.setCategoryID(rowSet.getInt("category_id"));
			question.setQuestion(rowSet.getString("question"));
			question.setQuestionID(rowSet.getInt("question_id"));
			possibleAnswers.add(rowSet.getString("answer_choice_a"));
			possibleAnswers.add(rowSet.getString("answer_choice_b"));
			possibleAnswers.add(rowSet.getString("answer_choice_c"));
			possibleAnswers.add(rowSet.getString("answer_choice_d"));
			question.setPossibleAnswers(possibleAnswers);
		}
		return question;
	}
	
	@Override
	public void setQuestionAsked(Game game, Question question)
	{
		
		String query = "UPDATE game_question SET is_current_question = false WHERE game_id = ? AND question_id = ?";
		//String query = "UPDATE game_question SET asked = true, is_current_question = false WHERE game_id = ? AND question_id = ?";
		jdbcTemplate.update(query, game.getGameID(), question.getQuestionID());
	}
	
	@Override
	public void setGameQuestions(Game game, List<Integer> category_IDs)
	{
		
		List<Question> questions = getQuestionsByCategory(category_IDs);
		String query = "INSERT INTO game_question (game_id, question_id, asked) VALUES (?, ?, false)";
		
		for (Question q : questions)
			jdbcTemplate.update(query, game.getGameID(), q.getQuestionID());
			
	}
	
	private List<Question> getUnaskedQuestionsByCategory(Game game, Integer category_id)
	{
		List<Question> questions = new ArrayList<>();
		String query = "SELECT * FROM question INNER JOIN game_question ON (question.question_id = game_question.question_id) " + 
						"WHERE game_question.game_id = ? AND question.category_id = ? AND game_question.asked = false";
		
		SqlRowSet rowSet = jdbcTemplate.queryForRowSet(query, game.getGameID(), category_id);
		
		while (rowSet.next())
		{
			Question question = new Question();
			List<String> possibleAnswers = new ArrayList<>();
			question.setAnswer(rowSet.getString("correct_answer"));
			question.setCategoryID(rowSet.getInt("category_id"));
			question.setQuestion(rowSet.getString("question"));
			question.setQuestionID(rowSet.getInt("question_id"));
			possibleAnswers.add(rowSet.getString("answer_choice_a"));
			possibleAnswers.add(rowSet.getString("answer_choice_b"));
			possibleAnswers.add(rowSet.getString("answer_choice_c"));
			possibleAnswers.add(rowSet.getString("answer_choice_d"));
			question.setPossibleAnswers(possibleAnswers);
			questions.add(question);
		}
		return questions;
	}
	
	private List<Question> getQuestionsByCategory(List<Integer> category_ids)
	{
		List<Question> questions = new ArrayList<>();
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		
		for (Integer cat : category_ids)
		{
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, cat);
			
			while (rowSet.next()) 
			{
				Question question = new Question();
				List<String> possibleAnswers = new ArrayList<>();
				question.setAnswer(rowSet.getString("correct_answer"));
				question.setCategoryID(rowSet.getInt("category_id"));
				question.setQuestion(rowSet.getString("question"));
				question.setQuestionID(rowSet.getInt("question_id"));
				possibleAnswers.add(rowSet.getString("answer_choice_a"));
				possibleAnswers.add(rowSet.getString("answer_choice_b"));
				possibleAnswers.add(rowSet.getString("answer_choice_c"));
				possibleAnswers.add(rowSet.getString("answer_choice_d"));
				question.setPossibleAnswers(possibleAnswers);
				questions.add(question);
			}
		}
		return questions;
	}
	
	/*
	private List<Question> getQuestionsByCategory(List<Category> categories)
	{
		List<Question> questions = new ArrayList<>();
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		
		for (Category cat : categories)
		{
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, cat.getCategoryId());
			
			while (rowSet.next()) 
			{
				Question question = new Question();
				List<String> possibleAnswers = new ArrayList<>();
				question.setAnswer(rowSet.getString("correct_answer"));
				question.setCategoryID(rowSet.getInt("category_id"));
				question.setQuestion(rowSet.getString("question"));
				question.setQuestionID(rowSet.getInt("question_id"));
				possibleAnswers.add(rowSet.getString("answer_choice_a"));
				possibleAnswers.add(rowSet.getString("answer_choice_b"));
				possibleAnswers.add(rowSet.getString("answer_choice_c"));
				possibleAnswers.add(rowSet.getString("answer_choice_d"));
				question.setPossibleAnswers(possibleAnswers);
				questions.add(question);
			}
		}
		return questions;
	}
	
		
	
	public void setGameQuestions(Game game, List<Category> categories) {
		
		List<Question> questions = getQuestionsByCategory(categories);
		String query = "INSERT INTO game_question (game_id, question_id, asked) VALUES (?, ?, false)";
		
		for (Question q : questions)
			jdbcTemplate.update(query, game.getGameID(), q.getQuestionID());
		
	}
	*/
	
	
	// Helper method to retrieve a random question from a List<Question> based on the list's size (because questions are pulled from the DB in the same order every time -- we want unique games)
	private int getQuestionIndex(int length)
	{	
		int questionIndex = 0;
		if (length > 1) 
		{		
			int minQuestionIndex = 0;
			int maxQuestionIndex = length - 1;
			Random r = new Random();
			questionIndex = r.nextInt((maxQuestionIndex - minQuestionIndex) + 1) + minQuestionIndex;		
		}
		return questionIndex;
	}
}
