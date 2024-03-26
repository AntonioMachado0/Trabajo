<%-- 
    Document   : y
    Created on : 15 mar. 2024, 22:28:48
    Author     : Jonathan Flores
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Reserva de Corte de Pelo</title>
</head>
<body>
    <h1>Reserva de Corte de Pelo</h1>
    
    <%-- Obtener el ID del corte de pelo --%>
    <% String idCorte = request.getParameter("idCorte"); %>
    
    <%-- Mostrar el ID del corte de pelo --%>
    <p>Seleccionaste el corte de pelo con ID: <%= idCorte %></p>
    
     <h1>Reservar Cita</h1>
    
    <form action="ProcesarReservaServlet" method="post">
        <label for="fecha">Fecha:</label>
        <input type="date" id="fecha" name="fecha" required><br><br>
        
        <label for="hora">Hora:</label>
        <input type="time" id="hora" name="hora" required><br><br>
        
        <label for="estado">Estado:</label>
        <select id="estado" name="estado" required>
            <option value="Pendiente">Pendiente</option>
            <option value="Confirmada">Confirmada</option>
            <option value="Cancelada">Cancelada</option>
        </select><br><br>
        
        <label for="idCliente">ID Cliente:</label>
        <input type="text" id="idCliente" name="idCliente" required><br><br>
        
        <label for="idCorte">ID Corte:</label>
        <input type="text" id="idCorte" name="idCorte" Value="<%= idCorte %>" readonly required><br><br>
        
        <label for="idUsuario">ID Usuario:</label>
        <input type="text" id="idUsuario" name="idUsuario" enable required><br><br>
        
        <button type="submit">Reservar</button>
    </form>
</body>
</html>

