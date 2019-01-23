package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.models.Movie;
import com.codeup.ticketsup.models.Users;
import com.codeup.ticketsup.services.MovieService;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class MovieController {


    private MovieService movieService;
    private Users userRepo;



    @GetMapping("/movie")
    public String movie(Model model) {
        model.addAttribute("movie" ,new Movie());
        return "ticketOrders/moviepage";
    }
    @PostMapping("/movie")
    public String saveNewPost(@ModelAttribute Movie movie) {
        movieService.create(movie);
        return "redirect:/";
    }



}
