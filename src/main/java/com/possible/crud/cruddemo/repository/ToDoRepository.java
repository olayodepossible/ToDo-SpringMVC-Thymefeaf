package com.possible.crud.cruddemo.repository;

import com.possible.crud.cruddemo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ToDoRepository extends JpaRepository<Todo, String> {
}
