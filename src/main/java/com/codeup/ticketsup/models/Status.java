package com.codeup.ticketsup.models;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private int id;

    @Column
    private String status;

    public Status() {
    }
    public Status(String status) {
        this.status = status;
    }


    public void setId(int id) {
        this.id = id;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public String getStatus() {
        return status;
    }
}
