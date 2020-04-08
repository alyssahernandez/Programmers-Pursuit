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
	
	@Override
	public List<Category> getCategoriesByGame(Game game) 
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

		// TODO: Lines 71-79 may be more effectively implemented in the Controller/front-end
		// We still want a list that contains 6 categories, even if only 2 or 3 are chosen (for the legend, generating categorized spaces, etc)
		// For an active player on space 0 (which presents the "problem" of doing this here), 
		// to display questions, either filter the list or store original category selections in the session 
		// This is as opposed to displaying "java" 3 for a 2-category game whenever someone lands on space 0 -- not ideal!
		// - Brooks
		
		List<Category> copy = new ArrayList<>();
		for (Category c : categories)
			copy.add(c);
		
		if (categories.size() == 3) 
			categories.addAll(copy);
		else if (categories.size() == 2)
			for (int i = 0; i < 2; i++)
				categories.addAll(copy);

		return categories;
	}
	
	//TODO: If category selection is on same form as entering game code + players, this will likely need a "RETURNING game_id" appended to end of query. - Brooks
	@Override
	public void setCategoriesByGameId(Game game, List<Integer> category_IDs) 
	{
		String query = "INSERT INTO category_game (game_id, category_id) VALUES (?, ?)";
		
		for (Integer cat_id : category_IDs)
			jdbcTemplate.update(query, game.getGameID(), cat_id);
	}
	
	
	// TODO: Given we're allowing for 2/3/6 categories, getCategoryFromSpace() won't work at present
	// The category of some spaces will differ depending on the # of categories chosen.  
	// If we update DB to handle space associations for 2/3/6-category games, this will work lovelyly. 
	// On that note, keeping it around for now - Brooks

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
}
