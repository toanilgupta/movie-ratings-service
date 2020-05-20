package com.microservices.ratingsdata.model;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "PASSPORT")
public class Passport {


    @javax.persistence.Id
    private String passportNumber;

    private String Name;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="USER_ID")
    private UserInfo userInfo;

}
