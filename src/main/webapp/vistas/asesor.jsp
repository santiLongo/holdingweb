<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
            <h2>Bienvenido Asesor ${usuario.nombre}</h2>
        </div>

        <div class="contenido">
                
            <div class="muestra" id="artCodigo">
                <label for="">Su codigo de Asesor es: </label>
                <span> ${usuario.id} </span>
            </div>

            <div class="muestra" id="artDireccion">
                <label for="">Su direccion es: </label>
                <span> ${usuario.direccion} </span>
            </div>

            <div class="muestra" id="artEmpresa">
                <label for=""> Trabaja para la empresa: </label>
                <span>${usuario.empresa.nombre}</span>
            </div>

            <div class="muestra" id="artEmpresa">
                <c:choose>
                    <c:when test = "${usuario.empresa.id == 0}">
                        <label for="">No tiene Empresas asignadas.</label>
                    </c:when>
                    <c:otherwise>
                        <label for="">Empresas:</label>
                        <c:forEach var="empresa" item="${usuario.empresas}">
                            <p>
                                ${usuario.empresa.nombre} | Fecha   
                            </p>
                        </c:forEach>
                    </c:otherwise>
                </c:choose>
            </div>


            <div class="muestra" id="artReclutas">
                <c:choose>
                    <c:when test = "${empty usuario.areas.id} == 0">
                        <label for="">No tiene Areas asignadas.</label>
                    </c:when>
                    <c:otherwise>
                        <label for="">Areas:</label>
                        <c:forEach var="area" items="${usuario.area}">
                            <p>
                                ${area.nombre}
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
