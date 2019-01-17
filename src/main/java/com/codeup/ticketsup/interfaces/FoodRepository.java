package com.codeup.ticketsup.interfaces;

import com.codeup.ticketsup.models.Food;
import org.springframework.data.repository.CrudRepository;

public interface FoodRepository extends CrudRepository<Food, Integer> {
}
