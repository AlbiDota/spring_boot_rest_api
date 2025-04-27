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

@Tag(name = "Exercise Controller")
@CrossOrigin
@RestController
@RequestMapping("/api/exercise")
public class ExerciseController {

    private final ExerciseService exerciseService;

    @Autowired
    ExerciseRepository exerciseRepository;
    public ExerciseController(ExerciseService exerciseService) { this.exerciseService = exerciseService; }

    // ------ GET -------
    @GetMapping("/get-all/")
    @Operation(summary = "Get all exercises", description = "Get all exercises in a list")
    public List<Exercise> getAllExercises() { return exerciseService.getAllExercises(); }

    @GetMapping("/get/{name}")
    @Operation(summary = "Get exercise by name", description = "Get a list of exercises with matching name")
    public List<Exercise> getExercisesByNameLike(@PathVariable String name) {
        return exerciseService.getExercisesByNameLike(name);
    }

    // ------ PUT -------
    @PutMapping("/{exerciseid}")
    @Operation(summary = "Update exercise", description = "Update an exercise")
    public ResponseEntity<Exercise> updateExercise(@PathVariable Long exerciseid, @RequestBody Exercise updatedExercise) {
        try {
            Exercise exercise = exerciseService.updateExercise(exerciseid, updatedExercise);
            return new ResponseEntity<>(exercise, HttpStatus.OK); // return update and code200 (ok)
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND); //404 not found
        }
    }

    // ------ POST -------
    @PostMapping
    @Operation(summary = "Create exercise", description = "Create a new exercise")
    public ResponseEntity<Exercise> createExercise(@RequestBody Exercise exercise) {
        exercise.setExerciseid(null); // den skal genereres, ikke skrives
        Exercise savedExercise = exerciseService.createExercise(exercise);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedExercise);
    }


    // ------ DELETE -------
    @DeleteMapping("/delete-id/{exerciseid}")
    @Operation(summary = "Delete exercise by ID", description = "Delete exercise by ID")
    public void deleteExerciseById(@PathVariable Long exerciseid) { exerciseService.deleteExerciseById(exerciseid); }

}
