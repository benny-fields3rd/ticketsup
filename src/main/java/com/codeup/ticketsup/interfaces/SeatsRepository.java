package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatsRepository extends CrudRepository<Seat, Integer> {

}
