package com.myproject.mapper;

import com.myproject.dto.WorkoutCreateDTO;
import com.myproject.dto.WorkoutDTO;
import com.myproject.model.Exercise;
import com.myproject.model.User;
import com.myproject.model.Workout;

public class WorkoutMapper {

    public static WorkoutDTO toDTO(Workout workout) {
        return WorkoutDTO.builder()
                .workoutid(workout.getWorkoutid())
                .title(workout.getTitle())
                .content(workout.getContent())
                .workoutdate(workout.getWorkoutdate())
                .userid(workout.getUserfk().getUserid())
                .exerciseid(workout.getExercisefk().getExerciseid())
                .build();
    }

    public static Workout toEntity(WorkoutDTO dto, User user, Exercise exercise) {
        return Workout.builder()
                .workoutid(dto.getWorkoutid())
                .title(dto.getTitle())
                .content(dto.getContent())
                .workoutdate(dto.getWorkoutdate())
                .userfk(user)
                .exercisefk(exercise)
                .build();
    }

    //new for workoutCreateDTO
    public static Workout toEntity(WorkoutCreateDTO dto, User user, Exercise exercise) {
        return Workout.builder()
                .title(dto.getTitle())
                .content(dto.getContent())
                .workoutdate(dto.getWorkoutdate())
                .userfk(user)
                .exercisefk(exercise)
                .build();
    }
}
