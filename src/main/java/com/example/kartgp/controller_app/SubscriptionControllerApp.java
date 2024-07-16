package com.example.kartgp.controller_app;

import com.example.kartgp.bean.MyTournament;
import com.example.kartgp.bean.SubscriptionBean;
import com.example.kartgp.bean.TournamentBean;
import com.example.kartgp.bean.UserBean;
import com.example.kartgp.dao.SubscriptionDao;
import com.example.kartgp.entity.Subscription;
import com.example.kartgp.entity.Tournament;
import com.example.kartgp.entity.User;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SubscriptionControllerApp {

    public static void payAndSubscription(UserBean userBean, TournamentBean tournamentBean) throws Exception {
        try {
            SubscriptionDao subscriptionDao = new SubscriptionDao();
            User user = new User(userBean.getId(), userBean.getUsername());
            Tournament tournament = new Tournament(tournamentBean.getId(), tournamentBean.getName());
            subscriptionDao.payAndSubscription(user, tournament);

            System.out.print("You have subscription and pay");
        } catch (Exception e) {
            throw e;
        }
    }

    public static List<SubscriptionBean> getTournamentSubscription(int id) throws SQLException {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        List<SubscriptionBean> subscriptionBeans = new ArrayList<>();
        var subscriptionList = subscriptionDao.getTournamentSubscription(id);
        for (Subscription subscription : subscriptionList) {
            var driver = subscription.getDriver();
            var tournament = subscription.getTournament();
            var driverId = subscription.getIdDriver();
            var tournamentId = subscription.getIdTournament();
            var vote = subscription.getPoint();
            SubscriptionBean subscriptionBean = new SubscriptionBean(driverId, tournamentId, vote, driver,tournament);
            subscriptionBeans.add(subscriptionBean);
        }
        return subscriptionBeans;
    }

    public static List<MyTournament> getAllSubscriptionsByUser(int id) throws SQLException {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        var tournamentList = subscriptionDao.getAllSubscriptionsByUser(id);
        List<MyTournament> tournamentBeans = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            var id1 = tournament.getId();
            var name = tournament.getName();
            var location = tournament.getLocation();
            var number = tournament.getNumber();
            var cost = tournament.getCost();
            var date = tournament.getDate();
            MyTournament tournamentBean = new MyTournament(id1, name, location, date, cost);
            tournamentBeans.add(tournamentBean);
        }
        return tournamentBeans;
    }

    public static void updateSubscription(int point, int id, int tournamentId) throws SQLException {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        subscriptionDao.updateSubscription(point, id, tournamentId);
    }
}
