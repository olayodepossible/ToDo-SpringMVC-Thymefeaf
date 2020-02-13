package com.possible.crud.cruddemo;

import com.possible.crud.cruddemo.entities.Todo;
import com.possible.crud.cruddemo.repository.ToDoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

import java.time.LocalDate;

@SpringBootApplication
public class CrudDemoApplication implements CommandLineRunner {

    private ToDoRepository toDoRepository;
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate restTemplate(){
        return  new RestTemplate();
    }

    @Autowired
    public void ToDoRepository(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }

    public static void main(String[] args) {
        SpringApplication.run(CrudDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        Todo task1 = new Todo();
        task1.setTitle("Exercise");
        task1.setDescription("Going to Jim");
        task1.setTaskStatus("Pending");

        Todo task2 = new Todo();
        task2.setTitle("Learning");
        task2.setDescription("Going to code");
        task2.setTaskStatus("Pending");

        Todo task3 = new Todo();
        task3.setTitle("Breakfast");
        task3.setDescription("Going to Eat");
        task3.setTaskStatus("Pending");

        toDoRepository.save(task1);
        toDoRepository.save(task2);
        toDoRepository.save(task3);

        /*Todo taskFromRestTemplate = restTemplate*/

    }
}
