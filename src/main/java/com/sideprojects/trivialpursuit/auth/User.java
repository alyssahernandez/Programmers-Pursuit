package com.sideprojects.trivialpursuit.auth;

public class User 
{
	// TODO: Combine this with Player?  
    private long id;
    private String username;

    public String getUsername() { return username; }
    public void setUsername(String username) {  this.username = username; }
    
    public long getId() {  return id; }
    public void setId(long id) { this.id = id; }

}
