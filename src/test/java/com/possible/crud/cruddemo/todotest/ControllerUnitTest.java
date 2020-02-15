
package com.possible.crud.cruddemo.todotest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import com.possible.crud.cruddemo.controllers.ToDoController;
import com.possible.crud.cruddemo.entities.Todo;
import com.possible.crud.cruddemo.repository.ToDoRepository;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;


public class ControllerUnitTest {

        private static ToDoController toDoController;
        private static ToDoRepository mockedTodoRepository;
        private static BindingResult mockedBindingResult;
        private static Model mockedModel;

        @BeforeClass
        public static void setUpUserControllerInstance() {
            mockedTodoRepository = mock(ToDoRepository.class);
            mockedBindingResult = mock(BindingResult.class);
            mockedModel = mock(Model.class);
            toDoController = new ToDoController();
        }

        @Test
        public void whenCalledshowAddTaskForm_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            assertThat(toDoController.addTask(mockedModel)).isEqualTo("addTodo");
        }

        @Test
        public void whenCalledaddTask() {
            Todo task = new Todo("Gim", "Time to Exercise");

            when(mockedBindingResult.hasErrors()).thenReturn(false);

            assertThat(toDoController.addToDo(task, mockedBindingResult, mockedModel)).isEqualTo("taskList");
        }

        @Test
        public void whenCalledaddTaskAndInValidUser_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            when(mockedBindingResult.hasErrors()).thenReturn(true);

            assertThat(toDoController.showTaskList( mockedModel)).isEqualTo("taskList");
        }

        @Test(expected = IllegalArgumentException.class)
        public void whenCalledshowUpdateForm_thenIllegalArgumentException() {
            assertThat(toDoController.showUpdateForm("ff8080817049827a017049827d720000", mockedModel)).isNotEqualTo("updateTask");
        }

        @Test
        public void whenCalledupdateTaskAndValidUser_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            when(mockedBindingResult.hasErrors()).thenReturn(false);

            assertThat(toDoController.showUpdateForm("ff8080817049827a017049827d720000",  mockedModel)).isEqualTo("updateTask");
        }

        @Test
        public void whenCalledupdateUserAndInValidUser_thenCorrect() {
            Todo task = new Todo("Gim", "Time to Exercise");

            when(mockedBindingResult.hasErrors()).thenReturn(true);

            assertThat(toDoController.updateTask("ff8080817049827a017049827d720000", task, mockedBindingResult, mockedModel)).isEqualTo("updateTask");
        }

        @Test(expected = IllegalArgumentException.class)
        public void whenCalleddeleteUser_thenIllegalArgumentException() {
            assertThat(toDoController.deleteTask("ff8080817049827a017049827d720000", mockedModel)).isEqualTo("taskList");
        }

}

