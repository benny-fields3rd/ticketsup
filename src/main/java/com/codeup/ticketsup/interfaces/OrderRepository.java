package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Order;
import org.springframework.data.repository.CrudRepository;

public interface OrderRepository extends CrudRepository<Order, Integer> {
}
