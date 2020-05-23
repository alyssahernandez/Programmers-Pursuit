package com.sideprojects.trivialpursuit.model;

public interface UserDAO {

	public User getUserByToken(String token); // grabs user by token from db
	
	public void createUser(String username, String token, String email, String picture); // Creates user if not in db by storing the token.

	public boolean validateUsername(String username);
	
}
