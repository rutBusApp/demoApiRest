/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.wall.apirestdemo.bll;

import com.wall.apirestdemo.el.Task;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author wal_r
 */
public class TaskDAOTest {
    
    public TaskDAOTest() {
    }
    
    @BeforeAll
    public static void setUpClass() {
    }
    
    @AfterAll
    public static void tearDownClass() {
    }
    
    @BeforeEach
    public void setUp() {
    }
    
    @AfterEach
    public void tearDown() {
    }

    /**
     * Test of getAllTasks method, of class TaskDAO.
     */
    @Test
    public void testGetAllTasks() throws Exception {
        System.out.println("getAllTasks");
        TaskDAO instance = new TaskDAO();
        List<Task> expResult = null;
        List<Task> result = instance.getAllTasks();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addTask method, of class TaskDAO.
     */
    @Test
    public void testAddTask() throws Exception {
        System.out.println("addTask");
        Task task = null;
        TaskDAO instance = new TaskDAO();
        instance.addTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of updateTask method, of class TaskDAO.
     */
    @Test
    public void testUpdateTask() throws Exception {
        System.out.println("updateTask");
        Task task = null;
        TaskDAO instance = new TaskDAO();
        instance.updateTask(task);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteTask method, of class TaskDAO.
     */
    @Test
    public void testDeleteTask() throws Exception {
        System.out.println("deleteTask");
        int id = 0;
        TaskDAO instance = new TaskDAO();
        instance.deleteTask(id);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
