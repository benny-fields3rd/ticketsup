package com.codeup.ticketsup.models;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface OrdersRepository extends CrudRepository<Order, Integer> {
}
