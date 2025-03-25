package com.myproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter //automatisk setter opp settere og gettere for oss <3
@Getter //tusen takk, Lombok <32<3<3<3

public class User {
    @Id //usikker på om jeg ska bruke AUTO eller IDENTITY
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; // autogenerert brukerID

    @Column(name = "email", unique = true, nullable = false)
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "firstname")
    private String firstname;

    @Column(name = "lastname")
    private String lastname;
}
