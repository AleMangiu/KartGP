package com.example.kartgp.entity;

public class Subscription {
    private int pointEntity;
    private String driverEntity;
    private String tournamentEntity;
    private int idDriverEntity;
    private int idTournamentEntity;

    public Subscription(int idDriverEntity, int idTournamentEntity, int pointEntity, String driverEntity, String tournamentEntity) {
        this.pointEntity = pointEntity;
        this.idDriverEntity = idDriverEntity;
        this.idTournamentEntity = idTournamentEntity;
        this.driverEntity = driverEntity;
        this.tournamentEntity = tournamentEntity;
    }

    public int getPointEntity() {
        return pointEntity;
    }

    public void setPointEntity(int pointEntity) {
        this.pointEntity = pointEntity;
    }

    public int getIdDriverEntity() {
        return idDriverEntity;
    }

    public void setIdDriverEntity(int idDriverEntity) {
        this.idDriverEntity = idDriverEntity;
    }

    public int getIdTournamentEntity() {
        return idTournamentEntity;
    }

    public void setIdTournamentEntity(int idTournamentEntity) {
        this.idTournamentEntity = idTournamentEntity;
    }

    public String getDriverEntity() {
        return driverEntity;
    }

    public void setDriverEntity(String driverEntity) {
        this.driverEntity = driverEntity;
    }

    public String getTournamentEntity() {
        return tournamentEntity;
    }

    public void setTournamentEntity(String tournamentEntity) {
        this.tournamentEntity = tournamentEntity;
    }
}
