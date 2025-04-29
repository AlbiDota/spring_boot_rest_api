package com.myproject.repository;

import com.myproject.dto.WorkoutDTO;
import com.myproject.model.Workout;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;

import java.util.List;

public interface WorkoutRepository extends JpaRepository<Workout, Long> {

    // ------ GET -------
    List<Workout> findAll();
    Workout findByWorkoutid(Long workoutid);

    List<Workout> findAllByUserfk_Userid(String userfk);
    List<Workout> findAllByExercisefk_Exerciseid(Long exerciseid); //alle workouts av spesifikk øvelse

    // ------ PUT -------
    // ------ POST -------

    // ------ DELETE -------
    @Modifying
    @Transactional
    void deleteById(Long workoutid);
}
