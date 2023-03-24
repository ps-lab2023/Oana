package com.proiectps.airport.repository;

import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.Ticket;
import com.proiectps.airport.model.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends CrudRepository<Ticket,Long> {
    Ticket findByOwner(User owner);
    Ticket findByFlight(Flight flight);
}
