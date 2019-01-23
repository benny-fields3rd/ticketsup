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
    private int tmdb_id;

    @Column(nullable = false , length = 100)
    private boolean isActive;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="movies_auditoriums",
            joinColumns={@JoinColumn(name="movie_id")},
            inverseJoinColumns={@JoinColumn(name="auditorium_id")}
    )

    private List<Auditorium> auditoriums;

    public Movie() {
    }

    public Movie(int tmdb_id, boolean isActive, List<Auditorium> auditoriums) {
        this.tmdb_id = tmdb_id;
        this.isActive = isActive;
        this.auditoriums = auditoriums;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setTmdb_id(int tmdb_id) {
        this.tmdb_id = tmdb_id;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public void setAuditoriums(List<Auditorium> auditoriums) {
        this.auditoriums = auditoriums;
    }

    public int getId() {
        return id;
    }

    public int getTmdb_id() {
        return tmdb_id;
    }

    public boolean isActive() {
        return isActive;
    }

    public List<Auditorium> getAuditoriums() {
        return auditoriums;
    }
}
