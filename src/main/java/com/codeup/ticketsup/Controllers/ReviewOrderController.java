package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ReviewOrderController {

    @Autowired
    OrderRepository orderRepository;

    @GetMapping("/review/{id}")

    public String movie() {
        return "ticketOrders/review_order";
    }

}
