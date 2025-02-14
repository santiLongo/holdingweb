<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>Vendedor Holding</title>
    </head>
    <body>

    <div class="contenedor">
            
        <div class="cabecera">
            <h2>Bienvenido Vendedor ${usuario.nombre}</h2>
        </div>
         
        <div class="contenido">
            
            <div class="muestra"  class="muestra" id="artCodigo">
                <label for="">Su codigo de vendedor es: </label>
                <span>${usuario.id}</span>
            </div>


            <div class="muestra" >
                <label for="">Su direccion es: </label>
                <span> ${usuario.direccion} </span>
            </div>

            <div class="muestra"  id="artFecha">
                <label for="">Inicio actividades la fecha: </label>
                <span> ${usuario.fechaDeEntrada} </span>
            </div>

            <div class="muestra"  id="artEmpresa">
                <label for=""> Trabaja para la empresa: </label>
                <span>${usuario.empresa.nombre}</span>
            </div>

            <div class="muestra"  id="artLider">
                <c:choose>
                    <c:when test = "${usuario.lider.id == 0}">
                        <label for="">No tiene lider.</label>
                    </c:when>
                    <c:otherwise>
                        <label for="">Su lider es:</label>
                        <span>${usuario.lider.nombre}</span>
                    </c:otherwise>
                </c:choose>
            </div>

            <div class="muestra"  id="artReclutas">
                <c:choose>
                    <c:when test = "${empty usuario.reclutas}">
                        <label for="">No tiene reclutas.</label>
                    </c:when>
                    <c:otherwise>
                        <label for="">Sus reclutas son:</label>
                        <c:forEach var="recluta" items="${usuario.reclutas}">
                            <p>
                                ${recluta.nombre}
                            </p>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>

           

        </div>
        
        <form method="get" action="/"> 
            <input class="boton" type="submit" value="Cerrar Sesion">
        </form>
        
        
    </div>

    
</body>
</html>
