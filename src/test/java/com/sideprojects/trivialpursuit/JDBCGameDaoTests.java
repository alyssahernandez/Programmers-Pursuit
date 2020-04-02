package com.sideprojects.trivialpursuit;

import java.sql.SQLException;
import java.time.LocalDate;

import javax.sql.DataSource;

import static org.junit.Assert.*;
import java.sql.SQLException;
import java.time.LocalDate; 
import java.util.ArrayList;
import java.util.List;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;
import org.springframework.jdbc.support.rowset.SqlRowSet;

import com.sideprojects.trivialpursuit.model.Game;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Player;
import com.sideprojects.trivialpursuit.model.jdbc.JDBCGameDAO;


public class JDBCGameDaoTests {

	private static SingleConnectionDataSource dataSource;
	private GameDAO gameDao;
	
	@BeforeClass
	public static void setupDataSource() {
		dataSource = new SingleConnectionDataSource();
		dataSource.setUrl("jdbc:postgresql://localhost:5432/trivialpursuit");
		dataSource.setUsername("postgres");
		dataSource.setPassword("postgres1");
		dataSource.setAutoCommit(false);
	}

	@AfterClass
	public static void closeDataSource() throws SQLException {
		dataSource.destroy();
	}

	@Before
	public void setup() {
		gameDao = new JDBCGameDAO(dataSource);
	}
	
	@After
	public void rollback() throws SQLException {
		dataSource.getConnection().rollback();
	}


	public DataSource getDataSource() {
		return dataSource;
	}
	
	@Test
	public void createGameByCodeTest()
	{
		String gameCode = "TEST";
		String query = "SELECT * FROM game WHERE game_code = 'TEST'";
		Game game = new Game();
		gameDao.createNewGame(gameCode);
		
		
		JdbcTemplate template = new JdbcTemplate(dataSource);
		SqlRowSet results = template.queryForRowSet(query);
		
		if (results.next())
		{
			game.setActive(results.getBoolean("active"));
			game.setGameID(results.getInt("game_id"));
			game.setGameCode(results.getString("game_code"));
		}
		
		Assert.assertEquals(gameCode, game.getGameCode());
		Assert.assertEquals(true, game.isActive());
	}

	@Test
	public void getActiveGameTest()
	{
		String gameCode = "TEST";
		gameDao.createNewGame(gameCode);
		Game game = gameDao.getActiveGame(gameCode);

		Assert.assertEquals(gameCode, game.getGameCode());
		Assert.assertEquals(true, game.isActive());
	}
	
	/*
	@Test
	public void getAllPlayersInAGameTest()
	{
		String gameCode = "test";
		Game game = gameDao.getActiveGame(gameCode);
		Integer expectedIdP1 = 6;
		Integer expectedIdP2 = 7;
		Integer expectedIdP3 = 8;
		Integer expectedIdP4 = 9;
		
		List<Player> players = gameDao.getAllPlayersInAGame(game);
		
		Player p = players.get(0);
		Player p2 = players.get(1);
		Player p3 = players.get(2);
		Player p4 = players.get(3);
		
		System.out.println(p.getLocation().getId());
		
		Assert.assertEquals(expectedIdP1, p.getId());
		Assert.assertEquals(expectedIdP2, p2.getId());
		Assert.assertEquals(expectedIdP3, p3.getId());
		Assert.assertEquals(expectedIdP4, p4.getId());
	}
	
	
	@Test
	public void getActivePlayerTest()
	{
		String gameCode = "test";
		Game game = gameDao.getActiveGame(gameCode);
		Integer expectedIdP1 = 6;
		Player player = gameDao.getActivePlayer(game);
		Assert.assertEquals(expectedIdP1, player.getId());
	}
	*/
}