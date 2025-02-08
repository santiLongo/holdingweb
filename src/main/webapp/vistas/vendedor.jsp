<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/estilo.css">
        <title>Vendedor Holding</title>
    </head>
    <body>
        <div id="container">
            <header>
                <h1>
                    Bienvenido ${usuario.nombre}
                </h1>
            </header>
            
                
            <section id="contenido">
                <article id="artCodigo">
                    <h2>
                        Su codigo de vendedor es:
                    </h2>
                    <p>
                        ${usuario.id}
                    </p>
                </article>
                <article id="artDireccion">
                <h2>
                    Su direccion es: 
                </h2>
                <p>
                     ${usuario.direccion}
                </p>
                </article>
                <article id="artFecha">
                    <h2>
                        Inicio actividades la fecha: 
                    </h2>
                    <p>
                        ${usuario.fechaDeEntrada}
                    </p>
                </article>
                <article id="artEmpresa">
                <h2>
                    Trabaja para la empresa: 
                </h2>
                <p>
                    ${usuario.empresa.nombre}
                </p>
                </article>
                <article id="artLider">
                    <c:choose>
                        <c:when test = "${usuario.lider.id == 0}">
                            <h2>
                                No tiene lider.
                            </h2>
                        </c:when>
                        <c:otherwise>
                            <h2>
                                Su lider es:
                            </h2>
                            <p>
                                ${usuario.lider.nombre}
                            </p>
                        </c:otherwise>
                    </c:choose>
                </article>
                <article id="artReclutas">
                    <c:choose>
                        <c:when test = "${empty usuario.reclutas}">
                            <h2>
                                No tiene reclutas.
                            </h2>
                        </c:when>
                        <c:otherwise>
                            <h2>
                                Sus reclutas son:
                            </h2>
                            <c:forEach var="recluta" items="${usuario.reclutas}">
                                <p>
                                    ${recluta.nombre}
                                </p>
                            </c:forEach>
                        </c:otherwise>
                    </c:choose>
                </article>
            </section>
            <form method="get" action="/"> 
                <input type="submit" value="Cerrar Sesion">
            </form>
        </div>
    </body>
</html>
