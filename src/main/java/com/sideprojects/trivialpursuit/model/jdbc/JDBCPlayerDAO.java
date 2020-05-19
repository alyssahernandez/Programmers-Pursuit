package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Category;
import com.sideprojects.trivialpursuit.model.Dice;
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

	@Override
	public void putPlayerIntoGame(Integer game_id, Integer user_id, Integer color_id)
	{
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (game_id, user_id, player_color) VALUES (?, ?, ?)";
		template.update(sqlPutPlayerIntoGame, game_id, user_id, color_id);
	}
	
	public void putFirstPlayerIntoGame(Game game, Integer user_id) {
		
		Integer gameId = game.getGameID();
		
		int dice_roll = Dice.getDiceRoll();
		
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (game_id, user_id, player_color, player_roll, is_turn) VALUES (?, ?, 1, ?, true)";
		String query = "UPDATE game SET active_player_id = ?, active_player_roll = ? WHERE game_id = ?";
		
		template.update(sqlPutPlayerIntoGame, gameId, user_id, dice_roll);
		template.update(query, user_id, dice_roll, gameId);
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

