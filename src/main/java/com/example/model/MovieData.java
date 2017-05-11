package com.example.model;


import com.example.OmdbViews;
import com.fasterxml.jackson.annotation.JsonProperty;
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

    public String getType() {
        return type;
    }

    @JsonProperty("Type")
    public void setType(String type) {
        this.type = type;
    }


    public String getTitle() {
        return title;
    }

    @JsonProperty("Title")
    public void setTitle(String title) {
        this.title = title;
    }

    public String getImdbId() {
        return imdbId;
    }

    @JsonProperty("imdbID")
    public void setImdbId(String imdbId) {
        this.imdbId = imdbId;
    }

    public String getPoster() {
        return poster;
    }

    @JsonProperty("Poster")
    public void setPoster(String poster) {
        this.poster = poster;
    }

    public String getYear() {
        return year;
    }

    @JsonProperty("Year")
    public void setYear(String year) {
        this.year = year;
    }
}
