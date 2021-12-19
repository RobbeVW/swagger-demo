package be.robbevw.swaggerdemo.services;

import org.openapitools.model.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> findAll();

    Optional<Task> findById(long id);

    void save(Task task);
}
