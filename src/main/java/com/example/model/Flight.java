package com.example.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Date;
import java.util.List;

/**
 * Created by Kevin Clark
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Flight {

    @JsonProperty("Departs")
    private Date departsOn;

    private List<Ticket> tickets;

    @JsonFormat(pattern = "yyyy-MM-dd hh:mm")
    public Date getDepartsOn() { return departsOn; }

    @JsonGetter("Tickets")
    public List<Ticket> getTicket() { return tickets; }

    public void setDepartsOn(Date departsOn) { this.departsOn = departsOn; }

    public void setTicket(List<Ticket> tickets) { this.tickets = tickets; }
}
