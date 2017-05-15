package com.example.service;

import com.example.model.MovieData;
import com.example.model.SearchWrapper;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.List;

@Service
public class OMDBService {

    private RestTemplate restTemplate = new RestTemplate();

    public List<MovieData> getOmdbData (String query) {
        URI uri = UriComponentsBuilder
                .fromUriString("http://www.omdbapi.com/?s={query}")
                .buildAndExpand(query)
                .toUri();

        RequestEntity<?> request = RequestEntity.get(uri).build();

        ResponseEntity<SearchWrapper> response = this.restTemplate.exchange(
                request,
                SearchWrapper.class
        );

//        String response = restTemplate.getForObject("http://www.omdbapi.com/?s={query}", String.class, query);

        System.out.println(response.getBody().toString());


        return response.getBody().getSearch();
    }

    public RestTemplate getRestTemplate() {
        return restTemplate;
    }

}
