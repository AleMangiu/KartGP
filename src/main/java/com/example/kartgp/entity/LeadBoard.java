package com.example.kartgp.entity;

public class LeadBoard {
    private String driverEntity;
    private int numberRaceEntity;
    private int totalPointEntity;

    public LeadBoard(String driverEntity, int numberRaceEntity, int totalPointEntity) {
        this.driverEntity = driverEntity;
        this.numberRaceEntity = numberRaceEntity;
        this.totalPointEntity = totalPointEntity;
    }

    public String getDriverEntity() {
        return driverEntity;
    }

    public void setDriverEntity(String driverEntity) {
        this.driverEntity = driverEntity;
    }

    public int getNumberRaceEntity() {
        return numberRaceEntity;
    }

    public void setNumberRaceEntity(int numberRaceEntity) {
        this.numberRaceEntity = numberRaceEntity;
    }

    public int getTotalPointEntity() {
        return totalPointEntity;
    }

    public void setTotalPointEntity(int totalPointEntity) {
        this.totalPointEntity = totalPointEntity;
    }
}
