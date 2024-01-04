package com.roche.sample.service;

import com.roche.sample.model.Tasks;

import java.util.UUID;

public interface TasksService {

  public Tasks createTasks(Tasks tasks);
  public Tasks getTasks(UUID tasksId);
  // public Tasks patchTasks(UUID tasksId, Tasks tasks);
  public void deleteTasks(UUID tasksId);

}