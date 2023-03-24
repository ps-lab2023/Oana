package com.proiectps.airport;

import com.proiectps.airport.model.Airport;
import com.proiectps.airport.model.Flight;
import com.proiectps.airport.model.Ticket;
import com.proiectps.airport.model.User;
import com.proiectps.airport.repository.AirportRepository;
import com.proiectps.airport.repository.FlightRepository;
import com.proiectps.airport.repository.TicketRepository;
import com.proiectps.airport.repository.UserRepository;
import com.proiectps.airport.service.AirportService;
import com.proiectps.airport.service.FlightService;
import com.proiectps.airport.service.UserService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.ArrayList;

@EntityScan
@EnableJpaRepositories
@SpringBootApplication
public class AirportApplication {

	public static void main(String[] args) {
		SpringApplication.run(AirportApplication.class, args);
	}

	@Bean
	CommandLineRunner init(FlightRepository flightRepository, UserRepository userRepository, TicketRepository ticketRepository, AirportRepository airportRepository, UserService userService, FlightService flightService, AirportService airportService) {
		return args -> {
			User user=new User();
			user.setName("User1");
			user.setAdmin(false);
			user.setPassword("pass");

			userRepository.save(user);

			user.setName("Oana");
			user.setAdmin(true);

			user= userService.updateUser(user);


			if(userService.logIn("Oana","pass")!=0)
				System.out.println("V-ati conectat. Utilizatorul #" +userService.logIn("Oana","pass")  );
			else	System.out.println("Nu exista niciun utilizator cu aceste date");

			if(userRepository.findById(userService.logIn("Oana","pass")).get().getAdmin())
				System.out.println("Utilizatorul este admin" );
			else
				System.out.println("Utilizatorul nu este admin" );

			//System.out.println(userService.findByName("Oana").getName());
			//System.out.println(userRepository.findById((long)1).get().getName());

			User user2=new User();
			user2.setName("Mintas");
			user2.setAdmin(true);
			userRepository.save(user2);

			User user3=new User();
			user3.setName("Alex");
			user3.setAdmin(true);
			userRepository.save(user3);

			User user4=new User();
			user4.setName("Alex");

			userService.deleteByNameUser(user4);

			User user5=new User();
			user5.setName("Andrei");
			user5.setAdmin(true);
			userRepository.save(user5);

			Airport airport= new Airport();
			airport.setName("Airport1");

			airportRepository.save(airport);

			Airport airport2= new Airport();
			airport.setName("Airport2");

			airportRepository.save(airport2);

			Airport airport1= new Airport();
			airport.setName("Airport1");

			airportRepository.save(airport1);

			Airport airport3= new Airport();
			airport3.setName("Otopeni");

			airportRepository.save(airport3);


			System.out.println("Aeroportul cu numele Otopeni are id ul: " + airportService.findByName("Otopeni").getId());

			Flight flight= new Flight();
			flight.setDestination("Destination1");
			flight.setPlaneCode("12445");
			flight.setAvailableSeats(40);
			flight.setAirport(airport);

			Flight flight2= new Flight();
			flight2.setDestination("Destination2");
			flight2.setPlaneCode("68432");
			flight2.setAvailableSeats(20);
			flight2.setAirport(airport2);

			Flight flight3= new Flight();
			flight3.setDestination("Destination3");
			flight3.setPlaneCode("07368");
			flight3.setAvailableSeats(60);
			flight3.setAirport(airport);

			Flight flight4= new Flight();
			flight4.setDestination("Destination4");
			flight4.setPlaneCode("07368");
			flight4.setAvailableSeats(60);
			flight4.setAirport(airport1);

			flightRepository.save(flight);
			flightRepository.save(flight2);
			flightRepository.save(flight3);
			flightRepository.save(flight4);


			System.out.println("Zborul cu destinatia Destinatia3");
			System.out.println(flightService.findByDestination("Destination3").getId());

			System.out.println("Zborul cu aeroportul");
			System.out.println(flightService.findByAirport(airport1).getId());

			ArrayList<Flight> fl = flightService.findAllBYAirport(airport2);

			System.out.println("Zboruri cu avionul " + airport2.getName());
			for( Flight f: fl)
			{
				System.out.println(f.getId());
			}

			flightService.deleteAllBYAirport(airport2);

			Ticket ticket= new Ticket();
			ticket.setOwner(user);
			ticket.setFlight(flight);
			ticket.setPrice(30);

			ticketRepository.save(ticket);
		};

	}

}