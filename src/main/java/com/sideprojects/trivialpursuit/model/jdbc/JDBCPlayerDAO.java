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

public class JDBCPlayerDAO implements PlayerDAO 
{
	private JdbcTemplate template;

	@Autowired
	public JDBCPlayerDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	@Override
	public void getPlayerByName(String name) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerByName() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPlayerPosition(Player player) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerPosition(Player player) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setPlayerPiesAttained(Integer piesAttained) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Integer getPlayerPiesAttained() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Player> getAllPlayersInAGame(int gameID) {
		List<Player> listAllPlayers = new ArrayList<>();                   
		String sqlGetAllPlayers = "SELECT * FROM game_player JOIN player ON game_player.player_id "
				+ "= player.player_id WHERE game_player.game_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlGetAllPlayers, gameID);
		
		while(results.next()) {
			Player nextPlayer = new Player();
			nextPlayer.setName(results.getString("name"));
			nextPlayer.setId(results.getInt("player_id"));
			listAllPlayers.add(nextPlayer);
		}
		
		return listAllPlayers;
	}

	@Override
	public void setPlayerByGameId(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void putPlayersIntoGame(int playerId, int gameId) {
		String sqlPutPlayersIntoGame = "INSERT INTO game_player (player_id, game_id) VALUES (?, ?)";
		template.update(sqlPutPlayersIntoGame, playerId, gameId);
	}

	@Override
	//getNewPlayer()??
	public void createNewPlayer(String name) {
		String newPlayerId = "INSERT INTO player (name) VALUES (?)";
		template.update(newPlayerId, name);
	}

	@Override
	public void getPlayerById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Player getPlayerByGameId(Game game) {
		// TODO Auto-generated method stub
		return null;
	}
}

