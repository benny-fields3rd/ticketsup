package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.models.MoviesRepository;
import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Users;
import com.codeup.ticketsup.services.MovieService;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {

    private OrderService orderService;
    private Users userRepo;

    public MovieController(OrderService orderService, Users userRepo) {
        this.orderService = orderService;
        this.userRepo = userRepo;
    }

    @GetMapping("/movie/{id}")
    public String movie(Model model, @PathVariable int id) {
         model.addAttribute("order", new Order());
        return "ticketOrders/moviepage";
    }

    @PostMapping("/movie/{id}")
    public String saveNewOrder(@ModelAttribute Order order) {
        order.setQR_code("");

        Order newOrder = orderService.saveOrder(order);

        return "redirect:/order/" + newOrder.getId() ;
    }




}
