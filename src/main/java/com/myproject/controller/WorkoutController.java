package com.myproject.controller;

import com.myproject.dto.WorkoutCreateDTO;
import com.myproject.dto.WorkoutDTO;
import com.myproject.mapper.WorkoutMapper;
import com.myproject.model.Exercise;
import com.myproject.model.User;
import com.myproject.model.Workout;
import com.myproject.repository.ExerciseRepository;
import com.myproject.repository.UserRepository;
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
    @Autowired
    UserRepository userRepository;
    @Autowired
    ExerciseRepository exerciseRepository;

    public WorkoutController(WorkoutService workoutService) { this.workoutService = workoutService; }

    // ------ GET -------
    @GetMapping("/get-all/")
    @Operation(summary = "Get all workouts", description = "Get a list of all workouts")
    public List<WorkoutDTO> getAllWorkouts() {
        return workoutService.getAllWorkouts();
    }

    @GetMapping("/get-id/{workoutid}")
    @Operation(summary = "Get workout by ID", description = "Get workout by ID")
    public WorkoutDTO getWorkoutById(@PathVariable Long workoutid) {
        return workoutService.getWorkoutByWorkoutid(workoutid);
    }

    @GetMapping("/get-user/{userfk}")
    @Operation(summary = "Get workouts by specific user id", description = "Get workouts by specific user id")
    public List<WorkoutDTO> getWorkoutsByUserfk(@PathVariable String userfk) {
        return workoutService.getWorkoutsByUserfk(userfk);
    }

    @GetMapping("/get-exercise/{exercisefk}")
    @Operation(summary = "Get workouts by specific exercise id", description = "Get workouts by specific exercise id")
    public List<WorkoutDTO> getWorkoutsByExercisefk(@PathVariable Long exercisefk) {
        return workoutService.getWorkoutsByExercisefk(exercisefk);
    }

    // ------ PUT -------
    @PutMapping("/{workoutid}")
    @Operation(summary = "Update a workout", description = "Update an existing workout")
    public ResponseEntity<WorkoutDTO> updateWorkout(@PathVariable Long workoutid, @RequestBody WorkoutDTO workoutDTO) {
        try {
            workoutDTO.setWorkoutid(workoutid);
            WorkoutDTO updatedWorkout = workoutService.updateWorkout(workoutid, workoutDTO);
            return new ResponseEntity<>(updatedWorkout, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    // ------ POST -------
    @PostMapping
    @Operation(summary = "Create workout", description = "Create a new workout")
    public ResponseEntity<WorkoutDTO> createWorkout(@RequestBody WorkoutCreateDTO workoutCreateDTO) {
        WorkoutDTO saved = workoutService.createWorkout(workoutCreateDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(saved);
    }
//    public ResponseEntity<Workout> createWorkout(@RequestBody Workout workout) {
//        workout.setWorkoutid(null); // autogenreres, ska ikke skrives av oss i swagger
//        Workout savedWorkout = workoutService.createWorkout(workout);
//        return ResponseEntity.status(HttpStatus.CREATED).body(savedWorkout);
//    }



    // ------ DELETE -------
    @DeleteMapping("/delete-id/{workoutid}")
    @Operation(summary = "Delete workout", description = "Delete workout")
    public void deleteWorkoutById(@PathVariable Long workoutid) {
        workoutService.deleteWorkoutById(workoutid);
    }
}
