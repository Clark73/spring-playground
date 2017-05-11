package com.example.controller;

import com.example.OmdbViews;
import com.example.model.MovieData;
import com.example.service.OMDBService;
import com.fasterxml.jackson.annotation.JsonView;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class OMDBController {

    private OMDBService omdbService;

    public OMDBController(OMDBService omdbService) {
        this.omdbService = omdbService;
    }

    @JsonView(OmdbViews.returnView.class)
    @GetMapping("/movies")
    public List<MovieData> getMovies(@RequestParam String q) {
        System.out.println("IM HERE!!!!");
        return omdbService.getOmdbData(q);
    }
}
