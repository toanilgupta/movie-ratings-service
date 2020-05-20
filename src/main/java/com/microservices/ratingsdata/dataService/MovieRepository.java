
package com.microservices.ratingsdata.dataService;

import com.microservices.ratingsdata.model.MovieInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MovieRepository extends JpaRepository<MovieInfo,String> {

        //getAllRatings()

        //getRating(Sting movieName)

        //updateRating(String movieName)

        //deleteRating(String movieName)

        //public Set<MovieInfo> findByUserRatingsUserId(String userId);

        //public Set<MovieInfo> findByUserRatingsUserId(String userId);
}

