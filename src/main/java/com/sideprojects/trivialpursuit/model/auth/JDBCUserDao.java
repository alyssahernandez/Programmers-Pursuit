package com.sideprojects.trivialpursuit.model.auth;

import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import org.bouncycastle.util.encoders.Base64;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Component;

@Component
public class JDBCUserDao  {

    private JdbcTemplate jdbcTemplate;
   

    @Autowired
    public JDBCUserDao(DataSource dataSource) {
        this.jdbcTemplate = new JdbcTemplate(dataSource);
        
    }

    

    

   
    public User getValidUserWithPassword(String userName, String password) {
        return null;
    }

  
    public List<User> getAllUsers() {
        List<User> users = new ArrayList<User>();
        String sqlSelectAllUsers = "SELECT id, username, role FROM users";
        SqlRowSet results = jdbcTemplate.queryForRowSet(sqlSelectAllUsers);

        while (results.next()) {
            User user = mapResultToUser(results);
            users.add(user);
        }

        return users;
    }

    private User mapResultToUser(SqlRowSet results) {
        User user = new User();
        user.setId(results.getLong("id"));
        user.setUsername(results.getString("username"));

        return user;
    }
    
}
