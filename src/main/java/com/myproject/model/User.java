package com.myproject.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Setter
@Getter

public class User {
    @Id
    private String email;

    private String password;
    private String firstname;
    private String lastname;
}
