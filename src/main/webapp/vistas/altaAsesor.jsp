<%-- 
    Document   : altaAsesor
    Created on : 13 feb. 2025, 23:49:22
    Author     : Rocco
--%>

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

        <div class="contenido">

            <div class="input_group">
                <label for="nombreVendedor"> Nombre: </label>
                <input class="barra_texto" type="text" id="nombreVendedor" placeholder="Ingrese el nombre del vendedor...">
            </div>

            <div class="input_group">
                <label for="direccion"> Dirección: </label>
                <input class="barra_texto" type="text" id="direccion" placeholder="Ingrese la direccion del vendedor...">
            </div>

        </div>

        <div class="contenido">

            <label for=""> Empresas:</label>
            
        </div>

        <div style="display: flex; gap: 10px;">
            <select id="disponibles" multiple>
                <option value="opcion1">Opción 1</option>
                <option value="opcion2">Opción 2</option>
                <option value="opcion3">Opción 3</option>
                <option value="opcion4">Opción 4</option>
            </select>
            
            <div>
                <button class="botonPasar" onclick="mover('disponibles', 'seleccionadas')">→</button>
                <button class="botonPasar" onclick="mover('seleccionadas', 'disponibles')">←</button>
            </div>
            
            <select id="seleccionadas" multiple></select>
        </div>


        <div class="contenido">

            <label for=""> Areas:</label>
            
        </div>

        <div style="display: flex; gap: 10px;">
            <select id="AreaDisponibles" multiple>
                <option value="opcion1">Opción 1</option>
                <option value="opcion2">Opción 2</option>
                <option value="opcion3">Opción 3</option>
                <option value="opcion4">Opción 4</option>
            </select>
            
            <div>
                <button class="botonPasar" onclick="mover('AreaDisponibles', 'AreaSeleccionadas')">→</button>
                <button class="botonPasar" onclick="mover('AreaSeleccionadas', 'AreaDisponibles')">←</button>
            </div>
            
            <select id="AreaSeleccionadas" multiple></select>
        </div>

        <br>

        <div>
            <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
            <input class="boton" type="submit" value="Aceptar y Crear">     
        </div>

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
