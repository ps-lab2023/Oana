package com.proiectps.airport.service;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.User;
import org.springframework.stereotype.Component;

@Component
public interface AirportService {

    Airport findByName(String name);
}
