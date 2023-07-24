package com.happysy.gpc.model;

public class TicketPass {

    private Long id;
    private String pass;
    private String sector;
    private String hours;
    private String date;

    public TicketPass(Long id, String pass, String sector, String hours, String date) {
        this.id = id;
        this.pass = pass;
        this.sector = sector;
        this.hours = hours;
        this.date = date;
    }

    public TicketPass() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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
