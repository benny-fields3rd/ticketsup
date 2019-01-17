package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Status;
import org.springframework.data.repository.CrudRepository;

public interface StatusRepository extends CrudRepository<Status, Integer> {
}
