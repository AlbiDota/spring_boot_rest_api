package com.myproject.service;

import com.myproject.model.Workout;

import java.util.List;

public interface WorkoutService {

    // fetch all workouts
    List<Workout> getAllWorkouts();

    // fetch workout by workoutid
    Workout getWorkoutByWorkoutid(Long workoutid);

    // fetch workout(s) by userid
    List<Workout> getWorkoutsByUsers_id(Long users_id);

    // fetch workout(s) by exerciseid
    List<Workout> getWorkoutsByExercises_id(Long exercises_id);

    // update a workout
    Workout updateWorkout(Long workoutid, Workout workout);

    // create workout
    Workout createWorkout(Workout workout);

    // delete workout
    void deleteWorkoutById(Long workout_id);
}
