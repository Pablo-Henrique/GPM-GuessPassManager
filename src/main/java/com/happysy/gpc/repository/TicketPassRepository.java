package com.happysy.gpc.repository;

import com.happysy.gpc.model.TicketPass;

import java.util.List;

public interface TicketPassRepository {
    TicketPass insert(TicketPass ticket);
    boolean update(TicketPass ticket);
    boolean updateById(Integer ticketID);
    boolean updatePassById(Integer ticketID, String newPass);
    TicketPass remove(TicketPass ticket);
    List<TicketPass> findAll();
    TicketPass findTicketPassById(Integer ticketById);
    String findPassById(Integer ticketById);
}

