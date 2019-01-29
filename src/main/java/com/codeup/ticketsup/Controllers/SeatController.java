package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.interfaces.SeatRepository;
import com.codeup.ticketsup.interfaces.StatusRepository;
import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.Seat;
import com.codeup.ticketsup.models.Status;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@Controller
public class SeatController {
    private SeatRepository sp;
//    private

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    StatusRepository statusRepository;

    @GetMapping("/seat-selection")
    public String selectSeat() {
        return "user/seat_selection";
    }

    @PostMapping("/seats")
    public String saveSeats(@RequestParam(name = "order_id") int id, @RequestParam(name = "seats") List<Seat> seats) {
        Order order = orderRepository.findOne(id);
        Status status2 = statusRepository.findOne(2);
        order.setQR_code(id);
        order.setSeats(seats);
        order.setStatus(status2);
        orderRepository.save(order);
        return "redirect:/food/" + id ;
    }


}