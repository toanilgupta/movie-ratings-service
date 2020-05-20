package com.microservices.ratingsdata.consumer;

import com.microservices.ratingsdata.dataService.MovieInfoDataService;
import com.microservices.ratingsdata.dataService.RatingDataService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

//import org.springframework.kafka.annotation.KafkaListener;

@Service
public class KafkaConsumer {

    @Autowired
    RatingDataService ratingDataService;

    @Autowired
    MovieInfoDataService movieInfoDataService;

    /*@KafkaListener(topics = "Kafka_UserRating")
    public void consume(MovieInfo message){

        System.out.println("consumer called "+message);
        if(movieInfoDataService.getMovieInfo(message.getMovieId()).isPresent()) {
            List<UserRating> rating = ratingDataService.getAllRatingsforMovie(message.getMovieId());
            System.out.println("consumer called " + rating);
            rating.forEach(System.out::println);
        }
        else{
            movieInfoDataService.updateMovieInfo(message);
        }
    }*/
}
