package com.myproject.service;
import com.myproject.model.Exercise;

import java.util.List;

public interface ExerciseService {

    // fetch all exercises
    List<Exercise> getAllExercises();

    // fetch by name
    List<Exercise> getExercisesByNameLike(String name);

    // update an exercise
    Exercise updateExercise(Long exerciseid, Exercise exercise);

    // create exercise
    Exercise createExercise(Exercise exercise);

    //delete an exercise by id
    void deleteExerciseById(Long exerciseid);
}
