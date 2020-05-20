package com.microservices.ratingsdata.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.junit4.SpringRunner;


@RunWith(SpringRunner.class)
/*@SpringBootTest(classes = MovieRatingsServiceApplication.class)
@TestPropertySource(
        locations = "classpath:application.yml")*/
public class UserRatingJpaRepositoryTest{

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Test
    public void test(){
        System.out.println(" this is test method");
    }

    /*@Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    PassportJpaRepository passportJpaRepository;

    @Test
    public void findById_test(){

        Passport passport = new Passport();
        passport.setName("USER_NAME");
        passport.setPassportNumber("LN00001");

        UserInfo userInfo = new UserInfo();
        userInfo.setUserId("USER1");
        userInfo.setPassport(passport);
        userInfo.setUserName("USER_NAME");
        userInfo.setProfession("STUDENT");

        passportJpaRepository.save(passport);

        userJpaRepository.save(userInfo);

        userInfo = userJpaRepository.findById("USER1");

        System.out.println(userInfo);

        assertEquals("USER_NAME",userInfo.getUserName());
    }

    @Test
    @DirtiesContext
    public void deleteById_test(){
        userJpaRepository.deleteById("USER1");
        assertNull(userJpaRepository.findById("USER1"));
    }
*/

}