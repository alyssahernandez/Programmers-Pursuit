package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Invitation;
import com.sideprojects.trivialpursuit.model.InvitationDAO;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.User;
import com.sideprojects.trivialpursuit.model.UserDAO;

@Component
public class JDBCInvitationDAO implements InvitationDAO {

	private JdbcTemplate template;
	private UserDAO userDAO;
	private PlayerDAO playerDAO;
	private GameDAO gameDAO;

	@Autowired
	public JDBCInvitationDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		userDAO = new JDBCUserDAO(dataSource);
		gameDAO = new JDBCGameDAO(dataSource);
		playerDAO = new JDBCPlayerDAO(dataSource);
	}
	
	@Override
	public void sendInvitation(String gameCode, String invitee, String invitedBy) {
		
		if (doesInvitationExist(gameCode, invitee, invitedBy)) return;
		
		String insertQuery = "INSERT INTO user_invite (game_code, invitee, invited_by) VALUES (?, ?, ?)";
		template.update(insertQuery, gameCode, invitee, invitedBy);
	}
	
	@Override
	public List<Invitation> getInvitations(String username) {
		String query = "SELECT ui.game_code, ui.invited_by, ui.invitee, ui.invite_id, game.game_id FROM user_invite AS ui INNER JOIN game ON ui.game_code = game.game_code WHERE game.active = false AND game.winner_id IS NULL AND ui.invitee = ?";
		SqlRowSet results = template.queryForRowSet(query, username);
		
		List<Invitation> invitations = new ArrayList<>();
		while (results.next()) {
			Integer game_id = results.getInt("game_id");
			User user = userDAO.getUserByUsername(username);
			
			if (playerDAO.isPlayerAlreadyInGame(game_id, user.getUserId())) {
				continue;
			}
			
			Integer count = gameDAO.getPlayerCountByGame(results.getString("game_code"));
			if (count == null || count <= 0 || count >= 6) {
				continue;
			}
			Invitation i = new Invitation();
			i.setGameCode(results.getString("game_code"));
			i.setInvitationId(results.getInt("invite_id"));
			i.setInvitedBy(results.getString("invited_by"));
			i.setInvitee(results.getString("invitee"));
			invitations.add(i);
		}
		return invitations;
	}
	
	@Override 
	public void deleteInvitation(String gameCode, String username) {
		String query = "DELETE FROM user_invite WHERE game_code = ? AND invitee = ?";
		template.update(query, gameCode, username);
	}
	
	@Override
	public boolean doesInvitationExist(String gameCode, String invitee) {
		String query = "SELECT * FROM user_invite WHERE game_code = ? AND invitee = ?";
		SqlRowSet result = template.queryForRowSet(query, gameCode, invitee);
		if (result.next()) return true;
		return false;
	}
	
	@Override
	public void addFriend(String username, String friendName) {
		if (doesFriendInquiryExist(username, friendName)) return;
		else if (doesFriendInquiryExist(friendName, username)) acceptFriendRequest(friendName, username);
		else {
			String query = "INSERT INTO friends (username, friend_name) VALUES (?, ?)";
			template.update(query, username, friendName);
		}
	}
	
	@Override
	public void acceptFriendRequest(String username, String friendName) {
		String query = "UPDATE friends SET friends = true WHERE username = ? AND friend_name = ?";
		template.update(query, username, friendName);
		
		if (!doesFriendInquiryExist(friendName, username)) {
			String query2 = "INSERT INTO friends (username, friend_name, friends) VALUES (?, ?, true)";
			template.update(query2, friendName, username);
		}
		
		String query3 = "UPDATE friends SET friends = true WHERE username = ? AND friend_name = ?";
		template.update(query3, friendName, username);
	}
	
	@Override
	public void cancelFriendRequest(String username, String friendName) {
		String query = "DELETE FROM friends WHERE username = ? AND friend_name = ? AND friends = false";
		template.update(query, username, friendName);
	}
	
	public void rejectFriendRequest(String username, String friendName) {
		String query = "DELETE FROM friends WHERE username = ? AND friend_name = ? AND friends = false";
		template.update(query, friendName, username);
	}
	
	@Override
	public void removeFriend(String username, String friendName) {
		String query = "DELETE FROM friends WHERE username = ? AND friend_name = ? AND friends = true";
		template.update(query, username, friendName);
		template.update(query, friendName, username);
	}
	
	private boolean doesInvitationExist(String gameCode, String invitee, String invitedBy) {
		String query = "SELECT * FROM user_invite WHERE game_code = ? AND invitee = ? AND invited_by = ?";
		SqlRowSet result = template.queryForRowSet(query, gameCode, invitee, invitedBy);
		if (result.next()) return true;
		return false;
	}
	
	private boolean doesFriendInquiryExist(String username, String friendName) {
		String query = "SELECT * FROM friends WHERE username = ? AND friend_name = ?";
		SqlRowSet result = template.queryForRowSet(query, username, friendName);
		if (result.next()) return true;
		else return false;
	}
	
	
}
