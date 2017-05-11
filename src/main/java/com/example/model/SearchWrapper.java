package com.example.model;


import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class SearchWrapper {
    private List<MovieData> search;

    public List<MovieData> getSearch() {
        return search;
    }

    @JsonProperty("Search")
    public void setSearch(List<MovieData> search) {
        this.search = search;
    }
}
