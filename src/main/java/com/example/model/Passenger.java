package com.example.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by Kevin Clark.
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Passenger {
    private String firstName;
    private String lastName;

    @JsonCreator
    public Passenger(
            @JsonProperty("Firstname") String firstname,
            @JsonProperty("Lastname") String lastname
    ) {
        this.firstName = firstname;
        this.lastName = lastname;
    }

    @JsonCreator
    public Passenger(
            @JsonProperty("Firstname") String firstname
    ) {
        this.firstName = firstname;
    }

    @JsonGetter("Firstname")
    public String getFirstName() { return firstName; }
    @JsonGetter("Lastname")
    public String getLastName() { return lastName; }

}
