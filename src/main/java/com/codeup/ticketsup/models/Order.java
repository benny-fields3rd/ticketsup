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

    @Column(nullable = false , length = 100)
    private String order_date;

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
            name="order_seats",
            joinColumns={@JoinColumn(name="order_id")},
            inverseJoinColumns={@JoinColumn(name="seat_id")}
    )
    private List<Seat> seats;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(
            name="orders_food",
            joinColumns={@JoinColumn(name="order_id")},
            inverseJoinColumns={@JoinColumn(name="food_id")}
    )

    private List<Food> food;

    public Order() {
    }


    public Order(String order_date, String QR_code, int total_tickets, String movie_time, User user, Status status, Movie movies, List<Food> food) {
        this.order_date = order_date;
        this.QR_code = QR_code;
        this.total_tickets = total_tickets;
        this.movie_time = movie_time;
        this.user = user;
        this.status = status;
        this.movies = movies;
        this.food = food;
    }

    public Order(String order_date, String QR_code, int total_tickets, String movie_time, User user, Status status, Movie movies, List<Seat> seats, List<Food> food) {
        this.order_date = order_date;
        this.QR_code = QR_code;
        this.total_tickets = total_tickets;
        this.movie_time = movie_time;
        this.user = user;
        this.status = status;
        this.movies = movies;
        this.seats = seats;
        this.food = food;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setOrder_date(String order_date) {
        this.order_date = order_date;
    }

    public void setQR_code(String QR_code) {
        this.QR_code = QR_code;
    }

    public void setTotal_tickets(int total_tickets) {
        this.total_tickets = total_tickets;
    }

    public void setMovie_time(String movie_time) {
        this.movie_time = movie_time;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMovies(Movie movies) {
        this.movies = movies;
    }

    public void setFood(List<Food> food) {
        this.food = food;
    }

    public int getId() {
        return id;
    }

    public String getOrder_date() {
        return order_date;
    }

    public String getQR_code() {
        return QR_code;
    }

    public int getTotal_tickets() {
        return total_tickets;
    }

    public String getMovie_time() {
        return movie_time;
    }

    public User getUser() {
        return user;
    }

    public Status getStatus() {
        return status;
    }

    public Movie getMovies() {
        return movies;
    }

    public List<Food> getFood() {
        return food;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Seat> getSeats() {
        return seats;
    }
}

