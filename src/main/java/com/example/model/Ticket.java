package com.example.model;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonSetter;

import java.util.List;

/**
 * Created by Kevin Clark.
 */
public class Ticket {

    @JsonProperty("Passenger")
    private Passenger passenger;

    @JsonProperty("Price")
    private int price;

    public Passenger getPassenger() { return passenger; }

    public int getPrice() { return price; }

    public void setPrice(int price) { this.price = price; }
    public void setPassenger(Passenger passenger) { this.passenger = passenger; }

}
