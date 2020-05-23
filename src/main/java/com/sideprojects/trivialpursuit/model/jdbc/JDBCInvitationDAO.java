package com.sideprojects.trivialpursuit.model.jdbc;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.CategoryDAO;
import com.sideprojects.trivialpursuit.model.GameDAO;
import com.sideprojects.trivialpursuit.model.Invitation;
import com.sideprojects.trivialpursuit.model.InvitationDAO;
import com.sideprojects.trivialpursuit.model.PlayerDAO;
import com.sideprojects.trivialpursuit.model.User;

@Component
public class JDBCInvitationDAO implements InvitationDAO {

	private JdbcTemplate template;
	private PlayerDAO playerDAO;
	private GameDAO gameDAO;

	@Autowired
	public JDBCInvitationDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		playerDAO = new JDBCPlayerDAO(dataSource);
		gameDAO = new JDBCGameDAO(dataSource);
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
			User user = playerDAO.getUserByUsername(username);
			
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
	
	private boolean doesInvitationExist(String gameCode, String invitee, String invitedBy) {
		String query = "SELECT * FROM user_invite WHERE game_code = ? AND invitee = ? AND invited_by = ?";
		SqlRowSet result = template.queryForRowSet(query, gameCode, invitee, invitedBy);
		if (result.next()) return true;
		return false;
	}
}
