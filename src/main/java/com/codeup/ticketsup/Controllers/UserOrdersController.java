package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.interfaces.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class UserOrdersController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    UserRepository userRepository;
    @GetMapping("orders/user/{id}")
    public String movie(@PathVariable int id , Model model) {

        model.addAttribute("user_id" , id);
        model.addAttribute("user_orders" , orderRepository.findAllByUser(userRepository.findOne(id)) );

        return "user/user-order-list";
    }
}
