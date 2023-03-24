package com.proiectps.airport.service;

import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.Ticket;
import com.proiectps.airport.model.User;
import org.springframework.stereotype.Component;

@Component
public interface TicketService {
    Ticket updateTicketOwner(Ticket ticket);
    Ticket updateTicketPrice(Ticket ticket);
    Ticket findByOwner(User owner);
    Ticket findByFlight(Flight flight);
}
