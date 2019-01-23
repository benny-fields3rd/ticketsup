package com.codeup.ticketsup.services;

import com.codeup.ticketsup.models.Movie;
import com.codeup.ticketsup.models.MovieRepository;

public class MovieService {

    private final MovieRepository PostDao;

    public MovieService(MovieRepository postDao) {
        PostDao = postDao;
    }
    public Movie create(Movie post){
        return PostDao.save(post);
    }
}

