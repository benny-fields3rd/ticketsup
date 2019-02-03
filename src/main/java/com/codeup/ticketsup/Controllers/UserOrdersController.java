package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.FoodRepository;
import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.interfaces.SeatsRepository;
import com.codeup.ticketsup.interfaces.UserRepository;

import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserOrdersController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    FoodRepository foodRepository;
    @Autowired
    SeatsRepository seatsRepository;
    @GetMapping("orders/user")
    public String movie(Model model) {
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findOne(authenticatedUser.getId());
        model.addAttribute("user_id" , currentUser.getId());
        model.addAttribute("user_orders" , orderRepository.findAllByUser(userRepository.findOne(currentUser.getId())) );

        return "user/user-order-list";
    }
    @PostMapping("/orders/delete/{id}")
    public String deleteOrder(@PathVariable int id){
        Order order = orderRepository.findOne(id);
        foodRepository.delete(order.getFood());
        seatsRepository.delete(order.getSeats());
        orderRepository.delete(order);
        return "redirect:orders/user";
    }
}
