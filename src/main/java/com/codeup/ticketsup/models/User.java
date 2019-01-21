package com.codeup.ticketsup.models;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue
    private int id;

    @Column(nullable = false , length = 100)
    private String username;

    @Column(nullable = false , length = 100)
    private String first_name;

    @Column(nullable = false , length = 100)
    private String last_name;

    @Column(nullable = false , length = 100)
    private String zip_code;

    @Column(nullable = false , length = 100)
    private String email;

    @Column(nullable = false , length = 100)
    private String password;

    @Column(nullable = false , length = 100)
    private String phone;

    @Column(nullable = false , length = 100)
    private boolean isAdmin;



    // empty User constructor
    public User() {
    }

    public User(User copy) {
        id = copy.id; // This line is SUPER important! Many things won't work if it's absent
        email = copy.email;
        first_name = copy.first_name;
        last_name = copy.last_name;
        zip_code = copy.zip_code;
        phone = copy.phone;
        username = copy.username;
        password = copy.password;
        isAdmin = copy.isAdmin;
    }

    // User constructor without id and isAdmin
    public User(String username, String first_name, String last_name, String zip_code, String email, String password, String phone) {
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.zip_code = zip_code;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    // Do we need this one? I just added id and isAdmin in the constructor
    public User(int id, String username, String first_name, String last_name, String zip_code, String email, String password, String phone, boolean isAdmin) {
        this.id = id;
        this.username = username;
        this.first_name = first_name;
        this.last_name = last_name;
        this.zip_code = zip_code;
        this.email = email;
        this.password = password;
        this.phone = phone;
        this.isAdmin = isAdmin;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setusername(String username) {
        this.username = username;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public void setZip_code(String zip_code) {
        this.zip_code = zip_code;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setAdmin( boolean admin ) {
        isAdmin = admin;
    }

    public int getId() {
        return id;
    }

    public String getusername() {
        return username;
    }

    public String getFirst_name() {
        return first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public String getZip_code() {
        return zip_code;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getPhone() {
        return phone;
    }

    public boolean isAdmin() {
        return isAdmin;
    }


}
