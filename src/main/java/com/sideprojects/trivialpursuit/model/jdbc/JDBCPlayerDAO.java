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
	
	@Override
	public void createNewPlayer(String name) {
		String insertPlayer = "INSERT INTO player (name) VALUES (?)";
		template.update(insertPlayer, name);
	}
	
	@Override
	public void putPlayerListIntoGame(List<Player> players, Game game)
	{
		Integer gameId = game.getGameID();
		for (Player p : players)
		{
			String sqlPutPlayerIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
			template.update(sqlPutPlayerIntoGame, p.getPlayerId(), game.getGameID());
		}
	}

	@Override
	public void putPlayerIntoGame(int playerId, Game game) {
		String sqlPutPlayerIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
		template.update(sqlPutPlayerIntoGame, playerId, game.getGameID());
	}

	
	@Override
	public void setPlayerPosition(Game game) {
		
		Integer position = game.getActivePlayer().getLocation().getSpaceId();
		Integer player_id = game.getActivePlayer().getPlayerId();
		Integer game_id = game.getGameID();
		
		String setPlayerPosition = "UPDATE game_player SET player_position = ? WHERE player_id = ? AND game_id = ?";
		template.update(setPlayerPosition, position, player_id, game_id);
	}
}

