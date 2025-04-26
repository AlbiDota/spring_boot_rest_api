package com.myproject.controller;

import com.myproject.model.Exercise;
import com.myproject.repository.ExerciseRepository;
import com.myproject.service.ExerciseService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "User Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    ExerciseRepository exerciseRepository;
    public ExerciseController(ExerciseService exerciseService) { this.exerciseService = exerciseService; }

    // ------ GET -------
    @GetMapping("/get/")
    @Operation(summary = "Get all exercises", description = "Get all exercises in a list")
    public List<Exercise> getAllExercises() { return exerciseService.getAllExercises(); }


    // ------ PUT -------
    @PutMapping("/{exerciseid}/")
    @Operation(summary = "", description = "")


    // ------ POST -------
    @PostMapping("/post/")
    @Operation(summary = "", description = "")



    // ------ DELETE -------
    @DeleteMapping("/delete-id/")
    @Operation(summary = "", description = "")


}
