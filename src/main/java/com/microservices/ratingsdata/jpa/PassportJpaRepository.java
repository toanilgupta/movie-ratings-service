package com.microservices.ratingsdata.jpa;

import com.microservices.ratingsdata.model.Passport;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class PassportJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public Passport findById(String id) {
        return entityManager.find(Passport.class, id);
    }

    public void deleteById(String id){
        Passport passport = findById(id);
        entityManager.remove(passport);
    }

    public Passport save(Passport passport) {
        entityManager.persist(passport);
        return passport;
    }

    public void playWithEntityManager(){
        logger.info( " play with entity manager");
    }
}

