package com.example.kartgp.bean;

import java.time.LocalDate;

public class TournamentBean {

    //region properties

    private Integer id;
    private String name;
    private String location;
    private Integer number;
    private Integer cost;
    private LocalDate date;

    //endregion

    //region constructor
    public TournamentBean() {}

    public TournamentBean(int id, String name, String where, Integer number, Integer cost, LocalDate date) {
        this.id = id;
        this.name = name;
        this.location = where;
        this.number = number;
        this.cost = cost;
        this.date = date;
    }

    public TournamentBean(int id, String name) {
        this.id = id;
        this.name = name;
    }
    //endregion

    //region getter setter

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String where) {
        this.location = where;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(int cost) {
        this.cost = cost;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    //endregion

    //region methods
    public void checkField(String name, String where, LocalDate date, Integer cost, Integer number) throws IllegalArgumentException{
        if (name.isEmpty() || where.isEmpty() || date == null || cost == null || number == null) {
            throw new IllegalArgumentException("Please fill all the fields");
        }
    }
    //endregion
}
