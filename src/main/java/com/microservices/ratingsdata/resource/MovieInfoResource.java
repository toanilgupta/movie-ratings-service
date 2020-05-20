package com.microservices.ratingsdata.resource;

import com.microservices.ratingsdata.dataService.MovieInfoDataService;
import com.microservices.ratingsdata.model.JwtRequest;
import com.microservices.ratingsdata.model.MovieInfo;
import com.microservices.ratingsdata.service.JwtUserDetailsService;
import com.microservices.ratingsdata.util.JwtTokenUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.Executor;

//import reactor.core.publisher.Mono;
//import org.springframework.security.core.userdetails.UserDetails;
//import com.microservices.ratingsdata.dataService.MovieInfoReactiveRepository;

@RestController
@RequestMapping(value = "/")
public class MovieInfoResource {

    @Autowired
    private MovieInfoDataService movieInfoDataService;

    @Autowired
    Executor asyncExecutor;

    private static final Logger logger = LoggerFactory.getLogger(MovieInfoResource.class);

    @Autowired
    private JwtUserDetailsService userDetailsService;

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @RequestMapping(value = "/movies", method = RequestMethod.GET)
    public List<MovieInfo> getAllMovies(){
        System.out.println(" getting all movies");
        return movieInfoDataService.getAllMovies();
    }

    @RequestMapping(value="/movies", method=RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity saveMovie(@RequestBody MovieInfo movieInfo){
       System.out.println("savings movies");
        logger.warn("creating movie "+movieInfo.getMovieName());
        MovieInfo info = movieInfoDataService.addMovieDetail(movieInfo);
        System.out.println(" move saved "+movieInfo.getMovieName());
        return new ResponseEntity(info,HttpStatus.CREATED);
    }

    @RequestMapping(value="/movies/{movieId}", method=RequestMethod.GET, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<MovieInfo> editMovie(@PathVariable String movieId){
        logger.warn("getting movie "+movieId);

        return  new ResponseEntity(movieInfoDataService.getMovieInfo(movieId),HttpStatus.OK);
    }

    @RequestMapping(value="/movies/{movieId}", method=RequestMethod.PUT, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity editMovie(@RequestBody MovieInfo movieInfo){
        logger.warn("updating movie "+movieInfo.getMovieName());

        movieInfoDataService.updateMovieInfo(movieInfo);
        System.out.println(" move saved "+movieInfo.getMovieName());
        return new ResponseEntity(HttpStatus.OK);
    }

    //@Autowired
    /// private AuthenticationManager authenticationManager;

    /*
    @RequestMapping(value = "user/{userId}/movies", method = RequestMethod.GET)
    public List<MovieInfo> getAllMovies(@PathVariable String userId){
        return movieInfoDataService.getAllMoviesUser(userId);
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

    @RequestMapping(value = "/Reactive/movie/{movieId}", method = RequestMethod.GET, consumes="application/stream-json")
    public Mono<MovieInfo> getMovieReactive(@PathVariable String movieId){
        return movieInfoReactiveRepository.findById(movieId);
        //return movieInfoDataService.getMovieDetail(movieId);
    }
     */
    //@Autowired
    //MovieInfoReactiveRepository movieInfoReactiveRepository;

    @CrossOrigin(origins ="http://localhost:4200")
    @RequestMapping(value = "/authenticate", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> createAuthenticationToken(@RequestBody JwtRequest authenticationRequest) throws Exception {

        logger.warn("authenticating login");
        try {
            //authenticate(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            // final UserDetails userDetails = userDetailsService
            //       .loadUserByUsername(authenticationRequest.getUsername());
            // final String token = jwtTokenUtil.generateToken(userDetails);
            //return ResponseEntity.ok(new JwtResponse(token));
        }
        catch(Exception ex){
            return new ResponseEntity<String>(ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
        }
        return new ResponseEntity<String>("", HttpStatus.INTERNAL_SERVER_ERROR);
    }

}
