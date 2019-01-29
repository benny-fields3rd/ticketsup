package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrderRepository extends CrudRepository<Order, Integer> {
    List<Order> findAllByUser(User user);
}
