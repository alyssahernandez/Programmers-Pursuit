package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

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
	
	//TODO: Include game_player insertion method within createPlayers method to do everything at once.  
	
	@Override
	public void createPlayers(List<String> playerNames) {
		
		String insertPlayer = "INSERT INTO player (name, games_won, games_played) VALUES (?, 0, 0)";
		for (String playerName : playerNames)
			template.update(insertPlayer, playerName);
	}
	
	// TODO: This probably isn't needed (Kiran is passing in a List<Player> from homepage), but could be used down the line.
	@Override
	public void createPlayer(String playerName) {
		
		String insertPlayer = "INSERT INTO player (name, games_won, games_played) VALUES (?, 0, 0)";
		template.update(insertPlayer, playerName);
	}
	
	// As commented in JDBCGameDAO, we will likely need a "RETURNING game_id" statement appended to end of the "createGame()" method 
	// given the game creation + players will be part of the same form. 
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
	public void setPlayerPosition(Game game) {
		
		Integer position = game.getActivePlayer().getLocation().getSpaceId();
		Integer player_id = game.getActivePlayer().getPlayerId();
		Integer game_id = game.getGameID();
		
		String setPlayerPosition = "UPDATE game_player SET player_position = ? WHERE player_id = ? AND game_id = ?";
		template.update(setPlayerPosition, position, player_id, game_id);
	}
	

}

