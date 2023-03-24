package com.proiectps.airport.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name= "User")
public class User {

    @Id
    @GeneratedValue( strategy= GenerationType.AUTO)
    private Long id;

    private String name;
    private String password;
    private Boolean admin;

    @OneToMany(/*cascade = CascadeType.ALL,fetch = FetchType.EAGER,*/ mappedBy="id" )
    private List<Ticket> ticketList;

}
