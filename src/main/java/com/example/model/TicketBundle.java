package com.example.model;

import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by Kevin Clark.
 */
public class TicketBundle {
    private List<Ticket> tickets;

    public List<Ticket> getTickets() { return tickets; }
    public void setTickets(List<Ticket> tickets) { this.tickets = tickets; }
}
