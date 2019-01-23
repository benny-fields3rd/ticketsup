package com.codeup.ticketsup.models;


import javax.persistence.*;
import java.sql.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false , length = 10)
    private Date order_date;

    @Column(nullable = false , length = 100)
    private String QR_code;

    private int total_tickets;

    private String movie_time;

    @OneToOne
    private User user;

    @OneToOne
    private Status status;

    @OneToOne
    private Movie movies;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="orders_food",
            joinColumns={@JoinColumn(name="order_id")},
            inverseJoinColumns={@JoinColumn(name="food_id")}
    )
    private List<Food> food;

}

