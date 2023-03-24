package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.AirportRepository;
import com.proiectps.airport.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AirportServiceImpl implements AirportService {

    @Autowired
    private AirportRepository airportRepository;

    public AirportServiceImpl(AirportRepository airportRepository)
    {
        this.airportRepository=airportRepository;
    }

    @Override
    public Airport findByName(String name)
    {
        return airportRepository.findByName(name);
    }
}
