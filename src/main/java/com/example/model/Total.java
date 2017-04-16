package com.example.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * Created by Kevin Clark.
 */
public class Total {

    private int total;

    @JsonProperty("result")
    public int getTotal() { return total; }

    public void setTotal(int total) { this.total = total; }
}
