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
	@Override
	public Question getUnaskedQuestionByCategory(Game game, Integer category_id)
	{
		Question question = null;
		List<Question> questions = getUnaskedQuestionsByCategory(game, category_id);
		if (questions == null || questions.size() == 0)
			return null;
		//TODO: @Controller, if null is returned, tell users the game is over because they're out of questions for a category.
		
		int questionIndex = getQuestionIndex(questions);
		question = questions.get(questionIndex);
		
		String query = "UPDATE game_question SET is_current_question = true WHERE game_question.game_id = ? AND game_question.question_id = ?";
		jdbcTemplate.update(query, game.getGameID(), question.getQuestionID());
		
		return question;
	}
	
	// TODO: May need to pass in something other than a list depending on how Kiran does form input
	// Uses private "getQuestionsByCategory()" method below to set questions in game_question. //TODO: This is what will be used in Controller @ Kiran. - Brooks
	@Override
	public void setGameQuestions(Game game, List<Integer> category_IDs)
	{
		List<Question> questions = getQuestionsByCategory(category_IDs);
		String query = "INSERT INTO game_question (game_id, question_id, asked) VALUES (?, ?, false)";
		
		for (Question q : questions)
			jdbcTemplate.update(query, game.getGameID(), q.getQuestionID());
	}
	
	// TODO: getUnaskedQuestion() ^^ above to display question. Use this to pull it back out to compare an answer (tho I think the question should go in session!) - Brooks
	// TODO: Test the query
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
		setQuestionAsked(game, question); // TODO: Uncomment this
		return question;
	}
	
	// TODO: May need to pass in something other than a list depending on how Kiran does form input
	// TODO: Call this inside of setGameQuestions()
	// Gets questions by a list of category_id's to store in game_question.
	private List<Question> getQuestionsByCategory(List<Integer> category_IDs)
	{
		List<Question> questions = new ArrayList<>();
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		
		for (Integer cat_id : category_IDs)
		{
			SqlRowSet rowSet = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, cat_id);
			
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
	
	// Pulls a list of unasked questions, from which we'll pull a single question in getUnaskedQuestion above.
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
	
	//TODO: Set "is_current_question = false"
	// Updates the pulled question to "asked" in the DB so that we don't pull it again.
	private void setQuestionAsked(Game game, Question question)
	{
		String query = "UPDATE game_question SET asked = true, is_current_question = false WHERE game_id = ? AND question_id = ?";
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
