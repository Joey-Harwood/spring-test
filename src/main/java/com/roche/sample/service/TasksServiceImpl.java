package com.roche.sample.service;

import com.roche.sample.model.Tasks;
import com.roche.sample.repository.TasksRepository;
import com.roche.sample.service.TasksService;

import java.util.Optional;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TasksServiceImpl implements TasksService {

  @Autowired private TasksRepository tasksRepository;

  @Override
  public Tasks createTasks(Tasks tasks) {
    return this.tasksRepository.save(tasks);
  }

  @Override
  public Tasks getTasks(UUID tasksId) {
    Optional<Tasks> optionalTasks= tasksRepository.findById(tasksId);
    if (optionalTasks.isPresent()) {
      return optionalTasks.get();
    } else {
        throw new RuntimeException("tasks not found with id: " + tasksId);
    }
  }

  // @Override
  // public Tasks patchTasks(UUID tasksId, Tasks tasks) {
  //   Optional<Tasks> optionalTasks= tasksRepository.findById(tasksId);
  //   if (optionalTasks.isPresent()) {
  //     tasks = optionalTasks.get();
  //   } else {
  //       throw new RuntimeException("tasks not found with id: " + tasksId);
  //   }
  //   return tasks;
  // }

  @Override
  public void deleteTasks(UUID tasksId) {
    this.tasksRepository.deleteById(tasksId);
  }

}