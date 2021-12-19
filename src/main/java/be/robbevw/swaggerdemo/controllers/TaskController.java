package be.robbevw.swaggerdemo.controllers;

import be.robbevw.swaggerdemo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApiDelegate;
import org.openapitools.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskController implements TasksApiDelegate {

    private final TaskService taskService;

    @Override
    public ResponseEntity<List<Task>> tasksGet() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Override
    public ResponseEntity<Task> tasksIdGet(Long id) {
        Optional<Task> task = taskService.findById(id);

        return ResponseEntity.of(task);
    }

    @Override
    public ResponseEntity<Void> tasksPost(Task task) {
        taskService.save(task);

        return ResponseEntity.ok().build();
    }
}
