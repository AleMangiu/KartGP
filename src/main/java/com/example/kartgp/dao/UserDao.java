package com.example.kartgp.dao;

import com.example.kartgp.database.DbConnection;
import com.example.kartgp.database.Queries;
import com.example.kartgp.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Logger;

public class UserDao {

    private final Logger logger = Logger.getLogger(UserDao.class.getName());

    public User login(String username, String password) throws Exception {

        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_USER,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ) {
            stmt.setString(1, username);
            stmt.setString(2, password);

            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("User not found");
                }
                rs.first();
                int id = rs.getInt("id");
                String username1 = rs.getString("username");
                String role = rs.getString("role");

                return new User(id, username1, role);
            }
        }
    }

    public void signing(String username, String password, String role) throws Exception {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.CREATE_USER,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
            stmt.setString(1, username);
            stmt.setString(2, password);
            stmt.setString(3, role);

            int result = stmt.executeUpdate();

            if (result == 1) {
                logger.info("User created");
            } else {
                throw new Exception("User not created");
            }
        }
    }

}
