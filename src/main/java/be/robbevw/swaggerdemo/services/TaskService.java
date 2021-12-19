package be.robbevw.swaggerdemo.services;

import be.robbevw.swaggerdemo.openapi.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();

    Optional<Task> findById(long id);

    void save(Task task);
}
