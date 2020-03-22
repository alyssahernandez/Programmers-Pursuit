package com.sideprojects.trivialpursuit.model.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

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
	public Player getPlayerByGameId(Game game) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setPlayerByGameId(Game game) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void getPlayerById(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	//getNewPlayer()??
	public Long setNewPlayer(String name) {
		String newPlayerId = "INSERT INTO game (name) VALUES (?) RETURNING player_id";
		return template.queryForObject(newPlayerId, Long.class, name);
	}
}

