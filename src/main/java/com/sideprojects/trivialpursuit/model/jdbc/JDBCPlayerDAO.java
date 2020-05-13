package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.PlayerDAO;

@Component
public class JDBCPlayerDAO implements PlayerDAO 
{
	private JdbcTemplate template;

	@Autowired
	public JDBCPlayerDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	// TODO: We're going to have to do this based on user_id. This will need reworked. - Brooks
	// TODO: 99% sure we need a RETURNING statement here, returning Player_id, so we can insert into game_player without a refresh.
	@Override
	public void createPlayer(int userId, String playerName) {
		
		String insertPlayer = "INSERT INTO player (user_id, username) VALUES (?, ?)";
		template.update(insertPlayer, userId, playerName);
	}
	

	public void putPlayerIntoGame(Game game, Integer user_id)
	{
		int gameId = game.getGameID();
		
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (game_id, user_id) VALUES (?, ?)";
		template.update(sqlPutPlayerIntoGame, gameId, user_id);
	
	}

	// TODO: This will probably go unused -- see ^^^
	@Override
	public void putPlayerIntoGame(Game game, Player player)
	{
		int gameId = game.getGameID();
		int playerId = player.getPlayerId();
		
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (game_id, user_id) VALUES (?, ?)";
		template.update(sqlPutPlayerIntoGame, gameId, playerId);
	
	}
	
	public void putFirstPlayerIntoGame(Game game, Integer user_id) {
		
		int gameId = game.getGameID();
		
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (game_id, user_id, player_color) VALUES (?, ?, 1)";
		template.update(sqlPutPlayerIntoGame, gameId, user_id);
	}

	
	// TODO: Could also pass in an integer to jibe with form input (rather than updating activePlayer's position in the Controller, which this method assumes is happening):
	// setPlayerPosition(Game game, Integer newPosition), 
	@Override
	public void setPlayerPosition(Game game, Player activePlayer) {
		
		Integer position = activePlayer.getLocation().getSpaceId();
		Integer user_id = activePlayer.getPlayerId();
		Integer game_id = game.getGameID();
		
		String setPlayerPosition = "UPDATE game_player SET player_position = ? WHERE user_id = ? AND game_id = ?";
		template.update(setPlayerPosition, position, user_id, game_id);
	}
	
	//TODO: Could move this to JDBCGameDAO, privatize, and call in the setActivePlayer() method (pulling the conditional from Controller & putting in jdbc)
	@Override
	public void givePlayerPiePiece (int spaceId, Game game) {
		
		int playerId = game.getActivePlayer().getPlayerId();
		String pie_cat = "";
		
		  if (spaceId == 6) {
			  pie_cat = "player_score_cat_1";
		  } else if (spaceId == 18) {
			  pie_cat = "player_score_cat_2";
		  } else if (spaceId == 30) {
			  pie_cat = "player_score_cat_3";
		  } else if (spaceId == 42) {
			  pie_cat = "player_score_cat_4";
		  } else if (spaceId == 54) {
			  pie_cat = "player_score_cat_5";
		  } else if (spaceId == 66) {
			  pie_cat = "player_score_cat_6";
		  }
		  
		String givePlayerPiePiece = String.format("UPDATE game_player SET %s = true WHERE user_id = ? AND game_id = ?", pie_cat);
		template.update(givePlayerPiePiece, playerId, game.getGameID());	
	}

	@Override
	public Player getPlayer(int userId) {
		Player newPlayer = new Player();
		
		String getPlayerSQL = "SELECT * FROM player WHERE user_id = ?";
		SqlRowSet result = template.queryForRowSet(getPlayerSQL, userId);
		
		if(result.next()) {
			newPlayer.setPlayerId(result.getInt("user_id"));
			newPlayer.setName(result.getString("username"));
		}
		return newPlayer;
	}
	
}

