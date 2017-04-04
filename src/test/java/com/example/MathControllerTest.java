package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MockMvcBuilder;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

/**
 * Created by Kevin Clark.
 */

@RunWith(SpringRunner.class)
@WebMvcTest(MathController.class)
public class MathControllerTest {
    @Autowired
    private MockMvc mvc;

    @Test
    public void testGetPi() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/pi");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3.141592653589793"));
    }

    @Test
    public void testCalculateAdd() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=add&x=3&y=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 4 = 7"));
    }

    @Test
    public void testCalculateAddDefault() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?x=3&y=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 4 = 7"));
    }

    @Test
    public void testCalculateMulti() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=multiply&x=3&y=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 * 4 = 12"));
    }

    @Test
    public void testCalculateSubtract() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=subtraction&x=3&y=4");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 - 4 = -1"));
    }

    @Test
    public void testCalculateDivideWhole() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.get("/math/calculate?operation=divide&x=8&y=2");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("8 / 2 = 4"));
    }

    @Test
    public void testCalculateSum3() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=3&n=4&n=5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 4 + 5 = 12"));
    }

    @Test
    public void testCalculateSum4() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post("/math/sum?n=3&n=4&n=5&n=6");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string("3 + 4 + 5 + 6 = 18"));
    }

    @Test
    public void testPostVolume() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post( "/math/volume/2/3/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string( "The volume of a 2x3x5 rectangle is 30"));
    }

    @Test
    public void testGetVolume() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders.post( "/math/volume/2/5/5");

        this.mvc.perform(request)
                .andExpect(status().isOk())
                .andExpect(content().string( "The volume of a 2x5x5 rectangle is 50"));

    }
}
