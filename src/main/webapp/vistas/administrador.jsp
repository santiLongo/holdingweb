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
                <form action="get" action="/agregarVendedor">
                    <input type="submit" value="Agregar Vendedor">
                </form>

                <form action="get" action="/agregarAsesir">
                    <input class="acceder" type="submit" value="Agregar Asesor">
                </form>

                <form action="get" action="/agregarEmpresa">
                    <input class="acceder" type="submit" value="Agregar Empresa">
                </form>

                <form action="get" action="/agregarPais">
                    <input class="acceder" type="submit" value="Agregar Pais">
                </form>

                <form action="post" action="/">
                    <input class="acceder" type="submit" value="Salir">
                </form>
                
            </div>
        </div>
        
    </body>
</html>
