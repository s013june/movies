package com.siyun.movies.service;

import com.siyun.movies.model.Movie;
import com.siyun.movies.repository.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MovieService {

    private MovieRepository repository;

    @Autowired
    public MovieService(MovieRepository repository) {
        this.repository = repository;
    }

    public List<Movie> findAllMovies() {
        return repository.findAll();
    }
    public Optional<Movie> findMovieByImdbId(String imdbId) {
        return repository.findMovieByImdbId(imdbId);
    }
}
