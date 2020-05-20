package com.microservices.ratingsdata.dataService;

import com.microservices.ratingsdata.jpa.MovieInfoJpaRepository;
import com.microservices.ratingsdata.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class MovieInfoDataService {

    @Autowired
    private MovieInfoJpaRepository movieRepository;

    public List<MovieInfo> getAllMovies(){
       List<MovieInfo> movies = new ArrayList<MovieInfo>();
       //movieRepository.findAll_query().forEach(movies::add);
       movieRepository.findAll_typedQuery().forEach(movies::add);
       return movies;
    }
    public Optional<MovieInfo> getMovieInfo(String movieId ){
        return Optional.ofNullable(movieRepository.findById(movieId));
    }

    public MovieInfo updateMovieInfo(MovieInfo movieInfo){
        return movieRepository.update(movieInfo);
    }

    public MovieInfo addMovieDetail(MovieInfo movieInfo) {
        return movieRepository.insert(movieInfo);
    }

}
