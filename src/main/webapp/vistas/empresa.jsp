<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>Empresa</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>${empresa.getNombre()}</h2>
            </div>
            <div class="contenido">
                <div class="muestra">
                    <label>Facturación:</label>
                    <span>${empresa.getFacturacion()*1000000}</span>
                </div>
                <div class="muestra">
                    <label>Fecha de entrada:</label>
                    <span>${empresa.getFechaDeEntrada()}</span>
                </div>
                <div class="muestra">
                    <label>Pais Sede:</label>
                    <span>${empresa.getSedeCentral().getNombre()}</span>
                </div>
                <div class="muestra">
                    <label>Cantidad de Vendedores:</label>
                    <span>${empresa.getCantVendedores()}</span>
                </div>
                <div class="muestra">
                    <label>Paises:</label>
                    <c:forEach var="pais" items="${empresa.getPaises()}">
                        <form method="get" action="/pais"> 
                            <input type="hidden" name="idPais" value="${pais.getId()}">
                            <input class="boton" type="submit" value="${pais.getNombre()}">
                        </form>
                    </c:forEach>
                </div>
                <div class="muestra">
                    <label>Areas:</label>
                    <c:forEach var="area" items="${empresa.getAreas()}">
                        <form method="get" action="/area"> 
                            <input type="hidden" name="idArea" value="${area.getId()}">
                            <input class="boton" type="submit" value="${area.getNombre()}">
                        </form>
                    </c:forEach>
                </div>
            </div>
            <input class="boton" type="button" onclick="window.history.back();" value="Salir">
        </div>
    </body>
</html>
