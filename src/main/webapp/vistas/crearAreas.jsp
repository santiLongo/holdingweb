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
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear"> 
        <title>Crear Area</title>
    </head>
    <body>
    
    <div class="contenedor">

        <div class="cabecera">
            <h2>Crear Area</h2>
        </div>

        <div class="contenido">

            <div class="input_group">
                <label for="nombreArea"> Nombre: </label>
                <input class="barra_texto" type="text" id="nombreArea" placeholder="Ingrese el nombre del area...">
            </div>

            <div class="input_group">
                <label for="descripcion"> Descripción: </label>
                <input class="barra_texto grande" type="text" id="descripcion" placeholder=" Ingrese una descripción del area....">
            </div>

        </div>

        <div>

            <form method="get" action="#">
    
                <input class="boton" type="submit" value="Cancelar y Cerrar">
                <input class="boton" type="button"  type="submit" value="Aceptar y Crear">
    
            </form>
          
       
        </div>

    </div>

</html>
