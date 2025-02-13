<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/style.css"> 
        <title>Administrador Holding</title>
    </head>
    <body>

        <div class="contenedor">
            <h2>Bienvenido Administrador ${usuario.getUsuario()}</h2>
            <div class = "options">
                <form method="get" action="/agregarVendedor">
                    <input class="acceder" value="Agregar Vendedor">
                </form>

                <form method="get" action="/agregarAsesir">
                    <input class="acceder" type="submit" value="Agregar Asesor">
                </form>

                <form method="get" action="/inicio/altaEmpresa">
                    <input class="acceder" type="submit" value="Agregar Empresa">
                </form>

                <form method="get" action="/inicio/altaPais">
                    <input class="acceder" type="submit" value="Agregar Pais">
                </form>

                <form method="get" action="/">
                    <input class="acceder" type="submit" value="Salir">
                </form>
                
            </div>
        </div>
        
    </body>
</html>
