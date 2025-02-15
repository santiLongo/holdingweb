<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2> Crear Asesor</h2>
            </div>
            <form method="post" action="/inicio/altaAsesor">
            <div class="contenido">
                <div class="input_group">
                    <label for="usuario"> Usuario: </label>
                    <input class="barra_texto" type="text" id="usuario" name="usuario" placeholder="Ingrese el usuario del asesor...">
                </div>
                <div class="input_group">
                    <label for="contrasenia"> Contrasenia: </label>
                    <input class="barra_texto" type="text" id="contrasenia" name="contrasenia" placeholder="Ingrese el contrasenia del asesor...">
                </div>
                <div class="input_group">
                    <label for="nombreAsesor"> Nombre: </label>
                    <input class="barra_texto" type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del asesor...">
                </div>
                <div class="input_group">
                    <label for="direccion"> Dirección: </label>
                    <input class="barra_texto" type="text" id="direccion" name="direccion" placeholder="Ingrese la direccion del asesor...">
                </div>
            </div>
            <div class="contenido">
                <label for=""> Empresas:</label>
            </div>
            <div style="display: flex; gap: 10px;">
                <select id="empresasDisponibles" multiple>
                    <c:forEach var="empresa" items="${empresas}">
                        <option value="${empresa.getId()}"> ${empresa.nombre} </option>
                    </c:forEach>
                </select>
                <select id="empresasSeleccionadas" name="empresas" multiple></select>
                <div>
                    <button class="botonPasar" type="button" onclick="mover('empresasDisponibles', 'empresasSeleccionadas')">→</button>
                    <button class="botonPasar" type="button" onclick="mover('empresasSeleccionadas', 'empresasDisponibles')">←</button>
                </div>
                
            </div>
            <div class="contenido">
                <label for=""> Areas:</label>
            </div>
            <div style="display: flex; gap: 10px;">
                <select id="areasDisponibles" multiple>
                    <c:forEach var="area" items="${areas}">
                        <option value="${area.getId()}"> ${area.nombre} </option>
                    </c:forEach>
                </select>
                <select id="areasSeleccionadas" name="areas" multiple></select>
                <div>
                    <button class="botonPasar" type="button" onclick="mover('areasDisponibles', 'areasSeleccionadas')">→</button>
                    <button class="botonPasar" type="button" onclick="mover('areasSeleccionadas', 'areasDisponibles')">←</button>
                </div>
                
            </div>
            <br>
            <div>
                <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
                <input class="boton" type="submit" value="Aceptar y Crear">     
            </div>
            </form>
        </div>
        <script>
            function mover(origen, destino) {
                let selOrigen = document.getElementById(origen);
                let selDestino = document.getElementById(destino);

                Array.from(selOrigen.selectedOptions).forEach(opcion => {
                    selDestino.appendChild(opcion);
                });
            }
        </script>
    </body>
</html>
