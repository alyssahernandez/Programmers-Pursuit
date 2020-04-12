package com.sideprojects.trivialpursuit.model.auth;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;

public class JDBCUserDao implements UserDao
{
    private JdbcTemplate jdbcTemplate;
    private PasswordHasher passwordHasher;

    public JDBCUserDao(DataSource dataSource, PasswordHasher passwordHasher) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        this.passwordHasher = passwordHasher;
    }

    //TODO: Combine this with player? Already wrote the INSERT -- no need to make a "User" class, I don't think.
    @Override
    public User saveUser(String userName, String password) {
        byte[] salt = passwordHasher.generateRandomSalt();
        String hashedPassword = passwordHasher.computeHash(password, salt);
        String saltString = new String(Base64.encode(salt));
        long newId = jdbcTemplate.queryForObject(
                "INSERT INTO player (name, password_hash, salt) VALUES (?, ?, ?) RETURNING user_id", Long.class, userName,
                hashedPassword, saltString);

        User newUser = new User();
        newUser.setId(newId);
        newUser.setUsername(userName);

        return newUser;
    }

    @Override
    public boolean isUsernameAndPasswordValid(String userName, String password) {
        String sqlSearchForUser = "SELECT * FROM player WHERE UPPER(name) = '" + userName.toUpperCase() + "'";

        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSearchForUser);
        if (results.next()) {
            String storedSalt = results.getString("salt");
            String storedPassword = results.getString("password");
            String hashedPassword = passwordHasher.computeHash(password, Base64.decode(storedSalt));
            return storedPassword.equals(hashedPassword);
        } else {
            return false;
        }
    }

    // TODO: Assuming we do combine this with Player, this would be getAllPlayers(), which we already have.
    @Override
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sqlSelectAllUsers = "SELECT id, name FROM player";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

        while (results.next()) {
            User user = new User();
            user.setId(results.getLong("player_id"));
            user.setUsername(results.getString("name"));
            users.add(user);
        }

        return users;
    }

	@Override
	public User getUser(String userName, String password) {
		return null;
	}

}
