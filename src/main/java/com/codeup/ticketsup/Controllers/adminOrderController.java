package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class adminOrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;

    @GetMapping("/admin/orders")
    public String movie(Model model) {
        model.addAttribute("orders", orderRepository.findAll());
        return "admin/admin";
    }
}
