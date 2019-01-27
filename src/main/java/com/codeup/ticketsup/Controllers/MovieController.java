package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.models.*;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class MovieController {

    private OrderService orderService;
    private Users userRepo;
    private MoviesRepository movieRep;

    private StatusRepository statusRepository;
    @Autowired
    OrderRepository orderRepository;

    public MovieController(OrderService orderService, Users userRepo, MoviesRepository movieRep) {
        this.orderService = orderService;
        this.userRepo = userRepo;
        this.movieRep = movieRep;
    }

    @GetMapping("/movie/{id}")
    public String movie(Model model, @PathVariable int id) {
        model.addAttribute("order", new Order());
        model.addAttribute("movies_id",id);


        return "ticketOrders/moviepage";
    }

    @PostMapping("/movie/{id}")
    public String saveNewOrder(@RequestParam(name = "order") Order order) {

        Order newOrder = orderRepository.save(order);

        orderRepository.save(newOrder);
        return "redirect:/order/" + newOrder.getId() ;
    }




}
