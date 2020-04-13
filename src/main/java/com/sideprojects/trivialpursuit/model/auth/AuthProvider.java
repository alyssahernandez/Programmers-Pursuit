package com.sideprojects.trivialpursuit.model.auth;


public interface AuthProvider {
    /**
     * Returns true if a current user is logged in.
     * @return true if user is logged in
     */
    boolean isLoggedIn();

    /**
     * Returns the currently signed in user.
     * @return the currently signed in user
     */
    User getCurrentUser();

    /**
     * Signs in a user using the given username and password
     * @param username the given username
     * @param password the given password
     * @return true if user was successfully signed in
     */
    boolean signIn(String username, String password);

    /**
     * Sign out the currently signed in user
     */
    void logOff();

    /**
     * Change the current signed in user's password.
     * @param existingPassword the current user's current password
     * @param newPassword the new password for the current user
     * @return true, if successful
     */
    boolean changePassword(String existingPassword, String newPassword);

    /**
     * Register a new user to the system
     * @param username the new user's username
     * @param password the new user's password
     * @param role the new user's role
     */
    void register(String username, String password);

    /**
     * Checks to see if the current user has one of the given roles
     * @param roles the roles to check for
     * @return true, if the user has one of the roles
     */
    
}
