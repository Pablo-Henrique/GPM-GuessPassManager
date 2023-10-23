package com.happysy.gpc.model;

import java.io.Serial;
import java.io.Serializable;


public class TicketPass implements Serializable {
    @Serial
    private static final long serialVersionUID = 6655919997150808155L;

    private Integer id;

    private String pass;

    private String sector;

    private String hours;

    private String date;

    public TicketPass(Integer id, String pass, String sector, String hours, String date) {
        this.id = id;
        this.pass = pass;
        this.sector = sector;
        this.hours = hours;
        this.date = date;
    }

    public TicketPass() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public String getHours() {
        return hours;
    }

    public void setHours(String hours) {
        this.hours = hours;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
