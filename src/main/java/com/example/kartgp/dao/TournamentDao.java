package com.example.kartgp.dao;

import com.example.kartgp.database.DbConnection;
import com.example.kartgp.database.Queries;
import com.example.kartgp.entity.Tournament;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class TournamentDao {

    private final Logger logger = Logger.getLogger(TournamentDao.class.getName());

    public void createTournament(Tournament tournament, int userId) throws SQLException, Exception {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.CREATE_TOURNAMENT,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ) {
            stmt.setString(1, tournament.getName());
            stmt.setString(2, tournament.getLocation());
            stmt.setInt(3, tournament.getNumber());
            stmt.setInt(4, tournament.getCost());
            stmt.setDate(5, Date.valueOf(tournament.getDate()));
            stmt.setString(6, tournament.getCreatorName());
            stmt.setInt(7, userId);
            int result = stmt.executeUpdate();

            if (result == 1) {
                logger.info("Tournament created");
            } else {
                throw new Exception("Tournament not created");
            }
        }
    }

    public List<Tournament> getAllByAdminIdTournaments(int id) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_ALL_TOURNAMENTS_BY_ADMIN_ID,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )

        ){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Tournament> tournaments = new ArrayList<>();
                do {
                    tournaments.add(new Tournament(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("location"),
                            rs.getInt("number"),
                            rs.getInt("cost"),
                            rs.getDate("date").toLocalDate(),
                            rs.getString("creatorName")
                    ));
                }
                while (rs.next());
                return tournaments;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }

    public List<Tournament> getAllTournaments() throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.FIND_ALL_TOURNAMENTS,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new Exception("Tournaments not found");
                }
                List<Tournament> tournaments = new ArrayList<>();
                do {
                    tournaments.add(new Tournament(
                            rs.getInt("id"),
                            rs.getString("name"),
                            rs.getString("location"),
                            rs.getInt("number"),
                            rs.getInt("cost"),
                            rs.getDate("date").toLocalDate(),
                            rs.getString("creatorName")
                    ));
                }
                while (rs.next());
                return tournaments;
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }
    }
}
