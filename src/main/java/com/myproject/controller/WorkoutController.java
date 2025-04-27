package com.myproject.controller;

import com.myproject.repository.WorkoutRepository;
import com.myproject.service.WorkoutService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Workout Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/workout")
public class WorkoutController {
    private final WorkoutService workoutService;

    @Autowired
    WorkoutRepository workoutRepository;
    public WorkoutController(WorkoutService workoutService) { this.workoutService = workoutService; }

    // ------ GET -------
    @GetMapping("/get-all/")
    @Operation(summary = "", description = "")

    @GetMapping("/get/{workoutid}")
    @Operation(summary = "", description = "")

    @GetMapping("/get/")
    @Operation(summary = "", description = "")

    @GetMapping("/get-all/")
    @Operation(summary = "", description = "")

    // ------ PUT -------

    // ------ POST -------

    // ------ DELETE -------

}
