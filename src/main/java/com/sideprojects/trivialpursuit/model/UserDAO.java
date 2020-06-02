package com.sideprojects.trivialpursuit.model;

import java.util.List;

public interface UserDAO {

	public User getUserByToken(String token); // grabs user by token from db
	
	public void createUser(String username, String token, String email, String picture); // Creates user if not in db by storing the token.

	public boolean validateUsername(String username);
	
	public User getUserByUsername(String username);
	
	public List<User> getAllTimeLeaders();
	
	public List<User> getMonthlyLeaders();
	
	public List<User> getWeeklyLeaders();
	
	public List<User> getDailyLeaders();
}
