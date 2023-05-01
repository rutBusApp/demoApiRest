/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wall.apirestdemo.ctrl;

import com.wall.apirestdemo.bll.TaskDAO;
import com.wall.apirestdemo.el.Task;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import com.google.gson.Gson;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    TaskDAO taskDAO;

    public void init() {
        /* Initialize shared resources */
        taskDAO = new TaskDAO();
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        /* Pass the database connection to the action */
        init();
        /* Execute business logic */
        /* Retrieve tasks from API */
        List<Task> tasks = taskDAO.getAllTasks();

        /* Add tasks to request attributes */
        request.setAttribute("tasks", tasks);

        /* Forward the request to the appropriate view */
        RequestDispatcher dispatcher = request.getRequestDispatcher("/index.jsp");
        dispatcher.forward(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        init();
        /* Retrieve task details from form */
        String title = request.getParameter("title");
        String description = request.getParameter("description");

        /* Create new task object */
        Task task = new Task();
        task.setTitulo(title);
        task.setDescripcion(description);

        /* Save task to API */
        taskDAO.addTask(task);

        /* Redirect to GET method to display tasks */
        response.sendRedirect(request.getContextPath() + "/Controller");
        /* Forward the request to the appropriate view */
    }
    @Override
protected void doPut(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    init();
    /* Retrieve task details from form */
    int taskId = Integer.parseInt(request.getParameter("id"));
    String title = request.getParameter("title");
    String description = request.getParameter("description");

    /* Create new task object */
    Task task = new Task();
    task.setId(taskId);
    task.setTitulo(title);
    task.setDescripcion(description);

    /* Update task in API */
    taskDAO.updateTask(task);

    /* Redirect to GET method to display tasks */
    response.sendRedirect(request.getContextPath() + "/Controller");
}
@Override
protected void doDelete(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
    init();
    /* Retrieve task id */
    int taskId = Integer.parseInt(request.getParameter("id"));

    /* Delete task from API */
    taskDAO.deleteTask(taskId);

    /* Redirect to GET method to display tasks */
    response.sendRedirect(request.getContextPath() + "/Controller");
}

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}