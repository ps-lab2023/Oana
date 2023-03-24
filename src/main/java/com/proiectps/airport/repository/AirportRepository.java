package com.proiectps.airport.repository;

import com.proiectps.airport.model.Airport;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends CrudRepository<Airport,Long> {
    Airport findByName(String name);
}
