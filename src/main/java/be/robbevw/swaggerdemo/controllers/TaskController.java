package be.robbevw.swaggerdemo.controllers;

import be.robbevw.swaggerdemo.openapi.api.TasksApi;
import be.robbevw.swaggerdemo.openapi.model.Task;
import be.robbevw.swaggerdemo.services.TaskService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
public class TaskController implements TasksApi {

    private final TaskService taskService;

    @Override
    public ResponseEntity<List<Task>> findAllTasks() {
        List<Task> tasks = taskService.findAll();

        return ResponseEntity.ok(tasks);
    }

    @Override
    public ResponseEntity<Task> findTaskById(Long id) {
        Optional<Task> task = taskService.findById(id);

        return ResponseEntity.of(task);
    }

    @Override
    public ResponseEntity<Void> saveTask(Task task) {
        taskService.save(task);

        return ResponseEntity.ok().build();
    }
}
