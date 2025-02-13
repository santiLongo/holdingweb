<%-- 
    Document   : crearPais
    Created on : 11 feb. 2025, 20:07:37
    Author     : Rocco
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear"> 
        <title>Crear Pais</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>Crear Pais</h2>
            </div>
            <form method="post" action="/inicio/altaPais">
                <div class="contenido">
                    <div class="input_group">
                        <label for="nombre"> Nombre: </label>
                        <input class="barra_texto" type="text" id="nombre" name="nombre" placeholder="Ingrese un País...">
                    </div>
                    <div class="input_group">
                        <label for="capital"> Capital: </label>
                        <input class="barra_texto" type="text" id="capital" name="capital" placeholder="Ingrese la Capital del Pais..."">
                    </div>
                    <div class="input_group">
                        <label for="cant_habitantes"> Habitantes: </label>
                        <input class="barra_texto" type="text" id="cantidadHabitantes" name="cantidadHabitantes" placeholder="Ingrese la cantidad de habitantes del pais...">
                    </div>
                    <div class="input_group">
                        <label for="pbi"> PBI: </label>
                        <input class="barra_texto" type="text" id="pbi" name="pbi" placeholder="Ingrese el pbi del pais...">
                    </div>
                </div>
                <div>
                    <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
                    <input class="boton" type="submit" value="Aceptar y Crear">
                </div>
            </form>
        </div>
    </body>
</html>