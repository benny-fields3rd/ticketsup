package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.SeatRepository;
import com.codeup.ticketsup.models.Order;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class SeatController {
    private SeatRepository sp;
//    private

    @GetMapping("/seat-selection")
    public String selectSeat() {
        return "user/seat_selection";

    }


}
