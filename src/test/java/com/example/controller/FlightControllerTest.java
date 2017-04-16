package com.example.controller;

import com.example.controler.FlightController;
import com.example.controler.MathController;
import com.example.model.Flight;
import com.example.model.Ticket;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;


import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;

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

    private Gson gson = new GsonBuilder().create();


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

    @Test
    public void postTotalString() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content("{\"tickets\": [{\"passenger\": {\"firstName\": \"Some name\",\"lastName\": \"Some other name\"},\"price\": 200},{\"passenger\":{\"firstName\": \"Name B\", \"lastName\": \"Name C\"},\"price\": 150}]}");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));
    }

    @Test
    public void postTotalGson() throws Exception {
        Flight flight = new Flight();
        Ticket ticket1 = new Ticket();
        ticket1.setPrice(200);

        Ticket ticke2 = new Ticket();
        ticke2.setPrice(150);

        flight.setTicket(Arrays.asList(ticke2,ticket1));

        RequestBuilder request = MockMvcRequestBuilders.post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(gson.toJson(flight));

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));

    }

    @Test
    public void postTotalFixture() throws Exception {
        String json = getJSON("/flightData.json");
        RequestBuilder request = MockMvcRequestBuilders.post("/flights/tickets/total")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json);

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.result", is(350)));
    }

    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
