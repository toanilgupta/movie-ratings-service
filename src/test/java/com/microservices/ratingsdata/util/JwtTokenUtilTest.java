package com.microservices.ratingsdata.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.ratingsdata.model.MovieInfo;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
public class JwtTokenUtilTest {

    @Test
    public void getUsernameFromToken() throws JsonProcessingException {
        MovieInfo movieInfo = new MovieInfo(); // "MovieName", "2020", "Description");
        movieInfo.setMovieId("010101");
        movieInfo.setDescription(" new Movie");
        movieInfo.setMovieName("movie Name");
        movieInfo.setYearOfMaking("2020");


        //Creating the ObjectMapper objec
        ObjectMapper mapper = new ObjectMapper();
        //Converting the Object to JSONString
        String jsonString = mapper.writeValueAsString(movieInfo);
        System.out.println(jsonString);
    }
}