package com.microservices.ratingsdata.jpa;

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
public class UserRatingJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserRating findById(Long id) {
        return entityManager.find(UserRating.class, id);
    }

    public List<UserRating> findAllRatingsByUserId(String userId){
        TypedQuery<UserRating> query  = entityManager.createQuery("select r from UserRating r where user_id = '"+userId+"'",UserRating.class);
        return query.getResultList();
    }

    public List<UserRating> findAllRatingsByMovieId(String movieId){
        TypedQuery<UserRating> query = entityManager.createQuery("select r from UserRating r where movie_id = '"+movieId+"'",UserRating.class);
        return query.getResultList();
    }

    public List<UserRating> findAllRatings(){
        TypedQuery<UserRating>  query = entityManager.createQuery("select r from UserRating r",UserRating.class);
        return query.getResultList();
    }

    public UserRating save(UserRating userRating) {

        if(userRating.getRatingId() ==null){
            entityManager.persist(userRating);
        }
        else{
            entityManager.merge(userRating);
        }
       return userRating;
    }

    public void delete(long userRatingId){
        UserRating userRating = entityManager.find(UserRating.class, userRatingId);
        entityManager.remove(userRating);
    }

    public void playWithEntityManager(){
        logger.info( " play with entity manager");

        UserRating userRating1 = new UserRating();//" USER2","0505","6*");
        //userRating1.setUserId("USER2");
        userRating1.setRating("5*");
        //userRating1.setMovieId("0606");
        entityManager.persist(userRating1);
        //entityManager.flush();
        //entityManager.clear();

        UserRating userRating2 = new UserRating();//"USER3","0606","6*");
        //userRating2.setUserId("USER3");
        userRating2.setRating("5*");
        entityManager.persist(userRating2);
        entityManager.flush();

       // entityManager.clear();

       // entityManager.detach(userRating2);
        userRating1.setRating("3*");
        //entityManager.flush();
        entityManager.refresh(userRating1);

        userRating2.setRating("3*");
        entityManager.flush();

    }
}
