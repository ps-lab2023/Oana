package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.FlightRepository;
import com.proiectps.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FlightServiceImpl implements FlightService{

    @Autowired
    private FlightRepository flightRepository;


    public FlightServiceImpl(FlightRepository flightRepository)
    {
        this.flightRepository=flightRepository;
    }


    @Override
    public Flight findByDestination(String destination)
    {
        return flightRepository.findByDestination(destination);
    }

    @Override
    public Flight findByAirport( Airport airport)
    {
        return flightRepository.findByAirport(airport);
    }

    @Override
    public ArrayList<Flight> findAllBYAirport(Airport airport) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for(Flight flight : flightRepository.findAll()) {
            if(flight.getAirport().getId()== airport.getId()) {
                toReturn.add(flight);
            }
        }
        return toReturn;
    }


    @Override
    public ArrayList<Flight> deleteAllBYAirport(Airport airport) {
        ArrayList<Flight> toReturn = new ArrayList<Flight>();
        for(Flight flight : flightRepository.findAll()) {
            if(flight.getAirport().getId()== airport.getId()) {
                flightRepository.deleteById(flight.getId());
            }
            else toReturn.add(flight);
        }
        return toReturn;
    }


    @Override
    public Flight updateFlight(Flight flight) {
        Flight updateFlight = flightRepository.findById(flight.getId()).get();
        updateFlight.setAvailableSeats(flight.getAvailableSeats());
        flightRepository.save(updateFlight);
        return updateFlight;
    }
}
