package com.possible.crud.cruddemo.controllers;

import com.possible.crud.cruddemo.entities.Todo;
import com.possible.crud.cruddemo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;

@Controller
public class ToDoController {
    private ToDoRepository toDoRepository;

    @Autowired
    public void ToDoRepository(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    @GetMapping(path = "/add") //This is to re-direct
    public String addTask(Model model) {
        Todo task = new Todo();
        model.addAttribute("todo", task);
        return "addTodo";
    }
    @GetMapping(path = "/add2") //This is to re-direct
    public String addTask2(Model model) {
        Todo task = new Todo();
        model.addAttribute("todo", task);
        return "addTodo";
    }

    @PostMapping(path = "/taskList")
    public String addToDo(@Valid Todo task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            return "addTodo";
        }

        toDoRepository.save(task);
        model.addAttribute("tasks", toDoRepository.findAll());
        return "taskList";
    }

    @GetMapping(path = "/taskList")
    public String showTaskList(Model model){
        Todo task = new Todo();
        model.addAttribute("tasks", toDoRepository.findAll());
        return "taskList";
    }

    @GetMapping(path = "/edit/{id}")
    public String showUpdateForm(@PathVariable(value = "id") String id, Model model) {
        model.addAttribute("task", toDoRepository.findById(id).get());
        return "updateTask";
    }

    @PostMapping(path = "/update/{id}")
    public String updateUser(@PathVariable("id") String id, @Valid Todo task, BindingResult result, Model model) {
        if (result.hasErrors()) {
            task.setId(id);
            return "updateTask";
        }

        toDoRepository.save(task);
        model.addAttribute("tasks", toDoRepository.findAll());
        return "redirect:/taskList";
    }

    @GetMapping(path = "/delete/{id}")
    public String deleteUser(@PathVariable("id") String id, Model model) {
        Todo task = toDoRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("Invalid user Id:" + id));
        toDoRepository.delete(task);
        model.addAttribute("users", toDoRepository.findAll());
        return "redirect:/taskList";
    }

}

