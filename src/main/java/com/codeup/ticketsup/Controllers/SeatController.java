package com.codeup.ticketsup.Controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class SeatController {

    @GetMapping("/seat-selection")

    public String pickSeat() {
        return "user/seat_selection";
    }
}
