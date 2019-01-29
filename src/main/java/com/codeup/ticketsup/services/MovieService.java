package com.codeup.ticketsup.services;

import com.codeup.ticketsup.models.Movie;
import com.codeup.ticketsup.interfaces.MoviesRepository;

import java.util.List;

public class MovieService {

    private final MoviesRepository movieRep;

    public MovieService(MoviesRepository movieRep) {
        this.movieRep = movieRep;
    }


    public List<Movie> all() {
        return (List<Movie>) movieRep.findAll();
    }

    public Movie singleMovie(int id){
        return movieRep.findOne(id);
    }




}

