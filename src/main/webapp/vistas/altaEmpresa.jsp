<%-- 
    Document   : altaEmpresa
    Created on : 11 feb. 2025, 21:30:48
    Author     : Rocco
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css"> 
        <title>Alta Empresa</title>
    </head>
    
    <body>
    <div class="contenedor">

        <div class="cabecera">

            <h2>Crear Empresa</h2>

        </div>

        <div class="contenido">

            <div class="input_group">

                <label for="nombre"> Razon Social: </label>
                <input class="barra_texto" type="text" id="nombre"  placeholder="Ingrese la razon social de la empresa...">
    
            </div>

            <div class="input_group">

                <label for="facturacion"> Facturación: </label>
                <input class="barra_texto" type="text" id="facturacion"  placeholder="Ingrese la facturación anual de la empresa...">
    
            </div>

        </div>

        <div class="contenido">
            <label for=""> Areas: </label>
        </div>
            
        <div style="display: flex; gap: 10px;">
            <select id="disponibles" multiple>
                <option value="opcion1">Opción 1</option>
                <option value="opcion2">Opción 2</option>
                <option value="opcion3">Opción 3</option>
                <option value="opcion4">Opción 4</option>
            </select>
            
            <select id="seleccionadas" multiple></select>
            
        </div>
        <div>
            <button class="boton" onclick="mover('disponibles', 'seleccionadas')">→</button>
            <input class="boton" type="submit" value="Crear Area">
            <button class="boton" onclick="mover('seleccionadas', 'disponibles')">←</button>
         </div>

        <div class="contenido">
            <label for=""> Paises: </label>
        </div>
        

        <div style="display: flex; gap: 10px;">
            <select id="PaisesDisponibles" multiple>
                <option value="opcion1">Opción 1</option>
                <option value="opcion2">Opción 2</option>
                <option value="opcion3">Opción 3</option>
                <option value="opcion4">Opción 4</option>
            </select>
            
            <select id="PaisesSeleccionados" multiple></select>
        </div>

        <div> 
            <button class="boton" onclick="mover('PaisesDisponibles', 'PaisesSeleccionados')">→</button>
            <input class="boton" type="submit" value="Crear Pais">
            <button class="boton" onclick="mover('PaisesSeleccionados', 'PaisesDisponibles')">←</button>
        </div>



        <div class="contenido">
            <div class="input_group">

                <label for="sedeCentral"> Sede Central: </label>

                <select  name="sedeCentral" size="1">
                    <option selected hidden> Elija una sede...</option>
                    <c:forEach var="option" items="${comboBoxOptions}">
                        <option value="${option}"> </option>
                    </c:forEach>
                </select>

                <input class="boton" type="submit" value="Crear Pais">

            </div>


        </div>

        <div>

            <form method="get" action="#">
    
                <input class="boton" type="submit" value="Cancelar y Cerrar">
                <input class="boton" type="button"  type="submit" value="Aceptar y Crear">
    
            </form>
          
       
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
