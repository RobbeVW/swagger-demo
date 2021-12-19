package be.robbevw.swaggerdemo.services;

import be.robbevw.swaggerdemo.openapi.model.Task;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
class TaskServiceImpl implements TaskService {

    private static final List<Task> tasks = new ArrayList<>();

    public TaskServiceImpl() {
        populateTasks();
    }

    private static void populateTasks() {
        TaskServiceImpl.tasks.add(new Task().id(0L)
                .title("Prepare OpenAPI pitch")
                .dateCreated(LocalDateTime.parse("2020-01-01T08:00"))
                .description("I need to prepare a pitch for my communication skills PE."));
        TaskServiceImpl.tasks.add(new Task().id(1L)
                .title("Prepare OpenAPI demo")
                .dateCreated(LocalDateTime.parse("2020-01-01T10:00"))
                .description("I need to prepare a demo for my communication skills PE."));
        TaskServiceImpl.tasks.add(new Task().id(2L)
                .title("Demonstrate OpenAPI")
                .dateCreated(LocalDateTime.parse("2020-01-01T12:00"))
                .description("I need to demonstrate OpenAPI to a group of people."));
    }

    @Override
    public List<Task> findAll() {
        return tasks;
    }

    @Override
    public Optional<Task> findById(long id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }

    @Override
    public void save(Task task) {
        tasks.add(task);
    }
}
