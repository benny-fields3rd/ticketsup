package com.codeup.ticketsup.services;

import com.codeup.ticketsup.interfaces.OrderRepository;
import com.codeup.ticketsup.models.Order;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderRepository orderRepo;


    public OrderService( OrderRepository orderRepo){
        this.orderRepo = orderRepo;
    }
    public Order create(Order order){
        return orderRepo.save(order);
    }

    public List<Order> allOrders(){
        return (List<Order>) orderRepo.findAll();
    }

    public Order singleOrder(int id){
        return orderRepo.findOne(id);
    }

    public Order saveOrder(Order order){
        return orderRepo.save(order);
    }

    public void deleteOrder(Order order){
        orderRepo.delete(order);
    }

}
