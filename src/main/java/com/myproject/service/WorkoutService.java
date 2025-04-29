package com.myproject.service;

import com.myproject.dto.WorkoutCreateDTO;
import com.myproject.dto.WorkoutDTO;

import java.util.List;

public interface WorkoutService {

    // fetch all workouts
    List<WorkoutDTO> getAllWorkouts();

    // fetch workout by workoutid
    WorkoutDTO getWorkoutByWorkoutid(Long workoutid);

    // fetch workout(s) by userid
    List<WorkoutDTO> getWorkoutsByUserfk(String userfk);

    // fetch workout(s) by exerciseid
    List<WorkoutDTO> getWorkoutsByExercisefk(Long exercisefk);

    // update a workout
    WorkoutDTO updateWorkout(Long workoutid, WorkoutDTO workoutDTO);

    // create workout
    WorkoutDTO createWorkout(WorkoutCreateDTO workoutCreateDTO);

    // delete workout
    void deleteWorkoutById(Long workoutid);
}
