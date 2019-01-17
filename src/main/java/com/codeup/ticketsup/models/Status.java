package com.codeup.ticketsup.models;

import javax.persistence.*;

@Entity
@Table(name = "status")
public class Status {

    @Id
    @GeneratedValue
    private int id;

    private String status;

}
