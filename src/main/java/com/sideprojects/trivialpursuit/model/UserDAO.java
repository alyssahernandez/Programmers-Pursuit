package com.sideprojects.trivialpursuit.model;

public interface UserDAO {

	public String getUserByToken(String token); // Checks db for valid user.
	
	public void createUser(String token); // Creates user if not in db by storing the token.
	
}
