<%-- 
    Document   : index
    Created on : 1 may. 2023, 07:49:19
    Author     : wal_r
--%>
    
<%@page contentType="text/html" pageEncoding="windows-1252"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%
    String applicationPath = request.getContextPath();
%>
<!DOCTYPE html>
<html lang="es">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<link href="./resource/css/style.css" rel="stylesheet" type="text/css"/>
<script src="https://code.jquery.com/jquery-3.5.0.js"></script>
    <title>ApiRestDemo</title>
</head>
<body>
    <form action="<% out.write(applicationPath); %>/Controller" method="GET">
        <input type="submit" value="Obtener la lista de deberes">
        <table class="table table-dark table-striped">
        <thead>
          <tr>
            <th scope="col">#</th>
            <th scope="col">Tarea</th>
            <th scope="col">Descripción</th>
          </tr>
        </thead>
        <tbody class = "bodyTable">
          <c:forEach items="${tasks}" var="task">
            <tr>
                <td>${task.id}</td>
                <td>${task.titulo}</td>
                <td>${task.descripcion}</td>
            </tr>
        </c:forEach>
        </tbody>
      </table>
    </form>

    
            
      <a class="btn btn-primary" href="./view/addTask.jsp" role="button">Agregar nueva tarea</a>
      <a class="btn btn-primary" href="./view/updateTask.jsp" role="button">Actualizar tarea</a>
      <a class="btn btn-danger" href="./view/deleteTask.jsp" role="button">Eliminar tarea</a>

      <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
      <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    </body>
</html>
