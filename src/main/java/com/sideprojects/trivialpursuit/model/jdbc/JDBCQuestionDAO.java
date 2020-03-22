package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
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
	public Question getQuestionFromCategory(Category categoryFromSpace) {
				
		List<Question> allQuestionsInCategory = new ArrayList<>();
		String sqlGetQuestionFromCategory = "SELECT * FROM question JOIN category_question ON "
				+ "category.category_id = question.category_id WHERE category.category_id = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetQuestionFromCategory, categoryFromSpace.getCategoryID());
		
		while(results.next()) {
			Question questionFromCategory = new Question();
			questionFromCategory.setQuestionID(results.getInt("question_id"));
			questionFromCategory.setCategoryID(results.getInt("category_id"));
			questionFromCategory.setQuestion(results.getString("question"));
			questionFromCategory.setAnswer(results.getString("answer"));
			allQuestionsInCategory.add(questionFromCategory);
		}
		
		//AC: not sure how to make this question not asked again, that is an unknown.
		//right now it is only returning the first question in the table for each category.
		Question firstQuestionInList = allQuestionsInCategory.get(0);
		return firstQuestionInList;
	}

}
