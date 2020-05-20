package com.microservices.ratingsdata.jpa;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.test.context.TestPropertySource;


//@RunWith(SpringRunner.class)
@RunWith(MockitoJUnitRunner.class)
@TestPropertySource(
        locations = "classpath:application.yml")
public class UserJpaRepositoryTest {


    @Test
    public void test(){
        System.out.println(" this is test method");
    }


   /*

    @Autowired
    UserJpaRepository userJpaRepository;

    @Autowired
    PassportJpaRepository passportJpaRepository;

    private SessionFactory sessionFactory;
    private Session session = null;

    @Before
    public void before() {
        // setup the session factory
        AnnotationConfiguration configuration = new AnnotationConfiguration();
        configuration.addAnnotatedClass(SuperHero.class)
                .addAnnotatedClass(SuperPower.class)
                .addAnnotatedClass(SuperPowerType.class);
        configuration.setProperty("hibernate.dialect",
                "org.hibernate.dialect.H2Dialect");
        configuration.setProperty("hibernate.connection.driver_class",
                "org.h2.Driver");
        configuration.setProperty("hibernate.connection.url", "jdbc:h2:mem");
        configuration.setProperty("hibernate.hbm2ddl.auto", "create");
        sessionFactory = configuration.buildSessionFactory();
        session = sessionFactory.openSession();
    }

    @InjectMocks
    UserJpaRepository userJpaRepository;

    @Mock
    EntityManager entityManager;

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
*/

}