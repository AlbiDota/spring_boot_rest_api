package com.myproject.service;

import com.myproject.model.Workout;
import com.myproject.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    private WorkoutRepository workoutRepository;

    // ------ GET -------
    @Override
    public List<Workout> getAllWorkouts() { return workoutRepository.findAll(); }

    @Override
    public Workout getWorkoutByWorkoutid(Long workoutid) {
        return workoutRepository.findByWorkout_id(workoutid);
    }

    @Override
    public List<Workout> getWorkoutsByUsers_id(Long users_id) {
        return workoutRepository.findAllByUsers_id(users_id);
    }

    @Override
    public List<Workout> getWorkoutsByExercises_id(Long exercises_id) {
        return workoutRepository.findAllByExercises_id(exercises_id);
    }



    // ------ PUT -------
    @Override
    public Workout updateWorkout(Long workoutid, Workout updatedWorkout) {
        return workoutRepository.findById(workoutid).map(
                workout -> {
                    workout.setTitle(updatedWorkout.getTitle());
                    workout.setContent(updatedWorkout.getContent());
                    workout.setWorkoutDate(updatedWorkout.getWorkoutDate());
                    workout.setUser(updatedWorkout.getUser());
                    workout.setExercise(updatedWorkout.getExercise());
                    return workoutRepository.save(workout);
                }).orElseThrow(() -> new RuntimeException("Workout not found " + workoutid));
    }

    // ------ POST -------
    @Override
    public Workout createWorkout(Workout workout) {
        return workoutRepository.save(workout);
    }

    // ------ DELETE -------
    @Override
    public void deleteWorkoutById(Long workoutid) {
        workoutRepository.deleteById(workoutid);
    }

}
