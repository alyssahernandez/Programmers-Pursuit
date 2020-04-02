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
	
	@Override
	public void createNewGame(String code) {
		
		String newGameId = "INSERT INTO game (game_code, active) VALUES (?, ?)";
		template.update(newGameId, code, true);
	}
	
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
		}
		
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
}
