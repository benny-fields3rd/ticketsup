package com.codeup.ticketsup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FoodController {

    @GetMapping("/food")

    public String movie() {
        return "ticketOrders/food";
    }
}
