package com.codeup.ticketsup.Controllers;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.interfaces.UserRepository;
import com.codeup.ticketsup.models.Food;
import com.codeup.ticketsup.models.Order;
import com.codeup.ticketsup.models.User;
import com.codeup.ticketsup.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class
ReviewOrderController {

    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    UserRepository userRepository;

    @GetMapping("/review/{id}")
    public String movie(@PathVariable int id, Model model) {

        model.addAttribute("order", orderRepository.findOne(id));
        model.addAttribute("order_id", id);

        model.addAttribute("orderFood", orderService.singleOrder(id).getFood());

//        int ticketsTotalPrice = orderRepository.findOne(id).getTotal_tickets() * 7 ;
//        List<Food> foods = orderService.singleOrder(id).getFood();
//        double foodTotal;
//        for ( Food foodPrice : foods ){
//            foodPrice += foodPrice.getPrice();
//        }

        return "ticketOrders/review_order";
    }

    @PostMapping("/orderSubmited")
    public String submit(@RequestParam(name = "order_id") int order){
        User authenticatedUser = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        User currentUser = userRepository.findOne(authenticatedUser.getId());
        Order currentorder = orderRepository.findOne(order);
        currentorder.setUser(currentUser);
        orderRepository.save(currentorder);

        return "redirect:orders/user/"+ currentUser.getId();
    }
}
