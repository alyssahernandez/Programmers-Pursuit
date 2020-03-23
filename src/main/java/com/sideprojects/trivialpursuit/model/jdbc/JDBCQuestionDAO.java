package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

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
	
	@Override
	// Modified slightly.
	// This is likely unnecessary as we're storing Questions as a List in Category class/objs -- for now! Let me know your thoughts as there may be a better approach. For now, the query below seems apt.
	public Question getQuestionByCategory(Category category) {
		
		int categoryId = category.getCategoryID();
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
		
		int categoryId = category.getCategoryID();
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
	
	public void setQuestionAsked() {} //TODO: update game_question table to NULL if question has been asked

}
