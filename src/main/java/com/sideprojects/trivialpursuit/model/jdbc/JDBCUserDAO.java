package com.sideprojects.trivialpursuit.model.jdbc;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.sideprojects.trivialpursuit.model.UserDAO;


@Component
public class JDBCUserDAO implements UserDAO {

	private JdbcTemplate template;
	
	@Autowired
	public JDBCUserDAO(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
	}
	
	
	@Override
	public String getUserByToken(String token) {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void createUser(String token) {
		// TODO Auto-generated method stub
		
	}

}
