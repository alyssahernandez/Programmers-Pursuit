
package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.Dice;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Invitation;
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
	
	/*
	@Override
	public void createNewGame(String gameCode) {
		
		String newGameId = "INSERT INTO game (game_code, active) VALUES (?, ?)";
		template.update(newGameId, gameCode.toUpperCase(), true);
	}
	*/
	
	@Override
	public void createNewGame(String gameCode, Integer user_id) {
		
		int dice_roll = Dice.getDiceRoll();
		
		String newGameId = "INSERT INTO game (game_code, active, active_player_id, active_player_roll) VALUES (?, ?, ?, ?)";
		template.update(newGameId, gameCode.toUpperCase(), false, user_id, dice_roll);
	}
	
	//TODO: Change ILIKE back to equals (=)
	@Override
	public Game getActiveGame(String gameCode) {
		String getGameQuery = "SELECT * FROM game WHERE game_code = ? AND active = true";
		SqlRowSet rowSet = template.queryForRowSet(getGameQuery, gameCode);

		return gameHelper(rowSet, gameCode);
	}
	
	//TODO: These should be in the JDBCPlayerDAO/PlayerDAO.
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
	public void setIsGameActive(Game game, Boolean isActive) {
        String query = "UPDATE game SET active = ? WHERE game_id = ?";
        template.update(query, isActive, game.getGameID());
	}
	
	@Override
	public void setHasSelectedCategory(Game game, Boolean hasSelectedCategory)
	{
		String query = "UPDATE game SET active_player_category_selected_center = ? WHERE game_id = ?";
		template.update(query, hasSelectedCategory, game.getGameID());
	}
	
	@Override
	public void setWinner(Game game) {
		String query = "UPDATE game SET winner_id = ? WHERE game_id = ?";
		template.update(query, game.getActivePlayer().getPlayerId(), game.getGameID());
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
	
	//TODO: Combine this with getActiveGame -- maybe just don't even check if active = true/false, 
	@Override
	public Game getCompletedGame(String gameCode) {
		String query = "SELECT * FROM game WHERE game_code = ? AND active = false";
		SqlRowSet rowSet = template.queryForRowSet(query, gameCode);
		
		return gameHelper(rowSet, gameCode);
	}
	
	@Override
	public Game getUnstartedGame(String gameCode) {
		String query = "SELECT * FROM game WHERE game_code = ? AND active = false AND winner_id IS NULL";
		SqlRowSet rowSet = template.queryForRowSet(query, gameCode);
		
		return gameHelper(rowSet, gameCode);
	}
	
	@Override
	public void sendInvitation(Integer game_id, String invitee, String invitedBy) {
		String query = "INSERT INTO user_invite (game_id, invitee, invited_by) VALUES (?, ?, ?)";
		template.update(query, game_id, invitee, invitedBy);
	}
	
	@Override
	//TODO: Update this for game.active=false and winner_id = null
	public List<Invitation> getInvitations(String username) {
		String query = "SELECT * FROM user_invite WHERE invitee = ?";
		SqlRowSet results = template.queryForRowSet(query, username);
		
		List<Invitation> invitations = new ArrayList<>();
		while (results.next()) {
			Invitation i = new Invitation();
			i.setGameId(results.getInt("game_id"));
			i.setInvitationId(results.getInt("invite_id"));
			i.setInvitedBy(results.getString("invited_by"));
			i.setInvitee(results.getString("invitee"));
			invitations.add(i);
		}
		return invitations;
	}
	
	private Game gameHelper(SqlRowSet rowSet, String gameCode) {
		Game game = null;
		if (rowSet.next()) {
			game = new Game();
			game.setGameID(rowSet.getInt("game_id"));
			game.setActive(rowSet.getBoolean("active"));
			game.setGameCode(gameCode.toUpperCase()); 
			game.setWinnerId(rowSet.getInt("winner_id"));
			game.setActivePlayerRoll(rowSet.getInt("active_player_roll"));
			game.setIsActivePlayerAnsweringQuestion(rowSet.getBoolean("active_player_answering_question"));
			game.setHasActivePlayerSelectedCategory(rowSet.getBoolean("active_player_category_selected_center"));
		}
		
		if (game == null) {
			return null;
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
	
}

