package com.myproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "exercises")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Exercise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "exercise ID", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "exerciseid")
    private Long exerciseid; //id

    @Column(name = "name")
    private String name; //navn på øvelse - løping, benkpress

    @Column(name = "description")
    private String descr; // beskrivelse av øvelse -

}
