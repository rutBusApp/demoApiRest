/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.wall.apirestdemo.bll;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import com.google.gson.Gson;
import com.wall.apirestdemo.el.Task;
import com.google.gson.Gson;
import java.io.OutputStreamWriter;

public class TaskDAO {

    private String baseUrl;

    public TaskDAO(String baseUrl) {
        this.baseUrl = baseUrl;
    }

    public TaskDAO() {
        this.baseUrl = "http://localhost:8081";
    }

    public List<Task> getAllTasks() throws IOException {
        URL url = new URL(baseUrl + "/tasks");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("GET");

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();

        Gson gson = new Gson();
        Task[] tasks = gson.fromJson(response.toString(), Task[].class);
        List<Task> taskList = new ArrayList<>();
        for (Task task : tasks) {
            taskList.add(task);
            System.out.println(""+ task.getTitulo());
        }

        return taskList;
    }

    public void addTask(Task task) throws IOException {
        URL url = new URL(baseUrl + "/savetask");
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("POST");
        connection.setRequestProperty("Content-Type", "application/json");
        connection.setDoOutput(true);

        Gson gson = new Gson();
        String json = gson.toJson(task);

        OutputStream outputStream = connection.getOutputStream();
        outputStream.write(json.getBytes());
        outputStream.flush();

        BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
        StringBuilder response = new StringBuilder();
        String line;

        while ((line = reader.readLine()) != null) {
            response.append(line);
        }

        reader.close();
        connection.disconnect();
    }
     public void updateTask(Task task) throws IOException {
        URL url = new URL(baseUrl + "/update/" + task.getId());
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("PUT");
        connection.setDoOutput(true);
        connection.setRequestProperty("Content-Type", "application/json");

        Gson gson = new Gson();
        String jsonTask = gson.toJson(task);
        OutputStreamWriter writer = new OutputStreamWriter(connection.getOutputStream());
        writer.write(jsonTask);
        writer.flush();
        writer.close();

        connection.disconnect();
    }

    public void deleteTask(int id) throws IOException {
        URL url = new URL(baseUrl + "/delete/" + id);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();
        connection.setRequestMethod("DELETE");

        connection.disconnect();
    }
}
