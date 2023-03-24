package com.proiectps.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Builder
public class Flight {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private Long id;

    private String destination;
    private String planeCode;

    private int availableSeats;

    //data, ora, durata
    @ManyToOne(/* cascade = CascadeType.ALL, fetch = FetchType.EAGER*/)
    private Airport airport;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.EAGER, mappedBy="id" )
    private List<Ticket> ticketList;


}
