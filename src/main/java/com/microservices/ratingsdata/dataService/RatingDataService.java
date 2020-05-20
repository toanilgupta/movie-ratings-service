package com.microservices.ratingsdata.dataService;

import com.microservices.ratingsdata.jpa.UserRatingJpaRepository;
import com.microservices.ratingsdata.model.MovieInfo;
import com.microservices.ratingsdata.model.UserRating;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class RatingDataService {

    @Autowired
    private UserRatingJpaRepository ratingRepository;

    public List<UserRating> getAllRatingsforMovie(MovieInfo movieInfo){
        List<UserRating> ratings = new ArrayList<UserRating>();
        ratingRepository.findAllRatingsByMovieId(movieInfo.getMovieId()).forEach(ratings::add);
        return ratings;
    }

    public List<UserRating> getAllRatingsforMovie(String movieId){
        List<UserRating> ratings = new ArrayList<UserRating>();
        ratingRepository.findAllRatingsByMovieId(movieId).forEach(ratings::add);
        return ratings;
    }

    public List<UserRating> getAllRatingsByUser(String userId){
        List<UserRating> ratings = new ArrayList<UserRating>();
           ratingRepository.findAllRatingsByUserId(userId).forEach(ratings::add);
        return ratings;
    }

    public UserRating getUserRating(long ratingId){
         return ratingRepository.findById(ratingId);
    }

    public  void deleteRatingItem(long ratingId){
         ratingRepository.delete(ratingId);
    }

    public List<UserRating> getAllRatings(){
        List<UserRating> ratings = new ArrayList<UserRating>();
        ratingRepository.findAllRatings().forEach(ratings::add);
        return ratings;
    }


}
