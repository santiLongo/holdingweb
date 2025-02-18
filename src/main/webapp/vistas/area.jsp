<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>Area</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>${area.getNombre()}</h2>
            </div>
            <div class="contenido">
                <div class="muestra">
                    <h2>Descripcion:</h2>
                    <br>
                    <span>${area.getDescripcion()}</span>
                </div>
            </div>
            <input class="boton" type="button" onclick="window.history.back();" value="Salir">
        </div>
    </body>
</html>
