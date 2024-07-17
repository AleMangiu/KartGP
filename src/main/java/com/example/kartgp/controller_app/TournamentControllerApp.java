package com.example.kartgp.controller_app;

import com.example.kartgp.bean.TournamentBean;
import com.example.kartgp.bean.UserBean;
import com.example.kartgp.bean.MyTournament;
import com.example.kartgp.dao.TournamentDao;
import com.example.kartgp.entity.Tournament;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TournamentControllerApp {

    private TournamentControllerApp() {
        throw new IllegalStateException("Utility class");
    }

    public static void createTournament(UserBean user, TournamentBean tournamentBean) throws SQLException {
        TournamentDao tournamentDao = new TournamentDao();
        Tournament entity = new Tournament(tournamentBean.getName(), tournamentBean.getLocation(), tournamentBean.getNumber(), tournamentBean.getCost(), tournamentBean.getDate(), user.getUsername());
        tournamentDao.createTournament(entity, user.getId());
    }

    public static List<MyTournament> getAllByAdminIdTournaments(Integer id) throws SQLException {
        TournamentDao tournamentDao = new TournamentDao();
        List<Tournament> tournamentList = tournamentDao.getAllByAdminIdTournaments(id);
        List<MyTournament> tournamentBeans = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            var tournamentId = tournament.getId();
            var name = tournament.getName();
            var location = tournament.getLocation();
            var date = tournament.getDate();
            MyTournament tournamentBean = new MyTournament(tournamentId, name, location, date);
            tournamentBeans.add(tournamentBean);
        }
        return tournamentBeans;
    }

    public static List<MyTournament> getAllTournaments() throws ExceptionInInitializerError, SQLException {
        TournamentDao tournamentDao = new TournamentDao();
        List<Tournament> tournamentList = tournamentDao.getAllTournaments();
        List<MyTournament> tournamentBeans = new ArrayList<>();
        for (Tournament tournament : tournamentList) {
            var id = tournament.getId();
            var name = tournament.getName();
            var location = tournament.getLocation();
            var cost = tournament.getCost();
            var date = tournament.getDate();
            MyTournament tournamentBean = new MyTournament(id, name, location, date, cost);
            tournamentBeans.add(tournamentBean);
        }
        return tournamentBeans;
    }
}
