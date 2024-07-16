package com.example.kartgp.pattern;

import com.example.kartgp.bean.TournamentBean;
import com.example.kartgp.bean.UserBean;
import com.example.kartgp.controller_app.TournamentControllerApp;
import com.example.kartgp.entity.Tournament;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

public class TournamentBCETest {
    @Test
    void TournamnetBCETest() throws Exception {
        assertDoesNotThrow(() -> {
            UserBean userBean = new UserBean(5, "testUsername", "Admin");
            TournamentBean tournamentBean = new TournamentBean(0, "torneoTest", "locationTest", 20, 25, LocalDate.now());
            TournamentControllerApp.createTournament(userBean, tournamentBean);
        },"Creating TournamentControllerApp should not throw any exception");
    }
}
