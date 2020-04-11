package com.sideprojects.trivialpursuit.model.auth;

import java.util.List;

public interface UserDao 
{
    public User saveUser(String userName, String password);
    
    public User getUser(String userName, String password);

    public boolean isUsernameAndPasswordValid(String userName, String password);

    public List<User> getAllUsers();
}
