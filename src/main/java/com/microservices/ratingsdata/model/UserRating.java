package com.microservices.ratingsdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
@Table(name = "USER_RATING")
public class UserRating implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "RATING_ID")
    private Long ratingId;

    @Column(name = "USER_ID")
    private String userId;

    @ManyToOne(fetch = FetchType.LAZY,cascade = CascadeType.DETACH)
    @JoinColumn(name="MOVIE_ID")
    @JsonIgnore
    private MovieInfo movieInfo;

    @Column(name="RATING")
    private String rating;

}
