package com.roche.sample.repository;

import com.roche.sample.model.Tasks;

import java.util.UUID;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

// Rename models to persistence and otherwise make singular

@Repository
public interface TasksRepository extends CrudRepository<Tasks, UUID> {

}