package com.example.controller;

import com.example.controler.FlightController;
import com.example.controler.MathController;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Kevin Clark.
 */
@RunWith(SpringRunner.class)
@WebMvcTest(FlightController.class)
public class FlightControllerTest {

    @Autowired
    private MockMvc mvc;

    @Test
    public void getFlight() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/flights/flight")
                .accept(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.Departs", is("2017-04-21 02:34")))
                .andExpect(jsonPath("$.Tickets.[0].Passenger.Firstname", is("Kevin")))
                .andExpect(jsonPath("$.Tickets.[0].Passenger.Lastname", is("Clark")))
                .andExpect(jsonPath("$.Tickets.[0].Price", is(200)));

    }

    @Test
    public void getFlights() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/flights")
                .contentType(MediaType.APPLICATION_JSON_UTF8)
                .accept(MediaType.APPLICATION_JSON_UTF8);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.[0].Departs", is("2017-04-21 02:34")))
                .andExpect(jsonPath("$.[0].Tickets.[0].Passenger.Firstname", is("Kevin")))
                .andExpect(jsonPath("$.[0].Tickets.[0].Passenger.Lastname", is("Clark")))
                .andExpect(jsonPath("$.[0].Tickets.[0].Price", is(200)))
                .andExpect(jsonPath("$.[1].Departs", is("2017-04-21 02:34")))
                .andExpect(jsonPath("$.[1].Tickets.[0].Passenger.Firstname", is("Nicole")))
                .andExpect(jsonPath("$.[1].Tickets.[0].Price", is(400)));
    }
}
