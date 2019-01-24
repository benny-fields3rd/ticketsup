package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Seat;
import org.springframework.data.repository.CrudRepository;

public interface SeatRepository extends CrudRepository<Seat, Integer> {

}
