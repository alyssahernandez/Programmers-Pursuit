package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;


@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate template;
	
	@Autowired
	public JDBCUserDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public User getUserByToken(String token) {
		User user = null;
		String userQuery = "SELECT * FROM user_account WHERE id_token = ?";
		SqlRowSet result = template.queryForRowSet(userQuery, token); 
		
		if(result.next()) {
			user = userHelper(result);
		} 
		return user;
	}
	
	@Override
	public void createUser(String username, String token, String email, String picture) {
		String newUserSQL = "INSERT INTO user_account (username, id_token, email, picture) VALUES (?, ?, ?, ?)";
		template.update(newUserSQL, username, token, email, picture);
	}
	
	@Override
	public User getUserByUsername(String username) {
		User user = null;
		String query = "SELECT * FROM user_account WHERE username = ?";
		SqlRowSet rowSet = template.queryForRowSet(query, username);
		if (rowSet.next()) {
			user = userHelper(rowSet);
		}
		return user;
	}
	
	@Override
	public boolean validateUsername(String username) {
		String query = "SELECT * FROM user_account WHERE username = ?";
		SqlRowSet result = template.queryForRowSet(query, username);
		if (result.next()) {
			return true;
		}
		return false;
	}
	
	public List<User> getFriends(String username) {
		String query = "SELECT user_account.* FROM user_account INNER JOIN friends ON user_account.username = friends.friend_name WHERE friends.username = ? AND friends.friends = true";
		SqlRowSet rowSet = template.queryForRowSet(query, username);
		List<User> friends = new ArrayList<>();
		while (rowSet.next()) {
			friends.add(userHelperShort(rowSet));
		}
		return friends;
	}
	
	public List<User> getPendingFriends(String username) {
		String query = "SELECT user_account.* FROM user_account INNER JOIN friends ON user_account.username = friends.friend_name WHERE friends.username = ? AND friends.friends = false";
		SqlRowSet rowSet = template.queryForRowSet(query, username);
		List<User> friends = new ArrayList<>();
		while (rowSet.next()) {
			friends.add(userHelperShort(rowSet));
		}
		return friends;
	}
	
	public List<User> getIncomingFriends(String username) {
		String query = "SELECT user_account.* FROM user_account INNER JOIN friends ON user_account.username = friends.username WHERE friends.friend_name = ? AND friends.friends = false";
		SqlRowSet rowSet = template.queryForRowSet(query, username);
		List<User> friends = new ArrayList<>();
		while (rowSet.next()) {
			friends.add(userHelperShort(rowSet));
		}
		return friends;
	}
	
	@Override
	public List<User> getAllTimeLeaders() {
		String query = "SELECT * FROM user_account WHERE games_won != 0 AND games_played !=0 AND games_won IS NOT NULL ORDER BY games_won DESC, (games_won / games_played) DESC, games_played DESC LIMIT 25";
		SqlRowSet rowSet = template.queryForRowSet(query);
		List<User> leaders = new ArrayList<>();
		while (rowSet.next()) {
			leaders.add(userHelperShort(rowSet));
		}
		return leaders;
	}
	
	public List<User> getMonthlyLeaders() {
		String query = "SELECT * FROM user_account WHERE games_won != 0 AND games_played !=0 AND games_won IS NOT NULL ORDER BY games_won DESC, (games_won / games_played) DESC, games_played DESC LIMIT 25";
		SqlRowSet rowSet = template.queryForRowSet(query);
		List<User> leaders = new ArrayList<>();
		while (rowSet.next()) {
			leaders.add(userHelperShort(rowSet));
		}
		return leaders;
	}
	
	public List<User> getDailyLeaders() {
		String query = "SELECT * FROM user_account WHERE games_won != 0 AND games_played !=0 AND games_won IS NOT NULL ORDER BY games_won DESC, (games_won / games_played) DESC, games_played DESC LIMIT 25";
		SqlRowSet rowSet = template.queryForRowSet(query);
		List<User> leaders = new ArrayList<>();
		while (rowSet.next()) {
			leaders.add(userHelperShort(rowSet));
		}
		return leaders;
	}
	
	private User userHelper(SqlRowSet result) {
		User user = new User();
		user.setUserId(result.getInt("user_id"));
		user.setUsername(result.getString("username"));
		user.setIdToken(result.getString("id_token"));
		user.setEmail(result.getString("email"));
		user.setPicture(result.getString("picture"));
		user.setGamesPlayed(result.getInt("games_played"));
		user.setGamesWon(result.getInt("games_won"));
		user.setFriends(getFriends(user.getUsername()));
		user.setPendingFriendRequests(getPendingFriends(user.getUsername()));
		user.setIncomingFriendRequests(getIncomingFriends(user.getUsername()));
		return user;
	}
	
	private User userHelperShort(SqlRowSet result) {
		User user = new User();
		user.setUserId(result.getInt("user_id"));
		user.setUsername(result.getString("username"));
		user.setIdToken(result.getString("id_token"));
		user.setPicture(result.getString("picture"));
		user.setGamesPlayed(result.getInt("games_played"));
		user.setGamesWon(result.getInt("games_won"));
		return user;
	}

}