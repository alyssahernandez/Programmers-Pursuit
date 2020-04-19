package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.Space;

@Component
public class JDBCGameDAO implements GameDAO {
	
	private JdbcTemplate template;
	
	@Autowired
	private CategoryDAO categoryDAO;

	@Autowired
	public JDBCGameDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	/*
		TODO: 
			- After talking w/ Kiran, 95% sure that createNewGame() going to need a "RETURNING game_id" statement @ end 
			- if our homepage will be setting anything but the gamecode -- categories, players, etc. -- on the same form. 
			- We'll need an immediate reference to the game_id in the controller 
			- (which is only created upon insertion into DB) to update game_player, game_category, game_question, etc.
				- Brooks
	*/
	@Override
	public void createNewGame(String gameCode) {
		
		String newGameId = "INSERT INTO game (game_code, active) VALUES (?, ?)";
		template.update(newGameId, gameCode.toUpperCase(), true);
	}
	
	//TODO: include "AND active = true" in query
	@Override
	public Game getActiveGame(String gameCode) {
		String getGameQuery = "SELECT * FROM game WHERE game_code = ?"; // TODO: "AND active = true"
		SqlRowSet rowSet = template.queryForRowSet(getGameQuery, gameCode);

		Game game = new Game();
		if (rowSet.next()) {
			game.setGameID(rowSet.getInt("game_id"));
			game.setActive(rowSet.getBoolean("active"));
			game.setGameCode(gameCode.toUpperCase()); 
			game.setWinnerId(rowSet.getInt("winner_id"));
			game.setActivePlayerRoll(rowSet.getInt("active_player_roll"));
			game.setActivePlayerId(rowSet.getInt("active_player_id"));
			game.setIsActivePlayerAnsweringQuestion(rowSet.getBoolean("active_player_answering_question"));
			game.setHasActivePlayerSelectedCategory(rowSet.getBoolean("active_player_category_selected_center"));
		}
		
		List<Category> categoriesInGame = categoryDAO.getCategoriesByGame(game);
		game.setCategories(categoriesInGame);
		game.createGameboard(categoriesInGame); // TODO: Could do this within Gameboard class once setCategories() is called.

		List<Player> activePlayers = getAllPlayersInAGame(game);
		Player activePlayer = getActivePlayer(game);
		activePlayer.setDiceRoll(game.getActivePlayerRoll());
		game.setActivePlayers(activePlayers);
		game.setActivePlayer(activePlayer);
		
		return game;
	}
	
	//TODO: These should be in the JDBCPlayerDAO/PlayerDAO.
	@Override
	public List<Player> getAllPlayersInAGame(Game game) 
	{
		List<Player> players = new ArrayList<>();                   
		String sqlGetAllPlayers = "SELECT * FROM game_player JOIN player ON game_player.player_id "
				+ "= player.player_id WHERE game_player.game_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlGetAllPlayers, game.getGameID());
		
		while(results.next()) {
			Player player = new Player();
			player.setName(results.getString("name"));
			player.setPlayerId(results.getInt("player_id"));
			player.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
			player.setColor(results.getLong("player_color"));
			player.setPie1(results.getBoolean("player_score_cat_1"));
			player.setPie2(results.getBoolean("player_score_cat_2"));
			player.setPie3(results.getBoolean("player_score_cat_3"));
			player.setPie4(results.getBoolean("player_score_cat_4"));
			player.setPie5(results.getBoolean("player_score_cat_5"));
			player.setPie6(results.getBoolean("player_score_cat_6"));
			players.add(player);
		}
		
		return players;
	}
	
	@Override
	public Player getActivePlayer(Game game)
	{
		Player player = new Player();
		String query = "SELECT player.*, game_player.*, game.active_player_roll FROM player " + 
				"INNER JOIN game_player ON (player.player_id = game_player.player_id) " + 
				"INNER JOIN game ON (game_player.game_id = game.game_id) WHERE game.game_id = ? AND player.player_id = game.active_player_id";
		
		SqlRowSet results = template.queryForRowSet(query, game.getGameID());
		if (results.next())
		{
			player.setPlayerId(results.getInt("player_id"));
			player.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
			player.setName(results.getString("name"));
			player.setColor(results.getLong("player_color"));
			player.setPie1(results.getBoolean("player_score_cat_1"));
			player.setPie2(results.getBoolean("player_score_cat_2"));
			player.setPie3(results.getBoolean("player_score_cat_3"));
			player.setPie4(results.getBoolean("player_score_cat_4"));
			player.setPie5(results.getBoolean("player_score_cat_5"));
			player.setPie6(results.getBoolean("player_score_cat_6"));
			player.setDiceRoll(results.getInt("active_player_roll")); //TODO: "player_dice_roll" from game_player
			//TODO: player.setIsActive? We don't necessarily need it, could still store activePlayer in game table. - Brooks
		}
		return player;
	}
	
	@Override
	public void setActivePlayer(Game game, boolean isCorrectAnswer)
	{
		Player activePlayer = game.getActivePlayer();

		if (!(isCorrectAnswer))
		{
			String update = "UPDATE game_player SET is_turn = false, is_answering_question_center = false, has_selected_category_center = false WHERE game_id = ? AND player_id = ?";
			template.update(update, game.getGameID(), activePlayer.getPlayerId());
			
			int activePlayerIndex = game.getActivePlayers().indexOf(game.getActivePlayer());
			if (activePlayerIndex < game.getActivePlayers().size() - 1)
				activePlayer = game.getActivePlayers().get(activePlayerIndex + 1);
			else
				activePlayer = game.getActivePlayers().get(0);
		}
		
		//TODO: Remove active_player_id from game, change this query to update game_player.is_turn
		String update1 = "UPDATE game SET active_player_id = ? WHERE game_id = ?";
		template.update(update1, activePlayer.getPlayerId(), game.getGameID());
		String update2 = "UPDATE game_player SET is_turn = true, is_answering_question_center = false, has_selected_category_center = false WHERE game_id = ? AND player_id = ?";
		template.update(update2, game.getGameID(), activePlayer.getPlayerId());
	}
	
	@Override
	public void setActivePlayerDiceRoll(Game game)
	{
		Player activePlayer = game.getActivePlayer();
		
		String query = "UPDATE game_player SET player_roll = ? WHERE player_id = ? AND game_id = ?";
		template.update(query, activePlayer.getDiceRoll(), activePlayer.getPlayerId(), game.getGameID());
		String query2 = "UPDATE game SET active_player_roll = ? WHERE game_id = ?";
		template.update(query2, activePlayer.getDiceRoll(), game.getGameID());
	}
	
	public void setIsAnsweringQuestion(Game game, Boolean isAnsweringQuestion)
	{
		String query = "UPDATE game_player SET is_answering_question_center = ? WHERE game_id = ?";
		template.update(query, isAnsweringQuestion, game.getGameID());
	}
	
	// This is for the center space
	public void setHasSelectedCategory(Game game, Boolean hasSelectedCategory)
	{
		String query = "UPDATE game_player SET has_selected_category_center = ? WHERE game_id = ?";
		template.update(query, hasSelectedCategory, game.getGameID());
	}
}
