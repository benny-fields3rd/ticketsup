package com.codeup.ticketsup.models;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "food")
public class Food {

    @Id
    @GeneratedValue
    private int id;

    private int quantity;

    private String name;

    private Double price;

    @ManyToMany(mappedBy = "food")
    private List<Order> orders;

}
