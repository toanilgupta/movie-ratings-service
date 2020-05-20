package com.microservices.ratingsdata.model;

import com.fasterxml.jackson.databind.ObjectMapper;

//import org.apache.kafka.common.serialization.Deserializer;

public class MovieInfoDeserializer {//implements Deserializer<MovieInfo> {

       /*@Override public void close() {

        }

        @Override public void configure(Map<String, ?> arg0, boolean arg1) {

        }

        @Override*/
        public MovieInfo deserialize(String arg0, byte[] arg1) {
            ObjectMapper mapper = new ObjectMapper();
            MovieInfo info = null;
            try {
                info = mapper.readValue(arg1, MovieInfo.class);
            } catch (Exception e) {

                e.printStackTrace();
            }
            return info;
        }

    }

