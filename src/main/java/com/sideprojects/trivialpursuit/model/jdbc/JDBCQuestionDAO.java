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
	
	//TODO: Method for selecting all questions based on variable amount of user-chosen categories. Signature: public List<Question> gameQuestions(Integer... category_Ids)
	//TODO: Method for inserting those questions into game_question table
	//TODO: Method for selecting questions from game_question table (SELECT * FROM game_question WHERE category_id = ? AND asked = false)
	//TODO: If we only want to store a single Question in our game (rather than constantly creating 1500 Question objects)... 
		//  ...then a Method for selecting a single question from those in game_question table, utilizing method from second-to-last TODO.
	@Override
	public Question getQuestionByCategory(Category category) {
		
		int categoryId = category.getCategoryId();
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, categoryId);
		
		Question questionFromCategory = new Question();
		if (results.next()) {
			questionFromCategory.setQuestionID(results.getInt("question_id"));
			questionFromCategory.setCategoryID(results.getInt("category_id"));
			questionFromCategory.setQuestion(results.getString("question"));
			questionFromCategory.setAnswer(results.getString("answer"));
		}
		return questionFromCategory;
	}
	
	@Override
	public List<Question> getQuestionsByCategory(Category category) {
		
		int categoryId = category.getCategoryId();
		List<Question> allQuestionsInCategory = new ArrayList<>();
		
		String sqlGetQuestionFromCategory = "SELECT * FROM question WHERE category_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, categoryId);
		
		while(results.next()) {
			Question questionFromCategory = new Question();
			questionFromCategory.setQuestionID(results.getInt("question_id"));
			questionFromCategory.setCategoryID(results.getInt("category_id"));
			questionFromCategory.setQuestion(results.getString("question"));
			questionFromCategory.setAnswer(results.getString("answer"));
			allQuestionsInCategory.add(questionFromCategory);
		}
		return allQuestionsInCategory;
	}
	
	// TODO: Controller: When a "getQuestion()" method is called in Controller, subsequently call the update JDBC for that particular question. - Brooks
	public void setQuestionAsked(Game game, Question question)
	{
		String query = "UPDATE game_question SET asked = true WHERE game_id = ? AND question_id = ?";
		jdbcTemplate.update(query, game.getGameID(), question.getQuestionID());
	}
}
