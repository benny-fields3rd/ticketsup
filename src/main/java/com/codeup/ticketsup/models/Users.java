package com.codeup.ticketsup.models;

import org.springframework.data.repository.CrudRepository;

public interface Users extends CrudRepository<User, Integer> {
    User findByUsername(String username);
}
