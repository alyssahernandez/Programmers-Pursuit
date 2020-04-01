package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;

@Component
public class JDBCGameDAO implements GameDAO {
	
	private JdbcTemplate template;

	@Autowired
	public JDBCGameDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}


	// TODO Should this return a game_id? I'm 95% sure that it should. Let me know @ Controller Team - Brooks
	// Can we pass null into 4int4 DB type? If not, we should set it to something that can take a null value -- we won't have winner ID's, for example, from the start.
	
	@Override
	public void createNewGame(String code) {
		
		String newGameId = "INSERT INTO game (game_code, active) VALUES (?, ?)";
		template.update(newGameId, code, true);
	}
	
	// TODO: Add game_code attribute to Game table in DB
	// We also had another (unfinished) "getGameByCode()" query.  They do the exact same thing (tho I like that name better) Removed the other. -- Brooks
	
	@Override
	public Game getActiveGame(String gameCode) {
		String getGameQuery = "SELECT * FROM game WHERE game_code = ?";
		SqlRowSet rowSet = template.queryForRowSet(getGameQuery, gameCode);
		
		Game game = new Game();
		if (rowSet.next())
		{
			game.setGameID(rowSet.getInt("game_id"));
			game.setActive(rowSet.getBoolean("active"));
			game.setGameCode(gameCode); 
			game.setWinnerId(rowSet.getInt("winner_id"));
			// game.setActivePlayers(activePlayers);
			//TODO: setting Active Players needs to be done elsewhere (e.g. pulling from game_player as well based on game_id, joining with player_id (player is active))
			// In controller, could pass in this game (using ID), then pulling players from game_player based on game_id, then pulling those players based on isActive
			// *** TODO: *** reference if player is active somewhere in DB. Really, doesn't matter if we don';t have log-in, but then WTF else are we pulling pre-existing games for if pre-existing players can't acces them???
			
		}
		
		// TODO: Should getAllPlayersInAGame() be declared separately in the Controller? 
		List<Player> activePlayers = getAllPlayersInAGame(game);
		game.setActivePlayers(activePlayers);
		return game;
	}
	
	//TODO: Update these next two & any other methods that pull a Player to also include their category score / Pies (need to update Player class)
	//TODO: These should be in the JDBCPlayerDAO/PlayerDAO.
	@Override
	public List<Player> getAllPlayersInAGame(Game game) 
	{
		List<Player> listAllPlayers = new ArrayList<>();                   
		String sqlGetAllPlayers = "SELECT * FROM game_player JOIN player ON game_player.player_id "
				+ "= player.player_id WHERE game_player.game_id = ?";
		SqlRowSet results = template.queryForRowSet(sqlGetAllPlayers, game.getGameID());
		
		while(results.next()) {
			Player nextPlayer = new Player();
			nextPlayer.setName(results.getString("name"));
			nextPlayer.setId(results.getInt("player_id"));
			nextPlayer.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
			nextPlayer.setColor(results.getLong("player_color"));
			listAllPlayers.add(nextPlayer);
		}
		return listAllPlayers;
	}
	
	//TODO: Let me know if this works for you, Alyssa. If yes, delete this; if not, let me know what's needed.  - Brooks
	@Override
	public Player getActivePlayer(Game game)
	{
		Player player = new Player();
		String query = "SELECT player.*, game_player.* FROM player " + 
				"INNER JOIN game_player ON (player.player_id = game_player.player_id) " + 
				"INNER JOIN game ON (game_player.game_id = game.game_id) WHERE game.game_id = ? AND player.player_id = game.active_player_id";
		
		SqlRowSet results = template.queryForRowSet(query, game.getGameID());
		if (results.next())
		{
			player.setId(results.getInt("player_id"));
			player.setLocation(game.getGameboard().getSpaces().get(results.getInt("player_position")));
			player.setName(results.getString("name"));
			player.setColor(results.getLong("player_color"));
		}
		return player;
	}
	
	
//	@Override
//	public void setGameCode(Game game) {
//		
//		// *** TODO: Need a game_code attribute in Game table!! ***
//		String setCodeQuery = "UPDATE game SET game_code = ? WHERE game_id = ?";
//		template.update(setCodeQuery, game.getGameCode(), game.getGameID());
//		
//	}



}
