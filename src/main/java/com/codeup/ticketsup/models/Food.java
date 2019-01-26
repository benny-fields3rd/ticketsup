package com.codeup.ticketsup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    private Double price;

    @ManyToMany(mappedBy = "food")
    private List<Order> orders;

    public Food(String name, Double price, List<Order> orders) {
        this.name = name;
        this.price = price;
        this.orders = orders;
    }

    public Food() {
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Double getPrice() {
        return price;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }
}
