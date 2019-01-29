package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Movie;
import org.springframework.data.repository.CrudRepository;

public interface MoviesRepository extends CrudRepository<Movie, Integer> {

}
