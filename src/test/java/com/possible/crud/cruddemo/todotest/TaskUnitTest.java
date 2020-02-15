package com.possible.crud.cruddemo.todotest;


import static org.assertj.core.api.Assertions.assertThat;

import com.possible.crud.cruddemo.entities.Todo;
import org.junit.Test;

public class TaskUnitTest {
        @Test
        public void whenCalledGetName_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            assertThat(task.getTitle()).isEqualTo("Gim");
        }

        @Test
        public void whenCalledGetEmail_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            assertThat(task.getDescription()).isEqualTo("Time to Exercise");
        }

        @Test
        public void whenCalledSetName_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            task.setTitle("Code");

            assertThat(task.getTitle()).isEqualTo("Code");
        }

        @Test
        public void whenCalledSetEmail_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            task.setDescription("We are Coding now");

            assertThat(task.getDescription()).isEqualTo("We are Coding now");
        }

        @Test
        public void whenCalledtoString_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");
            assertThat(task.toString()).isEqualTo("Todos{id=null, title='Gim', description='Time to Exercise', taskStatus='null', createdAt=null, updatedAt=null}");
        }

}
