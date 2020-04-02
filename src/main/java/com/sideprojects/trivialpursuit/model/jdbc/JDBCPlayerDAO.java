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
	
	// TODO: Should we have a "RETURNING" statement @ end of query, returning the the players newly generated player_id (because the DB is serialized) to reference elsewhere?
	@Override
	public void createNewPlayer(String name) {
		String insertPlayer = "INSERT INTO player (name) VALUES (?)";
		template.update(insertPlayer, name);
	}
	
	@Override
	public void putPlayerListIntoGame(List<Player> players, int gameId)
	{
		for (Player p : players)
		{
			String sqlPutPlayerIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
			template.update(sqlPutPlayerIntoGame, p.getId(), gameId);
		}
	}

	@Override
	public void putPlayerIntoGame(int playerId, int gameId) {
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
		template.update(sqlPutPlayerIntoGame, playerId, gameId);
	}

	
	@Override
	public void setPlayerPosition(Player player, Game game) {
		String setPlayerPosition = "UPDATE game_player SET player_position = ? WHERE player_id = ? AND game_id = ?";
		template.update(setPlayerPosition, player.getLocation().getId(), player.getId(), game.getGameID());
	}
	
}

