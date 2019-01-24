package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.SeatRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class SeatController {
    private SeatRepository sp;
//    private

    @GetMapping("/seat-selection")
    public String selectSeat() {
        return "user/seat_selection";

    }


}