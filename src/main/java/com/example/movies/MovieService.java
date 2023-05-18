package com.example.movies;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovieService {

    @Autowired // We want the framework to instantiate this class for us
    private MovieRepository movieRepository;

    public List<Movie> allMovies(){
        System.out.println(movieRepository.findAll().toString());
        return movieRepository.findAll();
    }

    public Optional<Movie> singleMovie(String id){
        return movieRepository.findMovieByImdbId(id); 
    }
}
