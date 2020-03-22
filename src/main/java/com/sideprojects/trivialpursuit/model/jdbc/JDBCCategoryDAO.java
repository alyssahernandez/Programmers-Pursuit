package com.sideprojects.trivialpursuit.model.jdbc;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;

@Component
public class JDBCCategoryDAO implements CategoryDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCCategoryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public Category getCategoryFromSpace(int userChoiceSpaceID) {
		
		Category categoryFromSpace = new Category();
		
		String sqlGetCategoryFromSpace = "SELECT * FROM category JOIN category_game ON category_game.category_id "
				+ "= category.category_id WHERE category_game.space = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCategoryFromSpace, userChoiceSpaceID);
		
		while(results.next()) {
			categoryFromSpace.setCategoryID(results.getInt("category_id"));
			categoryFromSpace.setCategoryName(results.getString("name"));
		}
		
		return categoryFromSpace;
	}

}
