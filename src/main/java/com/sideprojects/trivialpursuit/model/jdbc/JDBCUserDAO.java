package com.sideprojects.trivialpursuit.model.jdbc;

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
		User user = new User();
		String userQuery = "SELECT * FROM user_account WHERE id_token = ?";
		SqlRowSet result = template.queryForRowSet(userQuery, token); 
		
		if(result.next()) {
			user.setUserId(result.getInt("user_id"));
			user.setUsername(result.getString("username"));
			user.setIdToken(result.getString("id_token"));
		} else {
			return null;
		}
		return user;
	}
	

	@Override
	public void createUser(String username, String token) {
		String newUserSQL = "INSERT INTO user_account (username, id_token) VALUES (?, ?)";
		template.update(newUserSQL, username, token);
	}

}