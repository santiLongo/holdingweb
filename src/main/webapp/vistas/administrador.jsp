<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/sstyle.css"> 
        <title>Administrador Holding</title>
    </head>
    <body>
        <div class="contenedor">
            <h2>Bienvenido Administrador ${usuario.getUsuario()}</h2>
            <div class = "options">
                <a href="#"> Agregar Vendedor</a>
                <a href="#"> Agregar Asesor</a>
                <a href="#"> Agregar Empresa</a>
                <a href="#"> Agregar Pais</a>
                <a href="#"> Salir</a>
            </div>
        </div>
        
    </body>
</html>
