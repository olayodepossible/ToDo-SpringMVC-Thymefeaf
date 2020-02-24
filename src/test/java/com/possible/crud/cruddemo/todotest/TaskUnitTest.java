package com.possible.crud.cruddemo.todotest;


import static org.assertj.core.api.Assertions.assertThat;

import com.possible.crud.cruddemo.entities.Todo;
import org.junit.Test;

public class TaskUnitTest {
        @Test
        public void whenCalledGetTitle_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            assertThat(task.getTitle()).isEqualTo("Gim");
        }

        @Test
        public void whenCalledGetDescription_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            assertThat(task.getDescription()).isEqualTo("Time to Exercise");
        }

        @Test
        public void whenCalledSetTitle_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            task.setTitle("Code");

            assertThat(task.getTitle()).isEqualTo("Code");
        }

        @Test
        public void whenCalledSetDescription_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            task.setDescription("We are Coding now");

            assertThat(task.getDescription()).isEqualTo("We are Coding now");
        }

        @Test
        public void whenCalledToString_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");
            assertThat(task.toString()).isEqualTo("Todo{title='Gim', description='Time to Exercise'}");
        }

}
