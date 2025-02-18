<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>Pais</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>${pais.getNombre()}</h2>
            </div>
            <div class="contenido">
                <label>Capital:</label>
                <div class="muestra">
                    <span>${pais.getCapital()}</span>
                </div>
                <label>PBI:</label>
                <div class="muestra">
                    <span>${pais.getPbi()*1000000}</span>
                </div>
                <label>Cantidad de habitantes:</label>
                <div class="muestra">
                    <span>${pais.getCantHabitantes()}</span>
                </div>
            </div>
            <input class="boton" type="button" onclick="window.history.back();" value="Salir">
        </div>
    </body>
</html>
