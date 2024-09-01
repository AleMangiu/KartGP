package com.example.kartgp.controller_app;

import com.example.kartgp.bean.MyTournament;
import com.example.kartgp.bean.SubscriptionBean;
import com.example.kartgp.bean.TournamentBean;
import com.example.kartgp.bean.UserBean;
import com.example.kartgp.bean.ReceiptBean;
import com.example.kartgp.dao.ReceiptDAO;
import com.example.kartgp.dao.ReceiptDAOFactorySingleton;
import com.example.kartgp.dao.SubscriptionDao;
import com.example.kartgp.entity.Receipt;
import com.example.kartgp.entity.Subscription;
import com.example.kartgp.entity.Tournament;
import com.example.kartgp.entity.User;
import com.example.kartgp.exception.DuplicateReceiptException;
import com.example.kartgp.exception.ReceiptNotFoundException;
import com.opencsv.exceptions.CsvValidationException;

import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

public class SubscriptionControllerApp {

    private SubscriptionControllerApp() {
        throw new IllegalStateException("Utility class");
    }

    public static void payAndSubscription(UserBean userBean, TournamentBean tournamentBean) throws SQLException {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        User user = new User(userBean.getId(), userBean.getUsername());
        Tournament tournament = new Tournament(tournamentBean.getId(), tournamentBean.getName());
        subscriptionDao.payAndSubscription(user, tournament);
        Logger logger = Logger.getLogger(SubscriptionControllerApp.class.getName());
        logger.info("You have subscription and pay");
    }

    public static List<SubscriptionBean> getTournamentSubscription(int id) throws SQLException {
        SubscriptionDao subscriptionDao = new SubscriptionDao();
        List<SubscriptionBean> subscriptionBeans = new ArrayList<>();
        var subscriptionList = subscriptionDao.getTournamentSubscription(id);
        for (Subscription subscription : subscriptionList) {
            var driver = subscription.getDriverEntity();
            var tournament = subscription.getTournamentEntity();
            var driverId = subscription.getIdDriverEntity();
            var tournamentId = subscription.getIdTournamentEntity();
            var vote = subscription.getPointEntity();
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

    public static void createReceipt(ReceiptBean receiptBean) throws IOException, SQLException, CsvValidationException, ReceiptNotFoundException, DuplicateReceiptException {

        Receipt receipt = new Receipt(LocalDate.now(), receiptBean.getIdDriver(), receiptBean.getIdTournament());

        ReceiptDAOFactorySingleton receiptDAOFactory = ReceiptDAOFactorySingleton.getInstance();
        ReceiptDAO receiptDAO = receiptDAOFactory.createReceiptDAO();
        receiptDAO.createReceipt(receipt);
    }
}
