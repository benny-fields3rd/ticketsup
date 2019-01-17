package com.codeup.ticketsup.models;

import javax.persistence.*;

@Entity
@Table(name = "seats")
public class Seat {

    @Id
    @GeneratedValue
    private int id;

    private String name;

    @OneToOne
    private Order order;

}
