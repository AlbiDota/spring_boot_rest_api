package com.myproject.dto;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class WorkoutDTO {
    @Schema(description = "Workout ID", accessMode = Schema.AccessMode.READ_ONLY)
    private Long workoutid;

    private String title;
    private String content;

    @Schema(description = "(yyyy-MM-dd)", example = "1999-05-13")
    private LocalDate workoutdate;

    @Schema(description = "User ID",  example = "abcd1234",accessMode = Schema.AccessMode.READ_ONLY)
    private String userid;

    @Schema(description = "User ID",  example = "0")
    private Long exerciseid;
}
