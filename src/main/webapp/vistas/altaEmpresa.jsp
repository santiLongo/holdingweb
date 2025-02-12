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

           

            <div class="input_group">

                <label for="areas"> Areas: </label>

                <select class="selArea" name="areas" multiple>
                    <c:forEach var="area" items="${areas}">
                        <option value="${area}">${area.nombre}</option>
                    </c:forEach>
                </select>

                <input class="boton" type="submit" value="Crear Area">

            </div>

            <div class="input_group">

                <label for="paises"> Paises: </label>

                <select  name="paises" multiple>
                    <c:forEach var="pais" items="${paises}">
                        <option value="${pais}"> ${pais.getNombre()}</option>
                    </c:forEach>
                </select>

                <input class="boton" type="submit" value="Crear Pais">

            </div>
           
            <div class="input_group">

                <label for="sedeCentral"> Sede Central: </label>

                <select  name="sedeCentral" size="1">
                    
                    <c:forEach var="pais" items="${paises}">
                        <option value="${pais}"> ${pais.nombre} </option>
                    </c:forEach>
                </select>

                <input class="boton" type="submit" value="Crear Pais">

            </div>


        </div>

        <div>
       <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
       
        <form method="post" action="/inicio/altaEmpresa">
            <input class="boton" type="submit" value="Aceptar y Crear">
        </form>
        </div>

    </div>

</body>
</html>
