
package com.microservices.ratingsdata.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.microservices.ratingsdata.MovieRatingsServiceApplication;
import com.microservices.ratingsdata.model.MovieInfo;
import org.json.JSONException;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = MovieRatingsServiceApplication.class,
		webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class MovieRatingsServiceApplicationTests {

		@LocalServerPort
		private int port;

		TestRestTemplate restTemplate = new TestRestTemplate();

		HttpHeaders headers = new HttpHeaders();

		@Test
		public void test(){
			System.out.println(" test case executed");
		}

		@Test
		@Ignore
		public void testRetrieveMovies() throws JsonProcessingException {

			MovieInfo movieInfo = new MovieInfo();// "MovieName", "2020", "Description");
			movieInfo.setMovieId("010101");
			movieInfo.setDescription(" new Movie");
			movieInfo.setMovieName("movie Name");
			movieInfo.setYearOfMaking("2020");

			//Creating the ObjectMapper objec
			ObjectMapper mapper = new ObjectMapper();
			//Converting the Object to JSONString
			String jsonString = mapper.writeValueAsString(movieInfo);
			System.out.println(jsonString);

			/*HttpEntity<String> entity = new HttpEntity<String>(null, headers);

			ResponseEntity<String> response = restTemplate.exchange(
					createURLWithPort("/testmovies"),
					HttpMethod.GET, entity, String.class);


			String actual = response.getBody();
			String expected = "[{\"movieId\":\"URI\",\"movieName\":\"URI\",\"yearOfMaking\":\"2019\",\"description\":\"description\"}]";

			System.out.println("actual response " + actual);
			System.out.println("expected response " + expected);

			JSONAssert.assertEquals(expected, actual, false);*/
		}

	@Test
	@Ignore
	public void testRetrieveMovie() throws JSONException {

		HttpEntity<String> entity = new HttpEntity<String>(null, headers);

		ResponseEntity<String> response = restTemplate.exchange(
				createURLWithPort("/testmovie/15"),
				HttpMethod.GET, entity, String.class);

		System.out.println("response " + response.getBody());
		//String expected = "[{movieId:URI,movieName:URI,yearOfMaking:2019,description:description}]";
		assertEquals("movieId -15 Not found ",response.getBody());
	}

	private String createURLWithPort(String uri) {
		return "http://localhost:" + port + uri;
	}
}


/*@Autowired
	UserRatingResource ratingdataService;

	@Test
	public void testGetRating() {
		//ratingdataService.getRating("movieName");
	}

	@Autowired
	AsyncComponent asyncComponent;*//*


	*/
/*@Test
	public void testAsynchComponents() throws InterruptedException, ExecutionException {
		System.out.println(" calling method "+Thread.currentThread());
		CompletableFuture<UserRating> future = asyncComponent.asyncMethodWithReturnType(true);
		System.out.println(" called method "+Thread.currentThread());

		System.out.println(future.get().getMovieId());
		Thread.sleep(2000);
		System.out.println(future.get().getMovieId());
	}*//*


	*/
/*@Test
	public void testAsynchComponentsWithException() throws InterruptedException {
		System.out.println(" calling method "+Thread.currentThread());
		CompletableFuture<UserRating> future = asyncComponent.asyncMethodWithReturnType(false);
		System.out.println(" called method "+Thread.currentThread());

		System.out.println(future);
		Thread.sleep(2000);
		System.out.println(future);
	}*//*

}


*/
