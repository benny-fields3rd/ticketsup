package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.models.Food;
import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FoodController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/food/{id}")

    public String movie() {
        return "ticketOrders/food";
    }

    @PostMapping("/food")
    public String saveSeats(@RequestParam(name = "order_id") int id, @RequestParam(name = "food") List<Food> food) {
        Order order = orderRepository.findOne(id);
        order.setFood(food);
        orderRepository.save(order);
        return "redirect:/review/" + id ;
    }
}
