package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Game;

@Component
public class JDBCCategoryDAO implements CategoryDAO {
	
	private JdbcTemplate jdbcTemplate;

	@Autowired
	public JDBCCategoryDAO(DataSource dataSource) {
		this.jdbcTemplate = new JdbcTemplate(dataSource);
	}

	
	// TODO: I think we'd need a Space/Gameboard table to make this work (as well as a category_space table), wouldn't we?
	// A game's categories (2, 3, or 6 in total) will be tied to 7-19 spaces each.
	// Unless I'm misunderstand what a "space" attribute in the category_game table is doing. Let me know if so!
	
	// TODO: Maybe pass a Space into this? (e.g. player.getLocation()), and reference the spaceId)
	
	@Override
	public Category getCategoryFromSpace(int userChoiceSpaceID) {
		
		Category categoryFromSpace = new Category();
		
		String sqlGetCategoryFromSpace = "SELECT * FROM category JOIN category_game ON category_game.category_id "
										+ "= category.category_id WHERE category_game.space = ?";
		SqlRowSet results = jdbcTemplate.queryForRowSet(sqlGetCategoryFromSpace, userChoiceSpaceID);
		
		while(results.next()) {
			categoryFromSpace.setCategoryId(results.getInt("category_id"));
			categoryFromSpace.setCategoryName(results.getString("name"));
		}
		
		return categoryFromSpace;
	}
	
	//TODO: Use a JDBCQuestionDAO method to populate the Category with a List of questions. Maybe unnecessary with our DB-everything approach, but might be. 
	@Override
	public List<Category> getCategoriesByGameId(Game game) 
	{
		List<Category> categories = new ArrayList<>();
		String query = "SELECT * FROM category INNER JOIN category_game ON category.category_id = category_game.category_id " + 
						"INNER JOIN game ON category_game.game_id = game.game_id WHERE game.game_id = ?";
		
		SqlRowSet results = jdbcTemplate.queryForRowSet(query, game.getGameID());
		
		while (results.next())
		{
			Category c = new Category();
			c.setCategoryId(results.getInt("category_id"));
			c.setCategoryName(results.getString("name"));
			categories.add(c);
		}
		return categories;
	}
	
	//TODO: Fill out method(s) below

	@Override
	public void setCategoryByGameId(Game game) 
	{
		
	}
}
