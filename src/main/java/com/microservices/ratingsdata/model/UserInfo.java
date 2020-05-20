package com.microservices.ratingsdata.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "USER_INFO")
public class UserInfo {

    @Id
    private String userId;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="PASSPORT_NUMBER")
    private Passport passport;

    private String userName;
    private String profession;

    //@OneToMany(mappedBy = "userInfo")
    //private List<UserRating> userRatings = new ArrayList<>();

}
