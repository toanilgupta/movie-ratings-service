package com.microservices.ratingsdata;

import com.microservices.ratingsdata.jpa.MovieInfoJpaRepository;
import com.microservices.ratingsdata.jpa.UserRatingJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class SpringJpaDemoApplication {

	//@Autowired
	//private JdbcTemplate jdbcTemplate;

	//@Autowired
	//private MovieRepository movieRepository;

	//@Autowired
	//private MovieJdbcDao movieJdbcDao;

	@PersistenceContext
	private EntityManager entityManager;

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private UserRatingJpaRepository userRatingJpaRepository;

	@Autowired
	private static MovieInfoJpaRepository movieInfoJpaRepository;

	//@Autowired
	//private MovieInfoJpaRepository movieInfoJpaRepository;

	public static void main(String[] args) throws IOException {

		//Path path = Paths.get("com/microservices/ratingsdata/application.yml");

		//List<String> words = Arrays.asList("dfdsfdsf ","rtregfvoiktlgf","45345435345435","fdfdadsfsdfsdfsadretretuero","43243");

		/*String  value1 = "This is new file";
		String  value2 = "nothing might not be meaningful here";
		String  value3 = "It is just to complete one file reading";

		List<String> words = Arrays.asList(value3.split("[\\P{L}]+"));*/

		/*long count = words.stream().filter(a-> a.length()>4).count();


		System.out.println("  words "+count);


		int[] values = {1,4,9,16};
		System.out.println(Stream.of(values));*/


		String  value2 = "nothing might not be meaningful here";
		String  value3 = "It is just to complete one file reading";

		Stream<String> s1 = Arrays.asList(value2.split("[\\P{L}]+")).stream();
		Stream<String> s2 = Arrays.asList(value3.split("[\\P{L}]+")).stream();
		Stream.concat(s1,s2).collect(Collectors.toList()).forEach(System.out::println);

/*		UserInfo userInfo = new UserInfo();
		userInfo.setUserId("USER1");
		userInfo.setUserName("USER NAME1");
		userInfo.setProfession("STUDENT");

		UserRating rating = new UserRating();
		rating.setUserInfo(userInfo);
		rating.setRating("4*");
		rating.setMovieInfo(movieInfoJpaRepository.findById("0606"));


		movieInfoJpaRepository.addUserRatingForMovie("0606", Collections.singletonList(rating) );;*/
	}


	public void init() throws SQLException, IOException {




		//movieInfoJpaRepository.addUserRatingForMovie();
		/*UserInfo userInfo = entityManager.find(UserInfo.class,"USER1");

		System.out.println("finding UserInfo for USER1 "+userInfo.getUserName());

		System.out.println("finding Passport for USER1 "+userInfo.getPassport());

		UserRating userRating = userRatingJpaRepository.findById(103l);

		System.out.println("finding movie for 0101 "+userRating.getMovieInfo());*/
		//System.out.println("finding movie for 0101 "+userRating.getUserId());

		//System.out.println(" user passport details "+movieInfo.getUserRatings().get(0).getRating());

		//userRatingJpaRepository.playWithEntityManager();
		//System.out.println("finding movie for 0101 "+userRatingJpaRepository);

		/*UserRating userRating = new UserRating("USER1","0101","5*");
		userRating = userRatingJpaRepository.save(userRating);

		System.out.println("inserting movie for 0101 "+userRating);

		userRating.setRating("4*");
		System.out.println("inserting movie for 0101 "+userRatingJpaRepository.save(userRating));*/

		/*System.out.println("finding movie for 0101 "+movieInfoJpaRepository.findById( "0101").getMovieName());

		MovieInfo movieInfo = new MovieInfo("SUPER 30","2019","classic movie");
		movieInfo = movieInfoJpaRepository.insert(movieInfo);

		System.out.println("inserting movie for 0101 "+movieInfo);

		movieInfo.setDescription("Inspiring movie");
		System.out.println("inserting movie for 0101 "+movieInfoJpaRepository.update(movieInfo).getMovieName());

		System.out.println("finding all movies "+movieInfoJpaRepository.findAll().size());

		movieInfoJpaRepository.delete(movieInfo.getMovieId());
		System.out.println("inserting movie for  "+movieInfoJpaRepository.findById( movieInfo.getMovieId()));*/

		/*System.out.println("finding movie for 0101 "+movieJdbcDao.deleteById( "0101"));
		movieInfo.setDescription("Awesome movie ");
		System.out.println("updating movie for 0101 "+movieJdbcDao.update(movieInfo));
		System.out.println("finding movie for 0101 "+movieJdbcDao.findById( "0101").getDescription());*/


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

/*
	private static final String broker = "127.0.0.1:9092";
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
