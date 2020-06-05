
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


@Component
public class JDBCGameDAO implements GameDAO {
	
	private JdbcTemplate template;
	private CategoryDAO categoryDAO;

	@Autowired
	public JDBCGameDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		categoryDAO = new JDBCCategoryDAO(dataSource);
	}
	
	@Override
	public String createNewGame(String publicOrPrivate) {
		
		boolean isPublic = false;
		if (publicOrPrivate.equalsIgnoreCase("public")) {
			isPublic = true;
		} else {
			isPublic = false;
		}
		
		String gameCodeLookup = "SELECT * FROM game WHERE game_code = ?";
		String gameCode = Game.generateGameCode();
		boolean validGameCode = false;
		
		do {
			SqlRowSet results = template.queryForRowSet(gameCodeLookup, gameCode);
			if (results.next()) {
				gameCode = Game.generateGameCode();
				continue;
			} else {
				validGameCode = true;
			}
			
		} while (!validGameCode);	

		String query = "INSERT INTO game (game_code, active, is_public) VALUES (?, ?, ?) RETURNING game_code";
		return template.queryForObject(query, String.class, gameCode.toUpperCase(), false, isPublic);
	}
	
	@Override
	public Game getActiveGame(String gameCode) {
		String getGameQuery = "SELECT * FROM game WHERE game_code = ? AND active = true";
		SqlRowSet rowSet = template.queryForRowSet(getGameQuery, gameCode);
		Game game = null;
		if (rowSet.next()) {
			game = gameHelper(rowSet);
		}
		return game;
	}
	
	@Override
	public List<Player> getAllPlayersInAGame(Game game) 
	{
		List<Player> players = new ArrayList<>();                   
		String sqlGetAllPlayers = "SELECT * FROM game_player JOIN user_account ON game_player.user_id "
				+ "= user_account.user_id WHERE game_player.game_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlGetAllPlayers, game.getGameID());
		
		while(results.next()) {
			Player player = new Player();
			player.setName(results.getString("username"));
			player.setPlayerId(results.getInt("user_id"));
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
		String query = "SELECT user_account.*, game_player.*, game.active_player_roll FROM user_account " + 
				"INNER JOIN game_player ON (user_account.user_id = game_player.user_id) " + 
				"INNER JOIN game ON (game_player.game_id = game.game_id) WHERE game.game_id = ? AND user_account.user_id = game.active_player_id";
		
		SqlRowSet results = template.queryForRowSet(query, game.getGameID());
		if (results.next())
			{
				player.setPlayerId(results.getInt("user_id"));
				player.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
				player.setName(results.getString("username"));
				player.setColor(results.getLong("player_color"));
				player.setPie1(results.getBoolean("player_score_cat_1"));
				player.setPie2(results.getBoolean("player_score_cat_2"));
				player.setPie3(results.getBoolean("player_score_cat_3"));
				player.setPie4(results.getBoolean("player_score_cat_4"));
				player.setPie5(results.getBoolean("player_score_cat_5"));
				player.setPie6(results.getBoolean("player_score_cat_6"));
				player.setDiceRoll(results.getInt("active_player_roll"));
			}
		return player;
	}
	
	@Override
	public void setActivePlayer(Game game, boolean isCorrectAnswer)
	{
		Player activePlayer = game.getActivePlayer();

		if (!(isCorrectAnswer))
		{
			int activePlayerIndex = game.getActivePlayers().indexOf(game.getActivePlayer());
			if (activePlayerIndex < game.getActivePlayers().size() - 1)
				activePlayer = game.getActivePlayers().get(activePlayerIndex + 1);
			else
				activePlayer = game.getActivePlayers().get(0);
		}
		
		String query = "UPDATE game SET active_player_id = ? WHERE game_id = ?";
		template.update(query, activePlayer.getPlayerId(), game.getGameID());
	}
	
	@Override
	public void setActivePlayerDiceRoll(Game game, int diceRoll)
	{
		// Player activePlayer = game.getActivePlayer();
		String query = "UPDATE game SET active_player_roll = ? WHERE game_id = ?";
		template.update(query, diceRoll, game.getGameID());
	}
	
	@Override
	public void setIsAnsweringQuestion(Game game, Boolean isAnsweringQuestion)
	{
		String query = "UPDATE game SET active_player_answering_question = ? WHERE game_id = ?";
		template.update(query, isAnsweringQuestion, game.getGameID());
	}
	
	@Override
	public void setIsGameActive(String gameCode, Boolean isActive) {
        String query = "UPDATE game SET active = ? WHERE game_code = ?";
        template.update(query, isActive, gameCode);
	}
	
	@Override
	public void setHasSelectedCategory(Game game, Boolean hasSelectedCategory)
	{
		String query = "UPDATE game SET active_player_category_selected_center = ? WHERE game_id = ?";
		template.update(query, hasSelectedCategory, game.getGameID());
	}
	
	@Override
	public void setEndGameStatus(Game game) {
		String query = "UPDATE game SET winner_id = ? WHERE game_id = ?";
		template.update(query, game.getActivePlayer().getPlayerId(), game.getGameID());
		
		String query2 = "UPDATE user_account SET games_won = games_won + 1, games_played = games_played + 1 WHERE user_id = ?";
		String query3 = "UPDATE user_account SET games_played = games_played + 1 WHERE user_id = ?";
		
		for (Player p : game.getActivePlayers()) {
			if (!p.equals(game.getActivePlayer())) {
				template.update(query3, p.getPlayerId());
			} else {
				template.update(query2, p.getPlayerId());
			}
		}
	}
	
	@Override
	public String getWinner(Game game) {
		String query = "SELECT * FROM user_account INNER JOIN game ON user_account.user_id = game.winner_id WHERE game.game_id = ?";
		SqlRowSet rowSet = template.queryForRowSet(query, game.getGameID());
		
		String playerName = null;
		if (rowSet.next()) {
			playerName = rowSet.getString("username");
		}
		return playerName;
	}
	
	@Override
	public Game getCompletedGame(String gameCode) {
		String query = "SELECT * FROM game WHERE game_code = ? AND active = false AND winner_id IS NOT NULL";
		SqlRowSet rowSet = template.queryForRowSet(query, gameCode);
		Game game = null;
		if (rowSet.next()) {
			game = gameHelper(rowSet);
		}
		return game;
	}
	
	@Override
	public Game getUnstartedGame(String gameCode) {
		String query = "SELECT * FROM game WHERE game_code = ? AND active = false AND winner_id IS NULL";
		SqlRowSet rowSet = template.queryForRowSet(query, gameCode);
		Game game = null;
		if (rowSet.next()) {
			game = gameHelper(rowSet);
		}
		return game;
	}
	
	@Override
	public Integer getPlayerCountByGame(String gameCode) {
		Integer count = null;
		String query = "SELECT COUNT(user_id) FROM game_player INNER JOIN game ON game_player.game_id = game.game_id WHERE game.game_code = ?";
		SqlRowSet results = template.queryForRowSet(query, gameCode);
		if (results.next()) {
			count = results.getInt("count");
		}
		return count;
	}
	
	@Override
	public List<Game> getUnstartedPublicGames() {
		String query = "SELECT game.* FROM game INNER JOIN game_player ON game.game_id = game_player.game_id WHERE game.active = false "
				+ "AND game.winner_id IS NULL AND is_public = true GROUP BY game.game_id ORDER BY COUNT(game_player.game_id) DESC";
		
		List<Game> games = new ArrayList<>();
		SqlRowSet rowSet = template.queryForRowSet(query);
		while (rowSet.next()) {
			games.add(gameHelper(rowSet));
		}
		return games;
	}
	
	@Override
	public List<Game> getActiveGamesByPlayer(Integer user_id) {
		String query = "SELECT * FROM game INNER JOIN game_player ON game.game_id = game_player.game_id WHERE game_player.user_id = ? AND game.active = true";
		List<Game> games = new ArrayList<>();
		SqlRowSet rowSet = template.queryForRowSet(query, user_id);
		while (rowSet.next()) {
			games.add(gameHelper(rowSet));
		}
		return games;
	}
	
	@Override
	public List<Game> getCompletedGamesByPlayer(Integer user_id) {
		String query = "SELECT game.* FROM game INNER JOIN game_player ON game.game_id = game_player.game_id WHERE game_player.user_id = ? AND game.active = false AND game.winner_id IS NOT NULL";
		List<Game> games = new ArrayList<>();
		SqlRowSet rowSet = template.queryForRowSet(query, user_id);
		while (rowSet.next()) {
			games.add(gameHelper(rowSet));
		}
		return games;
	}
	
	@Override
	public List<Game> getUnstartedGamesByPlayer(Integer user_id) {
		String query = "SELECT game.* FROM game INNER JOIN game_player ON game.game_id = game_player.game_id WHERE game_player.user_id = ? AND game.active = false AND game.winner_id IS NULL";
		List<Game> games = new ArrayList<>();
		SqlRowSet rowSet = template.queryForRowSet(query, user_id);
		while (rowSet.next()) {
			games.add(gameHelper(rowSet));
		}
		return games;
	}
	
	@Override
	public void leaveGame(Integer user_id, Integer game_id) {
		String query = "DELETE FROM game_player WHERE user_id = ? AND game_id = ?";
		template.update(query, user_id, game_id);
	}
	
	public Game getGameByCode(String gameCode) {
		String query = "SELECT * FROM game WHERE game_code = ?";
		SqlRowSet result = template.queryForRowSet(query, gameCode);
		Game game = null;
		if (result.next()) {
			game = gameHelper(result);
		}
		return game;
	}
	
	private Game gameHelper(SqlRowSet rowSet) {
		
		Game game = new Game();
		game.setGameID(rowSet.getInt("game_id"));
		game.setActive(rowSet.getBoolean("active"));
		game.setGameCode(rowSet.getString("game_code")); 
		game.setWinnerId(rowSet.getInt("winner_id"));
		game.setActivePlayerRoll(rowSet.getInt("active_player_roll"));
		game.setIsActivePlayerAnsweringQuestion(rowSet.getBoolean("active_player_answering_question"));
		game.setHasActivePlayerSelectedCategory(rowSet.getBoolean("active_player_category_selected_center"));
		game.setIsPublic(rowSet.getBoolean("is_public"));
		
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
	
	// TODO: Update once id/roll from Game table are switched to game_player
	private Player playerHelper(SqlRowSet results, Game game) {
		Player player = new Player();
		player.setName(results.getString("username"));
		player.setPlayerId(results.getInt("user_id"));
		player.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
		player.setColor(results.getLong("player_color"));
		player.setPie1(results.getBoolean("player_score_cat_1"));
		player.setPie2(results.getBoolean("player_score_cat_2"));
		player.setPie3(results.getBoolean("player_score_cat_3"));
		player.setPie4(results.getBoolean("player_score_cat_4"));
		player.setPie5(results.getBoolean("player_score_cat_5"));
		player.setPie6(results.getBoolean("player_score_cat_6"));
		player.setDiceRoll(results.getInt("active_player_roll"));
		
		return player;
	}
	

}

