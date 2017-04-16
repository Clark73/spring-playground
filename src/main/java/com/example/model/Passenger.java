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
    private String firstname;
    private String lastname;

    public void setFirstname(String firstname) { this.firstname = firstname; }

    public void setLastname(String lastname) { this.lastname = lastname; }

    @JsonGetter("Firstname")
    public String getFirstname() { return firstname; }
    @JsonGetter("Lastname")
    public String getLastname() { return lastname; }

}
