package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class ReviewOrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @GetMapping("/review/{id}")
    public String movie(@PathVariable int id, Model model) {
        model.addAttribute("order", orderRepository.findOne(id));
        model.addAttribute("orderFood", orderService.singleOrder(id).getFood());

        return "ticketOrders/review_order";
    }

}
