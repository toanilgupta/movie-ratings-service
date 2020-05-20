package com.microservices.ratingsdata.jpa;

import com.microservices.ratingsdata.model.MovieInfo;
import com.microservices.ratingsdata.model.UserRating;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Repository
@Transactional
public class MovieInfoJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public List<MovieInfo> findAll_typedQuery() {
        TypedQuery<MovieInfo> find_all_movies = entityManager.createNamedQuery("find_all_movies", MovieInfo.class);
        return find_all_movies.getResultList();
    }

    public List<MovieInfo> findAll_query() {
        Query query = entityManager.createQuery("select movie_id,movie_name,year_of_making,description from MOVIE_INFO");
        return query.getResultList();
    }

    public MovieInfo findById(String id) {
        return entityManager.find(MovieInfo.class, id);
    }

    public MovieInfo insert(MovieInfo movieInfo) {
        return entityManager.merge(movieInfo);
    }

    public MovieInfo update(MovieInfo movieInfo) {

        if(findById(movieInfo.getMovieId())==null){
            movieInfo.setMovieId(null);
            entityManager.persist(movieInfo);
        }
        else{
            entityManager.merge(movieInfo);
        }

        return movieInfo;
    }

    public void delete(String movieId) {
        MovieInfo movieInfo = findById(movieId);
        entityManager.remove(movieInfo);
    }

    public void addUserRatingForMovie(String movieId, List<UserRating> userRatings) {
        MovieInfo movieInfo = findById(movieId);
        logger.info(" MovieInfo.getUserRatings() ->{} ", movieInfo.getUserRatings());

        userRatings.forEach(userRating -> {
            movieInfo.addUserRating(userRating);
            userRating.setMovieInfo(movieInfo);
            entityManager.persist(userRating);
        });

    }
}
