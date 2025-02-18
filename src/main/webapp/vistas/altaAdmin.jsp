<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Dar de alta administrador</title>
    </head>
    <body>

        <div class="contenedor">
            <h1 class="pres">Aun no existe un administrador</h1>
        <form method="post" action="/">

            <div class="input_group">

                <label>Usuario:</label>
                <input class="barra_texto" type="text" id="usuarioAdmin" name="usuarioAdmin" placeholder="Ingrese el usuario del administrador..."><br>

            </div>

            <br>
            
            <div class="input_group">

                <label>Contrseña:</label>
                <input class="barra_texto" type="text" id="contraseniaAdmin" name="contraseniaAdmin" placeholder="Ingrese la contraseña del administrador...">
            
            </div>
        
            <br>
        
            <input class="boton" type="submit" value="Aceptar y Crear">
            
        </form>

        </div>
        
    </body>
</html>
