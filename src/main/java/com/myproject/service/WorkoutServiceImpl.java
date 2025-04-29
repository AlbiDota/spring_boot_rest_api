package com.myproject.service;

import com.myproject.dto.WorkoutCreateDTO;
import com.myproject.dto.WorkoutDTO;
import com.myproject.mapper.WorkoutMapper;
import com.myproject.model.Exercise;
import com.myproject.model.User;
import com.myproject.model.Workout;
import com.myproject.repository.ExerciseRepository;
import com.myproject.repository.UserRepository;
import com.myproject.repository.WorkoutRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutServiceImpl implements WorkoutService{

    @Autowired
    private WorkoutRepository workoutRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ExerciseRepository exerciseRepository;


    // ------ GET -------
    @Override
    public List<WorkoutDTO> getAllWorkouts() {
        return workoutRepository.findAll().stream()
                .map(WorkoutMapper::toDTO)
                .toList();
    }

    @Override
    public WorkoutDTO getWorkoutByWorkoutid(Long workoutid) {
        Workout workout = workoutRepository.findByWorkoutid(workoutid);
        return WorkoutMapper.toDTO(workout);
    }

    @Override
    public List<WorkoutDTO> getWorkoutsByUserfk(String userfk) {
        return workoutRepository.findAllByUserfk_Userid(userfk).stream()
                .map(WorkoutMapper::toDTO)
                .toList();
    }

    @Override
    public List<WorkoutDTO> getWorkoutsByExercisefk(Long exercisefk) {
        return workoutRepository.findAllByExercisefk_Exerciseid(exercisefk).stream()
                .map(WorkoutMapper::toDTO)
                .toList();
    }



    // ------ PUT -------
    @Override
    public WorkoutDTO updateWorkout(Long workoutid, WorkoutDTO workoutDTO) {
        Workout workout = workoutRepository.findById(workoutid)
                .orElseThrow(() -> new RuntimeException("Workout not found " + workoutid));

        workout.setTitle(workoutDTO.getTitle());
        workout.setContent(workoutDTO.getContent());
        workout.setWorkoutdate(workoutDTO.getWorkoutdate());

        // if user is detected, we update. otherwise we keep it as is
        if (workoutDTO.getUserid() != null) {
            User user = userRepository.findById(workoutDTO.getUserid())
                    .orElseThrow(() -> new RuntimeException("User not found "));
            workout.setUserfk(user);
        }

        Exercise exercise = exerciseRepository.findById(workoutDTO.getExerciseid())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));
        workout.setExercisefk(exercise);

        return WorkoutMapper.toDTO(workoutRepository.save(workout));
    }

    // ------ POST -------
    @Override
    public WorkoutDTO createWorkout(WorkoutCreateDTO workoutCreateDTO) {
        User user = userRepository.findById(workoutCreateDTO.getUserid())
                .orElseThrow(() -> new RuntimeException("User not found"));
        Exercise exercise = exerciseRepository.findById(workoutCreateDTO.getExerciseid())
                .orElseThrow(() -> new RuntimeException("Exercise not found"));

        Workout workout = WorkoutMapper.toEntity(workoutCreateDTO, user, exercise);
        Workout savedWorkout = workoutRepository.save(workout);
        return WorkoutMapper.toDTO(savedWorkout);
    }

    // ------ DELETE -------
    @Override
    public void deleteWorkoutById(Long workoutid) {
        workoutRepository.deleteById(workoutid);
    }

}
