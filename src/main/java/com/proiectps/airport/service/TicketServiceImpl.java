package com.proiectps.airport.service;

import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.Ticket;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.TicketRepository;
import com.proiectps.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TicketServiceImpl implements TicketService{

    @Autowired
    private TicketRepository ticketRepository;

    public TicketServiceImpl(TicketRepository ticketRepository)
    {
        this.ticketRepository=ticketRepository;
    }

    @Override
    public Ticket findByOwner(User owner)
    {
        return ticketRepository.findByOwner(owner);
    }

    @Override
    public Ticket findByFlight(Flight flight)
    {
        return ticketRepository.findByFlight(flight);
    }

    @Override
    public Ticket updateTicketOwner(Ticket ticket) {
        Ticket updateTicket = ticketRepository.findById(ticket.getId()).get();
        if(updateTicket.getOwner().getAdmin())
            updateTicket.setOwner(ticket.getOwner());
        ticketRepository.save(updateTicket);
        return updateTicket;
    }

    @Override
    public Ticket updateTicketPrice(Ticket ticket) {
        Ticket updateTicket = ticketRepository.findById(ticket.getId()).get();
        if(updateTicket.getOwner().getAdmin())
            updateTicket.setPrice(ticket.getPrice());
        ticketRepository.save(updateTicket);
        return updateTicket;
    }
}
