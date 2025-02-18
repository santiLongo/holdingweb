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
            <h2>${empresa.nombre}</h2>
        </div>

        <div class="contenido">

            <div class="muestra">
                <label>Facturación:</label>
                <span>${empresa.facturacion}</span>
            </div>

            <div class="muestra">
                <label>Fecha de entrada:</label>
                <span>${empresa.fechaDeEntrada}</span>
            </div>
            <div class="muestra">
                <label>Pais Sede:</label>
                <span>${empresa.paisSede}</span>
            </div>

            <div class="muestra">
                <label>Cantidad de Vendedores:</label>
                <span>${empresa.cantVendedores}</span>
            </div>

            <div class="input_group">

                <div class="muestra">
                    <label>Paises:</label>
                    <c:forEach var="pais" items="${empresa.paises()}">
                            <p>
                                ${pais.nombre}
                            </p>
                    </c:forEach>
                </div>
    
                <div class="muestra">
                    <label>Areas:</label>
                    <c:forEach var="area" items="${empresa.areas()}">
                            <p>
                                ${area.nombre} | ${area.descripcion}
                            </p>
                    </c:forEach>
                </div>

            </div>


        </div>

        <input class="boton" type="button" onclick="window.history.back();" value="Cancelar">

    </div>
    
</body>
</html>
