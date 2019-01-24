package com.codeup.ticketsup.services;

import com.codeup.ticketsup.models.Movie;
import com.codeup.ticketsup.models.MoviesRepository;

import java.util.List;

public class MovieService {

    private final MoviesRepository MovieDao;

    public MovieService(MoviesRepository MovieDao) {
        this.MovieDao = MovieDao;
    }


    public List<Movie> all() {
        return (List<Movie>) MovieDao.findAll();
    }



}

