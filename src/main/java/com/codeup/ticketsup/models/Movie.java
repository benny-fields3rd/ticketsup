package com.codeup.ticketsup.models;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "movies")
public class Movie {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false , length = 100)
    private int omdb_id;

    @Column(nullable = false , length = 100)
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="movies_auditoriums",
            joinColumns={@JoinColumn(name="movie_id")},
            inverseJoinColumns={@JoinColumn(name="auditorium_id")}
    )

    private List<Auditorium> auditoriums;
}
