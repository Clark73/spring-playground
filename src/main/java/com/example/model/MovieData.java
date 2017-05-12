package com.example.model;


import com.example.OmdbViews;
import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonSetter;
import com.fasterxml.jackson.annotation.JsonView;

public class MovieData {
    @JsonView(OmdbViews.returnView.class)
    private String title;
    @JsonView(OmdbViews.returnView.class)
    private String imdbId;
    @JsonView(OmdbViews.returnView.class)
    private String poster;
    @JsonView(OmdbViews.returnView.class)
    private String year;
    @JsonView(OmdbViews.ingestView.class)
    private String type;

    public MovieData(
            @JsonProperty("Title") String title,
            @JsonProperty("imdbID") String imdbId,
            @JsonProperty("Poster") String poster,
            @JsonProperty("Year") String year,
            @JsonProperty("Type") String type ) {
        this.title = title;
        this.imdbId = imdbId;
        this.poster = poster;
        this.year = year;
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public String getTitle() {
        return title;
    }

    public String getImdbId() {
        return imdbId;
    }

    public String getPoster() {
        return poster;
    }

    public String getYear() {
        return year;
    }


}
