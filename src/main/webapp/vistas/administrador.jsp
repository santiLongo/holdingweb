<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css"> 
        <title>Administrador Holding</title>
    </head>
    <body>

        <div class="cajaAdmin">
            <h2 class="pres">Bienvenido Administrador ${usuario.getUsuario()}</h2>
            <div class = "options">
                <form method="get" action="/inicio/altaVendedor">
                    <input class="boton" type="submit" value="Agregar Vendedor">
                </form>

                <form method="get" action="/inicio/altaAsesor">
                    <input class="boton" type="submit" value="Agregar Asesor">
                </form>

                <form method="get" action="/inicio/altaEmpresa">
                    <input class="boton" type="submit" value="Agregar Empresa">
                </form>
                
                <form method="get" action="/inicio/altaArea">
                    <input class="boton" type="submit" value="Agregar Area">
                </form>

                <form method="get" action="/inicio/altaPais">
                    <input class="boton" type="submit" value="Agregar Pais">
                </form>

                <form method="get" action="/">
                    <input class="boton" type="submit" value="Salir">
                </form>
                
            </div>
        </div>
        
    </body>
</html>
