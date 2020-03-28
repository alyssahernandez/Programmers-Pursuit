package com.sideprojects.trivialpursuit.model.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;

@Component
public class JDBCGameDAO implements GameDAO {
	
	private JdbcTemplate template;

	@Autowired
	public JDBCGameDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}

	@Override
	public Game getGameByCode() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	@Override
//	public void setGameCode(Game game) {
//		
//		// *** TODO: Need a game_code attribute in Game table!! ***
//		String setCodeQuery = "UPDATE game SET game_code = ? WHERE game_id = ?";
//		template.update(setCodeQuery, game.getGameCode(), game.getGameID());
//		
//	}

	@Override
	// In controller, this will return a game_id to tie to a new game.
	public void createNewGame(String code) {
		 // What is active_player_id even for? We can determine # of active players from bridge table (isActive should be a bool in game_player, I think)).
		// active_player_id is used in regards to turn order in the controller &
		// can also be used to pick up an active game that was paused etc - alyssa
		// TODO: Can we pass null into 4int4 DB type? If not, we should set it to something that can take a null value -- we won't have winner ID's, for example, from the start.
		String newGameId = "INSERT INTO game (game_code, active) VALUES (?, ?)";
		template.update(newGameId, code, true);
	}
	

	@Override
	// User passes in a game code, gets matching game
	public Game getActiveGame(String gameCode) {
		String getGameQuery = "SELECT * FROM game WHERE game_code = ?";
		SqlRowSet rowSet = template.queryForRowSet(getGameQuery, gameCode);
		
		Game game = new Game();
		if (rowSet.next())
		{
			game.setGameID(rowSet.getLong("game_id"));
			game.setActive(rowSet.getBoolean("active"));
			game.setGameCode(gameCode); 
			game.setWinnerId(rowSet.getInt("winner_id"));
			// game.setActivePlayers(activePlayers);
			//TODO: setting Active Players needs to be done elsewhere (e.g. pulling from game_player as well based on game_id, joining with player_id (player is active))
			// In controller, could pass in this game (using ID), then pulling players from game_player based on game_id, then pulling those players based on isActive
			// *** TODO: *** reference if player is active somewhere in DB. Really, doesn't matter if we don';t have log-in, but then WTF else are we pulling pre-existing games for if pre-existing players can't acces them???
			
		}
		return game;
	}


}
