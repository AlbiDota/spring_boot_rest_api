package com.myproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Setter //automatisk setter opp settere og gettere for oss <3
@Getter //tusen takk, Lombok <32<3<3<3
@Table(name= "users")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

    @Id //Jeg ønsker å bruke google authentication for å mekke ID-en til brukern, men foreløpig er den generert her
    //@GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "User ID"/*, accessMode = Schema.AccessMode.READ_ONLY*/) //så vi ikke fucker opp IDen
    @Column(name = "userid")                                                // i swagger eller postman
    private String userid;

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;


    // kan være rar å hente fra googles greie AFAIK //SCRAPPED ????
    @Column(name = "birthday")
    private LocalDate birthday;


}