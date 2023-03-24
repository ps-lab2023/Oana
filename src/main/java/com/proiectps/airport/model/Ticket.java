package com.proiectps.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Ticket {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private Long id;


    private int price;

    @ManyToOne(/* cascade = CascadeType.ALL, fetch = FetchType.EAGER*/)
    private User owner;

    @ManyToOne(/* cascade = CascadeType.ALL, fetch = FetchType.EAGER*/)
    private Flight flight;
}
