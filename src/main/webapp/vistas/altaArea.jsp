<%-- 
    Document   : crearAreas
    Created on : 11 feb. 2025, 20:10:00
    Author     : Rocco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css"> 
        <title>Crear Area</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>Crear Area</h2>
            </div>
            <form method="post" action="/inicio/altaArea">
            <div class="contenido">
                <div class="input_group">
                    <label for="nombreArea"> Nombre: </label>
                    <input class="barra_texto" type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del area...">
                </div>
                <div class="input_group">
                    <label for="descripcion"> Descripción: </label>
                    <textarea class="barra_texto grande" id="descripcion" name="descripcion" placeholder="Ingrese una descripción del área..."></textarea>
                </div>
            </div>
            <div>
                <input type="hidden" name="redirect" value="<%= request.getParameter("redirect") %>">
                <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
                <input class="boton" type="submit" value="Aceptar y Crear">     
            </div>
            </form>
        </div>
</html>