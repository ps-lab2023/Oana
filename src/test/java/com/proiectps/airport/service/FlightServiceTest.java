package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.FlightRepository;
import com.proiectps.airport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class FlightServiceTest {

    private static final String DESTINATIE = "CLUJ";
    private static final String DESTINATIE_NOT = "Nicio destinatie";
    private FlightServiceImpl flightService;

    @Mock
    private FlightRepository flightRepository;
    private Flight flight;

    private static final Airport airport=new Airport();
    private static final Airport airport_not=new Airport();
    @BeforeEach
    void init(){
        initMocks(this);
        flight=new Flight();
        flight.setDestination(DESTINATIE);
        flight.setAirport(airport);
        when(flightRepository.findByDestination(DESTINATIE)).thenReturn(flight);
        when(flightRepository.findByAirport(airport)).thenReturn(flight);


    }

    @Test
    void givenExistingAirport_whenFindByAirport_thenFindOne() {

        flightService = new FlightServiceImpl(flightRepository);

        Flight flight = flightService.findByAirport(airport);

        assertNotNull(flight);
        assertEquals(airport, flight.getAirport());
    }

    @Test
    void givenNonExistingAirport_whenFindByAirport_thenThrowException() {
        when(flightRepository.findByAirport(airport_not)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            flightService.findByAirport(airport_not);
        });

    }


    @Test
    void givenExistingDestination_whenFindByDestination_thenFindOne() {

        flightService = new FlightServiceImpl(flightRepository);

        Flight flight = flightService.findByDestination(DESTINATIE);

        assertNotNull(flight);
        assertEquals(DESTINATIE, flight.getDestination());
    }

    @Test
    void givenNonExistingDestination_whenFindByDestination_thenThrowException() {
        when(flightRepository.findByDestination(DESTINATIE_NOT)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            flightService.findByDestination(DESTINATIE_NOT);
        });

    }

}
