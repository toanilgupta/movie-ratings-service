package com.microservices.ratingsdata.service;

import com.microservices.ratingsdata.model.UserRating;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Component;

import java.util.concurrent.CompletableFuture;

@Component
public class AsyncComponent {

    @Async
    public CompletableFuture<UserRating> asyncMethodWithReturnType(boolean valid) throws InterruptedException {
        if(valid) {
            System.out.println(" Execute Asynchronous " + Thread.currentThread());

            UserRating userRating = new UserRating();
            //userRating.setMovieId("0606");
            userRating.setRating("5*");
            //userRating.setUserId("USER1");
            Thread.sleep(2000);
          return CompletableFuture.completedFuture(userRating);
        }
        else {
            throw new IllegalStateException("invalid");
        }

    }

}
