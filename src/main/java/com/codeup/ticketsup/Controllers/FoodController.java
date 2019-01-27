package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.FoodRepository;
import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.models.Food;
import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FoodController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    FoodRepository foodRepository;

    @GetMapping("/food/{id}")
    public String food(@PathVariable int id, Model model) {
        model.addAttribute("order_id", id);
        model.addAttribute("allFood" ,  foodRepository.findAll());
        return "ticketOrders/food";
    }

    @PostMapping("/food")
    public String saveFood(@RequestParam(name = "order_id") int id, @RequestParam(name = "food") List<Food> food) {
        Order order = orderRepository.findOne(id);
        order.setFood(food);
        orderRepository.save(order);
        return "redirect:/review/" + id ;
    }
}
