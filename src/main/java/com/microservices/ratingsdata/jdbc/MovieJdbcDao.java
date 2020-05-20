package com.microservices.ratingsdata.jdbc;

import com.microservices.ratingsdata.model.MovieInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MovieJdbcDao {

    @Autowired
    JdbcTemplate jdbcTemplate;

    public List<MovieInfo> findAll() {
        return jdbcTemplate.query("select * from MOVIE_INFO",
                new BeanPropertyRowMapper<MovieInfo>(MovieInfo.class));
    }

    public MovieInfo findById(String id) {
        return jdbcTemplate.queryForObject("select * from MOVIE_INFO where movie_id = ?", new Object[]{id},
                new BeanPropertyRowMapper<MovieInfo>(MovieInfo.class));
    }

    public int deleteById(String id) {
        return jdbcTemplate.update("delete from MOVIE_INFO where movie_id = ?", id);

    }

    public int insert(MovieInfo movieInfo) {
        return jdbcTemplate.update(" insert into movie_info(movie_id,movie_name,making_year,description) values(?,?,?,?)"
                , movieInfo.getMovieId(), movieInfo.getMovieName(), movieInfo.getYearOfMaking(), movieInfo.getDescription());
    }

    public int update(MovieInfo movieInfo) {
        return jdbcTemplate.update(" update movie_info set movie_name = ? ,making_year = ? ,description=? " +
                        "where movie_id = ?"
                , movieInfo.getMovieName(), movieInfo.getYearOfMaking(), movieInfo.getDescription(),
                movieInfo.getMovieId());
    }
}
