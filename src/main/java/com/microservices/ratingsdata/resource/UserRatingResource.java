package com.microservices.ratingsdata.resource;

import com.microservices.ratingsdata.dataService.RatingDataService;
import com.microservices.ratingsdata.model.UserRating;
import com.microservices.ratingsdata.service.AsyncComponent;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.async.DeferredResult;

import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ForkJoinPool;

/*import com.microservices.ratingsdata.util.JwtTokenUtil;
import com.microservices.ratingsdata.service.JwtUserDetailsService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;*/

/*import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;*/

//@RefreshScope
@RestController
@RequestMapping(value = "/")
public class UserRatingResource {

    private static final Logger logger = LoggerFactory.getLogger(UserRatingResource.class);

    @Autowired
    private AsyncComponent asyncComponent;

    @Autowired
    private RatingDataService ratingDataService;

    @RequestMapping(value = "/helloWorld", method = RequestMethod.GET)
    public String getHelloWorld(){
        return "Hello World";
    }


    @RequestMapping(value = "/ratings", method = RequestMethod.GET)
    public List<UserRating> getAllRatings(){
        return ratingDataService.getAllRatings();
    }

    @RequestMapping(value = "/movies/{movieId}/ratings", method = RequestMethod.GET)
    public List<UserRating> getAllRatingsForMovie(@PathVariable String movieId){
        logger.debug(" movieId "+movieId);

        return ratingDataService.getAllRatingsforMovie(movieId);
    }

    @RequestMapping(value = "/users/{userId}/movies/ratings", method = RequestMethod.GET)
    public List<UserRating> getAllRatingsByUser(@PathVariable String userId){
        logger.debug(" userId "+userId);
        return ratingDataService.getAllRatingsByUser(userId);
    }

    @RequestMapping(value="/ratings/{ratingId}", method=RequestMethod.GET)
    public UserRating getRating(@PathVariable Long ratingId){
        return ratingDataService.getUserRating(ratingId);
    }

    @RequestMapping(value="/ratings/{ratingId}", method=RequestMethod.DELETE)
    public void deleteRating(@PathVariable Long ratingId){
        ratingDataService.deleteRatingItem(ratingId);
    }

    /*

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @RequestMapping(value = "/authenticate", method = RequestMethod.POST)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());

        final UserDetails userDetails = userDetailsService
                .loadUserByUsername(authenticationRequest.getUsername());

        final String token = jwtTokenUtil.generateToken(userDetails);

        return ResponseEntity.ok(new JwtResponse(token));
    }

    private void authenticate(String username, String password) throws Exception {
        try {
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, password));
        } catch (DisabledException e) {
            throw new Exception("USER_DISABLED", e);
        } catch (BadCredentialsException e) {
            throw new Exception("INVALID_CREDENTIALS", e);
        }
    }
*/

    @RequestMapping("/Async/{movieName}")
    public DeferredResult<UserRating> getAsyncRating(@PathVariable("movieName") String movieName) throws InterruptedException, ExecutionException {

       /* System.out.println("testAsync Start");
        CompletableFuture<RatingItem> completableFuture = asyncComponent.asyncMethodWithReturnType(true);
        completableFuture.completedFuture(completableFuture.get());
        //completableFuture.complete

        System.out.println(completableFuture.get());
        return completableFuture;*/
        /*System.out.println("Request received");

        CompletableFuture<RatingItem> completableFuture =
                CompletableFuture.supplyAsync(this::processRequest);

        System.out.println("Servlet thread released");

        return completableFuture;
*/
        DeferredResult<UserRating> deferredResult = new DeferredResult<UserRating>();
        ForkJoinPool.commonPool()
                .submit(() -> deferredResult.setResult(processRequest()));

        Thread.sleep(2000);
        System.out.println("Servlet thread released"+((UserRating)deferredResult.getResult()).getRating());
        return deferredResult;
    }

    private UserRating processRequest() {
        UserRating userRating = new UserRating();//= new UserRating("Super30","2019","4*");
        return userRating;
    }

    /*@Value("${message: Default Hello}")
    private String message;*/

    /*@Value("${spring.message}")
    private String message;*/
}
