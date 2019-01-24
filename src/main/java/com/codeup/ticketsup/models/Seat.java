package com.codeup.ticketsup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    private int id;

    private String name;


    @ManyToMany(mappedBy = "seats")
    private List<Order> orders;


    public Seat() {
    }

    public Seat(String name, List<Order> orders) {
        this.name = name;
        this.orders = orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<Order> getOrders() {
        return orders;
    }
}
