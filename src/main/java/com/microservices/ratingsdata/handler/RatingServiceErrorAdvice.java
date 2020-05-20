package com.microservices.ratingsdata.handler;

import com.microservices.ratingsdata.resource.UserRatingResource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.HttpStatus.NOT_FOUND;

@ControllerAdvice
public class RatingServiceErrorAdvice {
    private static final Logger logger = LoggerFactory.getLogger(UserRatingResource.class);

        @ExceptionHandler({RuntimeException.class})
        public ResponseEntity<String> handleRunTimeException(RuntimeException e) {
            return error(INTERNAL_SERVER_ERROR, e);
        }
        @ExceptionHandler({MovieNotFoundException.class})
        public ResponseEntity<String> handleNotFoundException(MovieNotFoundException e) {
            return error(NOT_FOUND, e);
        }

        private ResponseEntity<String> error(HttpStatus status, Exception e) {
            logger.error("Exception : ", e);
            return ResponseEntity.status(status).body(e.getMessage());
        }
    }

