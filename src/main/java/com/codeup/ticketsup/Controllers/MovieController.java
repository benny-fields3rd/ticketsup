package com.codeup.ticketsup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MovieController {

    @GetMapping("/movie")

    public String movie() {
        return "ticketOrders/moviepage";
    }

//    @GetMapping("/movie/{id}")
//    public String showMovie(@PathVariable int id, int omdb_id) {
//
//        return "ticketOrders/moviepage";
//
//    }



}
