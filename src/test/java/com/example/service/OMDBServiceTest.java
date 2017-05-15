package com.example.service;

import com.example.model.MovieData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.client.MockRestServiceServer;

import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.method;
import static org.springframework.test.web.client.match.MockRestRequestMatchers.requestTo;
import static org.springframework.test.web.client.response.MockRestResponseCreators.withSuccess;


@SpringBootTest
@RunWith(SpringRunner.class)
public class OMDBServiceTest {

    private OMDBService oserv = new OMDBService();
    MockRestServiceServer mockServer = MockRestServiceServer.createServer(oserv.getRestTemplate());

    @Test
    public void TestGetData () throws Exception {
        mockServer
                .expect(requestTo("http://www.omdbapi.com/?s=harryTest"))
                .andExpect(method(HttpMethod.GET))
                .andRespond(withSuccess(this.getJSON("/harry.json"), MediaType.APPLICATION_JSON));

        List<MovieData> result = oserv.getOmdbData("harryTest");
        assertThat(result.get(0).getTitle(), equalTo("Harry Potter and the Deathly Hallows: Part 2"));

        mockServer.verify();


    }




    private String getJSON(String path) throws Exception {
        URL url = this.getClass().getResource(path);
        return new String(Files.readAllBytes(Paths.get(url.getFile())));
    }
}
