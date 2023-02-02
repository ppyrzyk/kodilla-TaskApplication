package com.crud.tasks.controller;

import com.crud.tasks.domain.Task;
import com.crud.tasks.domain.TaskDto;
import com.crud.tasks.mapper.TaskMapper;
import com.crud.tasks.service.DbService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v1/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final DbService service;
    private final TaskMapper taskMapper;

    @GetMapping
    public List<TaskDto> getTasks() {
        List<Task> tasks = service.getAllTasks();
        return taskMapper.mapToTaskDtoList(tasks);
    }
    @GetMapping(value = "{taskId}")
    public TaskDto getTask(@PathVariable Long taskId) {
        return new TaskDto(1L, "test title", "test content");
    }
    @DeleteMapping(value = "{deletingTask}")
    public void deleteTask(Long taskId, @PathVariable String deletingTask) {

    }
    @PutMapping(value = "{updateTask}")
    public TaskDto updateTask(@PathVariable String updateTask) {
        return new TaskDto(1L,"Edited test title", "Test content");
    }
    @PostMapping(value = "{createTask}")
    public TaskDto createTask(TaskDto taskDto, @PathVariable String createTask) {
        return new TaskDto(2L, "Creating test", "testing creation");

    }

}
