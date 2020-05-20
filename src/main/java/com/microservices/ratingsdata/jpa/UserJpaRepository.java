package com.microservices.ratingsdata.jpa;

import com.microservices.ratingsdata.model.UserInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Repository
@Transactional
public class UserJpaRepository {

    @PersistenceContext
    EntityManager entityManager;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    public UserInfo findById(String id) {
        return entityManager.find(UserInfo.class, id);
    }

    public void deleteById(String id){
        UserInfo userInfo = findById(id);
        entityManager.remove(userInfo);
    }

    public UserInfo save(UserInfo userInfo) {
        entityManager.persist(userInfo);
       return userInfo;
    }

    public void playWithEntityManager(){
        logger.info( " play with entity manager");
    }
}
