package com.myproject.repository;

import com.myproject.model.Exercise;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExerciseRepository extends JpaRepository<Exercise, Long> {

    List<Exercise> findAll();

    List<Exercise> findByNameContainingIgnoreCase(String name);

    @Modifying
    @Transactional
    void deleteById(Long exerciseid);

}
