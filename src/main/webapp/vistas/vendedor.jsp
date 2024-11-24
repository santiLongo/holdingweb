<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Vendedor Holding</title>
    </head>
    <body>
        <h1>Bienvenido ${usuario.nombre}</h1>
        <h4>
            Su codigo de vendedor es: ${usuario.codigo} <br>
            Direccion: ${usuario.direccion} <br>
            Inicio actividades la fecha: ${usuario.fechaEntrada} <br>
            Trabaja para la empresa: ${usuario.idEmpresa} 
            <c:choose>
                <c:when test = "${usuario.getIdLider() == 0}">
                    <h4>
                        No tiene lider.
                    </h4>
                </c:when>
                <c:otherwise>
                    <h4>
                        Su lider es: ${usuario.idLider}
                    </h4>
                </c:otherwise>
            </c:choose>
            <c:choose>
                <c:when test = "${empty usuario.reclutas}">
                    <h4>
                        No tiene reclutas.
                    </h4>
                </c:when>
                <c:otherwise>
                    <h4>
                        Sus reclutas son:
                    </h4>
                    <c:forEach var="recluta" items="${usuario.reclutas}">
                        <p>${recluta.nombre}</p> <!-- Asegúrate de que `nombre` es un atributo de Recluta -->
                    </c:forEach>
                </c:otherwise>
            </c:choose>
        </h4>
        <form method="get" action="/"> 
            <input type="submit" value="Cerrar Sesion">
        </form>
    </body>
</html>
