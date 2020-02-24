package com.possible.crud.cruddemo.repository;

import com.possible.crud.cruddemo.entities.Todo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ToDoRepository extends JpaRepository<Todo, String> {
}
