package be.robbevw.swaggerdemo.controllers;

import be.robbevw.swaggerdemo.services.TaskService;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import lombok.RequiredArgsConstructor;
import org.openapitools.api.TasksApiDelegate;
import org.openapitools.model.Task;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tasks")
@Service
public class TaskController implements TasksApiDelegate {

    private final TaskService taskService;

    @Override
    @GetMapping
    public ResponseEntity<List<Task>> tasksGet() {
        return ResponseEntity.ok(taskService.findAll());
    }

    @Override
    @GetMapping("/{id}")
    public ResponseEntity<Task> tasksIdGet(Long id) {
        Optional<Task> task = taskService.findById(id);

        return ResponseEntity.of(task);
    }

    @Override
    @PostMapping
    public ResponseEntity<Void> tasksPost(@ModelAttribute Task task) {
        taskService.save(task);

        return ResponseEntity.ok().build();
    }
}
