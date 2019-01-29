package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.FoodRepository;
import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.interfaces.StatusRepository;
import com.codeup.ticketsup.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FoodController {


    private OrderRepository orderRepository;

    private FoodRepository foodRepository;

    private StatusRepository statusRepository;

    public FoodController(OrderRepository orderRepository, FoodRepository foodRepository, StatusRepository statusRepository) {
        this.orderRepository = orderRepository;
        this.foodRepository = foodRepository;
        this.statusRepository = statusRepository;
    }

    @GetMapping("/food/{id}")
    public String food(@PathVariable int id, Model model) {
        model.addAttribute("order_id", id);
        model.addAttribute("allFood" ,  foodRepository.findAll());
        return "ticketOrders/food";
    }

    @PostMapping("/food")
    public String saveFood(@RequestParam(name = "order_id") int id, @RequestParam(name = "food") List<Food> food) {
        Order order = orderRepository.findOne(id);
        Status status3 = statusRepository.findOne(3);

        order.setFood(food);
        order.setStatus(status3);
        orderRepository.save(order);
        return "redirect:/review/" + id ;
    }
}
