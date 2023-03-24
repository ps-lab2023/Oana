package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.User;
import org.hibernate.annotations.Comment;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public interface FlightService {

    ArrayList<Flight> findAllBYAirport(Airport airport);
    ArrayList<Flight> deleteAllBYAirport(Airport airport);


    Flight updateFlight(Flight flight);
    Flight findByAirport(Airport airport);
    Flight findByDestination(String destination);
}
