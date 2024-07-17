package com.example.kartgp.dao;

import com.example.kartgp.database.DbConnection;
import com.example.kartgp.database.Queries;
import com.example.kartgp.entity.Subscription;
import com.example.kartgp.entity.Tournament;
import com.example.kartgp.entity.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SubscriptionDao {

    private final Logger logger = Logger.getLogger(SubscriptionDao.class.getName());

    public void payAndSubscription(User login, Tournament tournament) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.DO_SUBSCRIPTION,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ) {
            stmt.setInt(1, login.getId());
            stmt.setInt(2, tournament.getId());
            stmt.setInt(3, 0);
            stmt.setString(4, login.getUsername());
            stmt.setString(5, tournament.getName());
            int result = stmt.executeUpdate();

            if (result == 1) {
                logger.info("Subscription done");
            } else {
                throw new SQLException("Subscription not created");
            }
        }
    }

    public List<Subscription> getTournamentSubscription(int id) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_TOURNAMENT_BY_SUBSCRIPTION,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new SQLException("Tournaments not found");
                }
                List<Subscription> subscriptions = new ArrayList<>();
                do {
                    subscriptions.add( new Subscription(
                    rs.getInt("user_id"),
                    rs.getInt("tournament_id"),
                    rs.getInt("points"),
                    rs.getString("driver"),
                    rs.getString("tournament")
                    ));
                }
                while (rs.next());
                return subscriptions;
            } catch (Exception e) {
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public List<Tournament> getAllSubscriptionsByUser(int id) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.GET_ALL_MY_SUBSCRIPTIONS,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
            stmt.setInt(1, id);
            try (ResultSet rs = stmt.executeQuery()) {
                if (!rs.first()) {
                    throw new SQLException("Tournaments not found");
                }
                List<Tournament> tournaments = new ArrayList<>();
                do{
                    tournaments.add( new Tournament(
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
                throw new SQLException(e);
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }

    public void updateSubscription(int point , int id, int tournamentId) throws SQLException {
        Connection conn = DbConnection.getConnection();
        try (
                PreparedStatement stmt = conn.prepareStatement(
                        Queries.UPDATE_VOTE,
                        ResultSet.TYPE_SCROLL_INSENSITIVE,
                        ResultSet.CONCUR_READ_ONLY
                )
        ){
            stmt.setInt(1, point);
            stmt.setInt(2, id);
            stmt.setInt(3, tournamentId);
            int affectedRows = stmt.executeUpdate();
            if (affectedRows > 0) {
                System.out.println("Record updated successfully.");
            } else {
                System.out.println("No record found with the provided ID.");
            }
        } catch (SQLException e) {
            throw new SQLException(e);
        }
    }
}
