package com.codeup.ticketsup.models;


import javax.persistence.*;
import javax.persistence.GeneratedValue;
import java.util.List;

@Entity
@Table(name = "auditoriums")
public class Auditorium {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false , length = 100)
    private String name;

    @ManyToMany(mappedBy = "auditoriums")
    private List<Movie> movies;


}
