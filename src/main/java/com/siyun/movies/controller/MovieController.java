package com.siyun.movies.controller;

import com.siyun.movies.service.MovieService;
import com.siyun.movies.model.Movie;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/movies")
@CrossOrigin(origins = "http://localhost:3000")
public class MovieController {
    private final MovieService service;

    @Autowired
    public MovieController(MovieService service) {
        this.service = service;
    }


    @GetMapping
    public ResponseEntity<List<Movie>> getMovies() {
        return new ResponseEntity<List<Movie>>(service.findAllMovies(), HttpStatus.OK);
    }

    @GetMapping("/{imdbId}")
    public ResponseEntity<Optional<Movie>> getSingleMovie(@PathVariable String imdbId){
        return new ResponseEntity<Optional<Movie>>(service.findMovieByImdbId(imdbId), HttpStatus.OK);
    }
}
