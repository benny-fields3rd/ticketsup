package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Users;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class OrderController {
    private OrderService orderService;
    private Users userRepo;

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

        Order order = orderService.singleOrder(id);
        model.addAttribute("order" , order);

        return "ticketOrders/food";
    }
}
