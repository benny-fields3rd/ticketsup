package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Seat;
import com.codeup.ticketsup.models.SeatsRepository;
import com.codeup.ticketsup.models.Users;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
public class OrderController {
    private OrderService orderService;
    private Users userRepo;

    @Autowired
    SeatsRepository seatsRepository;

    public OrderController(OrderService orderService, Users userRepo) {
        this.orderService = orderService;
        this.userRepo = userRepo;
    }


    @PostMapping("/order")
    public String saveNewOrder(@ModelAttribute Order order) {
        order.setQR_code("");
        Order newOrder = orderService.saveOrder(order);
        return "redirect:/order/" + newOrder.getId() ;
    }


    @GetMapping("/order/{id}")
    public String showOrder(@PathVariable int id, Model model){
        model.addAttribute("seats" ,  seatsRepository.findAll());
        model.addAttribute("order_id", id);
        return "ticketOrders/seat_selection";
    }

//    @PostMapping("/seat/{id}")
//    public String saveSeatsToTheNewOrder(@PathVariable int id, @RequestParam(name="seats") List<String> seats) {
//
//
//        Order newOrder = orderService.saveOrder(order);
//
//        return "redirect:/order/" + newOrder.getId() ;
//    }

}
