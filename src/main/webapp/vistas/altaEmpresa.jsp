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
            <form method="post" action="/inicio/altaEmpresa">
                <div class="contenido">
                    <div class="input_group">
                        <label for="nombre"> Razon Social: </label>
                        <input class="barra_texto" type="text" id="nombre" name="nombre"  placeholder="Ingrese la razon social de la empresa...">
                    </div>
                    <div class="input_group">
                        <label for="facturacion"> Facturación: </label>
                        <input class="barra_texto" type="text" id="facturacion" name="facturacion"  placeholder="Ingrese la facturación anual de la empresa...">
                    </div>
                </div>
                <div class="contenido">
                    <label for=""> Areas: </label>
                </div>
                <div style="display: flex; gap: 10px;">
                    <select id="areasDisponibles" multiple>
                        <c:forEach var="area" items="${areas}">
                            <option value="${area.getId()}">${area.nombre}</option>
                        </c:forEach>
                    </select>
                    <select id="areasSeleccionadas" name="areas" multiple></select>
                </div>
                <div>
                    <button class="boton" type="button" onclick="mover('areasDisponibles', 'areasSeleccionadas')">→</button>
                    <input class="boton" type="submit" value="Crear Area">
                    <button class="boton" type="button" onclick="mover('areasSeleccionadas', 'areasDisponibles')">←</button>
                </div>
                <div class="contenido">
                    <label for=""> Paises: </label>
                </div>
                <div style="display: flex; gap: 10px;">
                    <select id="PaisesDisponibles" multiple>
                        <c:forEach var="pais" items="${paises}">
                            <option value="${pais.getId()}"> ${pais.nombre} </option>
                        </c:forEach>
                    </select>
                    <select id="PaisesSeleccionados"name="paises" multiple></select>
                </div>
                <div> 
                    <button class="boton" type="button" onclick="mover('PaisesDisponibles', 'PaisesSeleccionados')">→</button>
                    <input class="boton" type="button" value="Crear Pais">
                    <button class="boton" type="button" onclick="mover('paisesSeleccionados', 'paisesDisponibles')">←</button>
                </div>
                <div class="contenido">
                    <div class="input_group">
                        <label for="sedeCentral"> Sede Central: </label>
                        <select  id="sedeCentral" name="sedeCentral" size="1">
                            <option selected hidden> Elija una sede...</option>
                            <c:forEach var="pais" items="${paises}">
                                <option value="${pais.getId()}"> ${pais.nombre} </option>
                            </c:forEach>
                        </select>
                        <input class="boton" type="button" value="Crear Pais">
                    </div>
                </div>
                <div>
                    <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
                    <input class="boton" type="submit"  type="submit" value="Aceptar y Crear">
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
