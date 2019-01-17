package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.User;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<User, Integer> {
}
