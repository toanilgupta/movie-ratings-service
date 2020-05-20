package com.microservices.ratingsdata;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.annotation.PostConstruct;
import java.sql.SQLException;

//import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
//import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
//import org.springframework.web.reactive.config.EnableWebFlux;

@SpringBootApplication
@EnableAutoConfiguration
//@EnableDiscoveryClient
//@EnableAsync
//@EnableKafka
//@EnableWebFlux
public class MovieRatingsServiceApplication {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	//@Autowired
	//private MovieRepository movieRepository;

	//@Autowired
	//private MovieJdbcDao movieJdbcDao;

	public static void main(String[] args) {
		SpringApplication.run(MovieRatingsServiceApplication.class, args);
	}

	@PostConstruct
	public void init() throws SQLException {

		/*System.out.println("finding movie for 0101 "+movieJdbcDao.findById( "0101").getMovieName());
		System.out.println("finding all "+movieJdbcDao.findAll().get(0).getMovieName());
		System.out.println("finding movie for 0101 "+movieJdbcDao.deleteById( "0101"));

		//MovieInfo movieInfo = new MovieInfo("0101","ARTICLE 15","2019"," classic movie");
		System.out.println("inserting movie for 0101 "+movieJdbcDao.insert(movieInfo));
		//movieInfo.setDescription("Awesome movie ");

		System.out.println("updating movie for 0101 "+movieJdbcDao.update(movieInfo));

		System.out.println("finding movie for 0101 "+movieJdbcDao.findById( "0101").getDescription());
*/

		//System.out.println(jdbcTemplate.query("select * from MOVIE_INFO", new BeanPropertyRowMapper<MovieInfo>(MovieInfo.class)));

		/*Statement stmt = jdbcTemplate.getDataSource().getConnection().createStatement();
		ResultSet rs = stmt.executeQuery("select * from MOVIE_INFO");
		while (rs.next()) {
			String lastName = rs.getString("MOVIE_NAME");
			System.out.println(lastName + "\n");
		}
		rs.close();
		stmt.close();*/

		/*MovieInfo movieInfo = new MovieInfo("movieId","movieName","2020","description");
		UserRating userRating1 = new UserRating( "userId1","movieId","4*");
		UserRating userRating2 = new UserRating( "userId2","movieId","4*");
		//movieInfo.setUserRatings(Collections.emptySet());
		movieInfo.getUserRatings().add(userRating1);
		movieInfo.getUserRatings().add(userRating2);
		movieRepository.save(movieInfo);*/
	}


	/*private static final String broker = "127.0.0.1:9092";
	@Bean
	public ConsumerFactory<String, String> consumerFactory() {
		Map<String, Object> props = new HashMap<>();
		props.put(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG,broker );
		props.put(ConsumerConfig.GROUP_ID_CONFIG, "group_Id");
		props.put(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG, StringDeserializer.class);
		props.put(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, "com.microservices.ratingsdata.model.MovieInfoDeserializer");
		return new DefaultKafkaConsumerFactory<>(props);
	}

	@Bean
	public ConcurrentKafkaListenerContainerFactory<String, String> kafkaListenerContainerFactory() {
		ConcurrentKafkaListenerContainerFactory<String, String> factory = new ConcurrentKafkaListenerContainerFactory<>();
		factory.setConsumerFactory(consumerFactory());
		return factory;
	}*/

	/*
	@Bean(name = "asyncExecutor")
	public Executor asyncExecutor()
	{
		ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
		executor.setCorePoolSize(3);
		executor.setMaxPoolSize(3);
		executor.setQueueCapacity(100);
		executor.setThreadNamePrefix("AsynchThread-");
		executor.initialize();
		return executor;
	}*/
}
