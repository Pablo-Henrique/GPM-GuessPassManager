package com.happysy.gpc.repository;

import com.happysy.gpc.model.TicketPass;

public interface TicketPassRepository {
    boolean insert(TicketPass o);
    boolean update(Object o);
    boolean remove(Object o);
    boolean find(Object o);
}

