package com.example.kartgp.dao;

import com.example.kartgp.database.DbConnection;
import com.example.kartgp.entity.LeadBoard;
import com.example.kartgp.database.Queries;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class LeadBoardDao {

    public List<LeadBoard> getLeadboard() throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_LEADBOARD,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
             ResultSet rs = stmt.executeQuery();
                if (!rs.first()) {
                    throw new SQLException("Tournaments not found");
                }
                List<LeadBoard> leadbords = new ArrayList<>();
                do{
                    leadbords.add(new LeadBoard(
                    rs.getString("driver"),
                    rs.getInt("numberRace"),
                    rs.getInt("totalPoints")
                    ));
                }
                while (rs.next());
                return leadbords;


        } catch (SQLException e) {
            throw new IllegalArgumentException(e);
        }
    }
}
