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
		
		// ensures that we have 6 items in our List of categories (even duplicates).
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
}
