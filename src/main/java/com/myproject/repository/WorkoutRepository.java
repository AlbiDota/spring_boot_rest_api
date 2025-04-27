package com.myproject.repository;

import com.myproject.model.Workout;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    // ------ GET -------
    List<Workout> findAll();
    Workout findByWorkout_id(Long workout_id);
    List<Workout> findAllByUsers_id(Long users_id); //workouts av en spesifikk bruker
    List<Workout> findAllByExercises_id(Long exercises_id); //alle workouts av spesifikk øvelse

    // ------ PUT -------
    // ------ POST -------

    // ------ DELETE -------
    @Modifying
    @Transactional
    void deleteById(Long workout_id);
}
