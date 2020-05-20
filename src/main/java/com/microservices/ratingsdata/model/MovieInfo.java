package com.microservices.ratingsdata.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "MOVIE_INFO")
@NamedQuery(name = "find_all_movies", query = " select m from MovieInfo m")
// HQL - Hibernet Query Language // JPQL Query using Entity  // Native Query - Queries writing using table
public class MovieInfo {

    @Id
    @GeneratedValue(generator = "system-uuid")
    @GenericGenerator(name = "system-uuid", strategy = "uuid")
    private String movieId;

    @Column(name = "MOVIE_NAME")
    private String movieName;

    @Column(name = "YEAR_OF_MAKING")
    private String yearOfMaking;

    @Column(name = "DESCRIPTION")
    private String description;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "movieInfo",cascade = CascadeType.ALL)
    @JsonBackReference
    private List<UserRating> userRatings = new ArrayList<>();

    public void addUserRating(UserRating userRating){
        userRatings.add(userRating);
    }

    public void removeUserRating(UserRating userRating){
        userRatings.remove(userRating);
    }

}
