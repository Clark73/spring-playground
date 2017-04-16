package com.example.controler;

import com.example.model.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/flights")
public class FlightController {



    @GetMapping("")
    public List<Flight> getFlights() {
        long datetime = 1492785240000L;
        Flight flight1 = new Flight();
        Flight flight2 = new Flight();
        Ticket ticket1 = new Ticket();
        Ticket ticket2 = new Ticket();
        Passenger passenger1 = new Passenger();
        Passenger passenger2 = new Passenger();

        passenger1.setFirstname("Kevin");
        passenger1.setLastname("Clark");
        ticket1.setPrice(200);
        ticket1.setPassenger(passenger1);

        passenger2.setFirstname("Nicole");
        ticket2.setPrice(400);
        ticket2.setPassenger(passenger2);

        flight1.setTicket(Arrays.asList(ticket1));
        flight1.setDepartsOn(new Date(datetime));

        flight2.setTicket(Arrays.asList(ticket2));
        flight2.setDepartsOn(new Date(datetime));

        return Arrays.asList(flight1, flight2);
    }

    @GetMapping("/flight")
    public Flight getFlight() {
        long datetime = 1492785240000L;
        Flight flight = new Flight();
        Ticket ticket1 = new Ticket();
        Passenger passenger1 = new Passenger();

        passenger1.setFirstname("Kevin");
        passenger1.setLastname("Clark");
        ticket1.setPrice(200);
        ticket1.setPassenger(passenger1);

        List<Ticket> tickets = new ArrayList<>();
        tickets.add(ticket1);

        flight.setTicket(tickets);
        flight.setDepartsOn(new Date(datetime));

        return flight;
    }

    @PostMapping("/tickets/total")
    public Total calcTotal(@RequestBody TicketBundle flight) {
        Total total = new Total();

        int totalPrice = 0;
        for(Ticket ticket: flight.getTickets()) {
            totalPrice += ticket.getPrice();
        }

        total.setTotal(totalPrice);

        return total;
    }
}
