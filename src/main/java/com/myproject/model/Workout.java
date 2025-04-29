package com.myproject.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "workouts")
@Setter
@Getter
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Workout {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Schema(description = "workout ID", accessMode = Schema.AccessMode.READ_ONLY)
    @Column(name = "workoutid")
    private Long workoutid; //id

    @Column(name = "title")
    private String title;

    @Column(name = "content")
    private String content;

    @Column(name = "workoutdate")
    private LocalDate workoutdate;


    @ManyToOne
    @JoinColumn(name = "userfk")
    private User userfk;

    @ManyToOne
    @JoinColumn(name = "exercisefk")
    private Exercise exercisefk;

}
