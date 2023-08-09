package com.example.zoeparrishcustomersupport.site;


import java.util.List;

public interface TicketService {

    List<Ticket> getAllTickets();
    Ticket getTicket(long id);
    void save(Ticket ticket);
    void deleteTicket(long id);

}
