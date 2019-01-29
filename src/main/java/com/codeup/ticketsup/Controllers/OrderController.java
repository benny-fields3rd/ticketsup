package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.MoviesRepository;
import com.codeup.ticketsup.interfaces.SeatsRepository;
import com.codeup.ticketsup.interfaces.StatusRepository;
import com.codeup.ticketsup.models.*;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class OrderController {
    private OrderService orderService;
    private Users userRepo;

    @Autowired
    SeatsRepository seatsRepository;
    @Autowired
    MoviesRepository moviesRepository;
    @Autowired
    StatusRepository statusRepository;

    public OrderController(OrderService orderService, Users userRepo) {
        this.orderService = orderService;
        this.userRepo = userRepo;
    }


    @PostMapping("/order")
    public String saveNewOrder(@ModelAttribute Order order , @RequestParam ( name ="movies_id") int movies_id) {
        Movie movie = new Movie();
        movie.setTmdb_id(movies_id);
        movie.setActive(true);


        Status status1 = statusRepository.findOne(1);

        Movie saveMovie = moviesRepository.save(movie);


        order.setMovies(saveMovie);
        order.setStatus(status1);

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
