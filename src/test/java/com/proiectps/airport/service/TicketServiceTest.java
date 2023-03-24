package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.Ticket;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.TicketRepository;
import com.proiectps.airport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class TicketServiceTest {

    @Mock
    private TicketRepository ticketRepository;
    private Ticket ticket;
    private static final User owner=new User();
    private static final int PRICE=10;
    private static final int PRICE_NOR=-10;
    private static final User owner_not=new User();
    private static final Flight flight_not=new Flight();
    private static final Flight flight=new Flight();

    private TicketServiceImpl ticketService;

    @BeforeEach
    void init(){
        initMocks(this);
        ticket=new Ticket();
        ticket.setOwner(owner);
        ticket.setPrice(PRICE);
        ticket.setFlight(flight);
        when(ticketRepository.findByOwner(owner)).thenReturn(ticket);
        when(ticketRepository.findByFlight(flight)).thenReturn(ticket);
    }
    @Test
    void givenExistingOwner_whenFindByTicket_thenFindOne() {

        ticketService = new TicketServiceImpl(ticketRepository);

        Ticket ticket = ticketService.findByOwner(owner);

        assertNotNull(ticket);
        assertEquals(owner, ticket.getOwner());
    }

    @Test
    void givenNonExistingOwner_whenFindByTicket_thenThrowException() {
        when(ticketRepository.findByOwner(owner_not)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            ticketService.findByOwner(owner_not);
        });

    }

}
