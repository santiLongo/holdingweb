<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>Asesor</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>Bienvenido Asesor ${usuario.getNombre()}</h2>
            </div>
            <div class="contenido">
                <div class="muestra" id="artCodigo">
                    <label for="">Su codigo de Asesor es: </label>
                    <span> ${usuario.getId()} </span>
                </div>
                <div class="muestra" id="artDireccion">
                    <label for="">Su direccion es: </label>
                    <span> ${usuario.getDireccion()} </span>
                </div>
                <div class="muestra" id="artEmpresa">
                    <label for="">Empresas:</label>
                    <c:forEach var="asesoramiento" items="${usuario.getAsesoramientos()}">
                        <p>
                            ${asesoramiento.getEmpresa().getNombre()}       |       ${asesoramiento.getFechaDeEntrada()}
                        </p>
                        <form method="get" action="/empresa"> 
                            <input type="hidden" name="idEmpresa" value="${asesoramiento.getEmpresa().getId()}">
                            <input class="boton" type="submit" value="Ver">
                        </form>
                    </c:forEach>
                </div>
                <div class="muestra" id="artAreas">
                    <label for="">Areas:</label>
                    <c:forEach var="area" items="${usuario.getAreas()}">
                        <form method="get" action="/area"> 
                            <input type="hidden" name="idArea" value="${area.getId()}">
                            <input class="boton" type="submit" value="${area.getNombre()}">
                        </form>
                    </c:forEach>
                </div>
            </div>
            <form method="get" action="/"> 
                <input class="boton" type="submit" value="Cerrar Sesion">
            </form>
        </div>
    </body>
</html>
