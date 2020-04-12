package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
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
	
	
	// TODO: 99% sure we need a RETURNING statement here, returning Player_id, so we can insert into game_player without a refresh.
	@Override
	public void createPlayer(String playerName) {
		
		String insertPlayer = "INSERT INTO player (name, games_won, games_played) VALUES (?, 0, 0)";
		template.update(insertPlayer, playerName);
	}
	
	//TODO: Include game_player insertion method within createPlayers method to do everything at once. 
	//TODO: this may be unnecessary?  Not sure yet. - Brooks
	@Override
	public void createPlayers(List<String> players) {
		
		String insertPlayer = "INSERT INTO player (name, games_won, games_played) VALUES (?, 0, 0)";
		for (String playerName : players)
			template.update(insertPlayer, playerName);
	}

	//TODO: This could/should probably be a List<String> or List<Integer> (where Integer = player_id). 
	@Override
	public void putPlayersIntoGame(Game game, List<Player> players)
	{
		Integer gameId = game.getGameID();
		for (Player p : players)
		{
			String sqlPutPlayerIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
			template.update(sqlPutPlayerIntoGame, p.getPlayerId(), game.getGameID());
		}
	}
	
	// TODO: Could also pass in an integer to jibe with form input (rather than updating activePlayer's position in the Controller, which this method assumes is happening):
	// setPlayerPosition(Game game, Integer newPosition), 
	@Override
	public void setPlayerPosition(Game game, Player activePlayer) {
		
		Integer position = activePlayer.getLocation().getSpaceId();
		Integer player_id = activePlayer.getPlayerId();
		Integer game_id = game.getGameID();
		
		String setPlayerPosition = "UPDATE game_player SET player_position = ? WHERE player_id = ? AND game_id = ?";
		template.update(setPlayerPosition, position, player_id, game_id);
	}
	
	@Override
	public void givePlayerPiePiece (int spaceId, Game game) {
		int catNumber = 0;

		  if (spaceId == 6) {
			  catNumber = 1;
		  } else if (spaceId == 18) {
			  catNumber = 2;
		  } else if (spaceId == 30) {
			  catNumber = 3;
		  } else if (spaceId == 42) {
			  catNumber = 4;
		  } else if (spaceId == 54) {
			  catNumber = 5;
		  } else if (spaceId == 66) {
			  catNumber = 6;
      }

		String givePlayerPiePiece = "UPDATE game_player SET player_score_cat_? = true WHERE player_id = ? AND "
				+ "game_id = ?";
		template.update(givePlayerPiePiece, catNumber, game.getGameID());
		
		
		
	}
	
}

