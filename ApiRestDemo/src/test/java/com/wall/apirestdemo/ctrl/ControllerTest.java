/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wall.apirestdemo.ctrl;

import com.wall.apirestdemo.bll.TaskDAO;
import com.wall.apirestdemo.el.Task;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.verify;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

/**
 *
 * @author wal_r
 */
@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private TaskDAO taskDAO;

    @InjectMocks
    private Controller controller;

    private List<Task> tasks;

    private Task task;

    @Before
    public void setUp() {
        /* Initialize mock objects */
        MockitoAnnotations.initMocks(this);

        /* Create sample task data */
        task = new Task(1, "Sample task", "This is a sample task");

        /* Create sample task list */
        tasks = new ArrayList<>();
        tasks.add(task);
    }

    @Test
    public void testDoGet() throws Exception {
        /* Set up mock behavior */
        when(taskDAO.getAllTasks()).thenReturn(tasks);
        when(request.getRequestDispatcher("/index.jsp")).thenReturn((jakarta.servlet.RequestDispatcher) dispatcher);

        /* Execute test */
        controller.doGet(request, response);

        /* Verify mock behavior */
        verify(request).setAttribute("tasks", tasks);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost() throws Exception {
        /* Set up mock behavior */
        when(request.getParameter("title")).thenReturn(task.getTitulo());
        when(request.getParameter("description")).thenReturn(task.getDescripcion());

        /* Execute test */
        controller.doPost(request, response);

        /* Verify mock behavior */
        verify(taskDAO).addTask(any(Task.class));
        verify(response).sendRedirect(request.getContextPath() + "/Controller");
    }

    @Test
    public void testDoPut() throws Exception {
        /* Set up mock behavior */
        when(request.getParameter("id")).thenReturn(String.valueOf(task.getId()));
        when(request.getParameter("title")).thenReturn("Updated task title");
        when(request.getParameter("description")).thenReturn("This is an updated task description");

        /* Execute test */
        controller.doPut(request, response);

        /* Verify mock behavior */
        verify(taskDAO).updateTask(any(Task.class));
        verify(response).sendRedirect(request.getContextPath() + "/Controller");
    }

    @Test
    public void testDoDelete() throws Exception {
        /* Set up mock behavior */
        when(request.getParameter("id")).thenReturn(String.valueOf(task.getId()));

        /* Execute test */
        controller.doDelete(request, response);

        /* Verify mock behavior */
        verify(taskDAO).deleteTask(task.getId());
        verify(response).sendRedirect(request.getContextPath() + "/Controller");
    }
}