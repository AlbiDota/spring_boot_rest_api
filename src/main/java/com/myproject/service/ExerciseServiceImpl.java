package com.myproject.service;

import com.myproject.model.Exercise;
import com.myproject.repository.ExerciseRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExerciseServiceImpl implements ExerciseService{

    @Autowired
    private ExerciseRepository exerciseRepository;

    // ------ GET -------
    @Override
    public List<Exercise> getAllExercises() { return exerciseRepository.findAll(); }

    @Override
    public List<Exercise> getExercisesByNameLike(String name){
        return exerciseRepository.findByNameContainingIgnoreCase(name);
    }

    // ------ PUT -------
    @Override
    public Exercise updateExercise(Long exerciseid, Exercise updatedExercise) {
        return exerciseRepository.findById(exerciseid).map(
                exercise -> {
                    exercise.setName(updatedExercise.getName());
                    exercise.setDescr(updatedExercise.getDescr());
                    return exerciseRepository.save(exercise);

                }).orElseThrow(() -> new RuntimeException("Exercise not found " + exerciseid));
    }

    // ------ POST -------
    @Override
    public Exercise createExercise(Exercise exercise) {
        return exerciseRepository.save(exercise);
    }


    // ------ DELETE -------
    @Override
    public void deleteExerciseById(Long exerciseid) {
        exerciseRepository.deleteById(exerciseid);
    }

}
