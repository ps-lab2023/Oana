package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.AirportRepository;
import com.proiectps.airport.repository.UserRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

public class AirportServiceTest {

    private static final String NUME = "Oana";
    private static final String NUME_NOT = "Numele care nu exista";

    private AirportServiceImpl airportService;

    @Mock
    private AirportRepository airportRepository;
    private Airport airport;

    @BeforeEach
    void init(){
        initMocks(this);
        airport=new Airport();
        airport.setName(NUME);
        when(airportRepository.findByName(NUME)).thenReturn(airport);
    }


    @Test
    void givenExistingName_whenFindByName_thenFindOne() {

        airportService = new AirportServiceImpl(airportRepository);

        Airport airport = airportService.findByName(NUME);

        assertNotNull(airport);
        assertEquals(NUME, airport.getName());
    }

    @Test
    void givenNonExistingName_whenFindByName_thenThrowException() {
        when(airportRepository.findByName(NUME_NOT)).thenReturn(null);

        Exception exception = assertThrows(NullPointerException.class, () -> {
            airportService.findByName(NUME_NOT);
        });

    }
}
