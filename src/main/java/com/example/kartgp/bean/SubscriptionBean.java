package com.example.kartgp.bean;

public class SubscriptionBean {
    private int point;
    private String driver;
    private String tournament;
    private int idDriver;
    private int idTournament;

    public SubscriptionBean(int idDriver, int idTournament, int point, String driver, String tournament) {
        this.point = point;
        this.idDriver = idDriver;
        this.idTournament = idTournament;
        this.driver = driver;
        this.tournament = tournament;
    }

    public int getPoint() {
        return point;
    }

    public void setPoint(int point) {
        this.point = point;
    }

    public int getIdDriver() {
        return idDriver;
    }

    public void setIdDriver(int idDriver) {
        this.idDriver = idDriver;
    }

    public int getIdTournament() {
        return idTournament;
    }

    public void setIdTournament(int idTournament) {
        this.idTournament = idTournament;
    }

    public String getDriver() {
        return driver;
    }

    public void setDriver(String driver) {
        this.driver = driver;
    }

    public String getTournament() {
        return tournament;
    }

    public void setTournament(String tournament) {
        this.tournament = tournament;
    }
}
