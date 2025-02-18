<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css"> 
    <title>HOLDING WEB</title> 
  </head> 
   <body>
        
        <div class="cajaAdmin">

            <h2 class="presentación">Holding Web</h2>

            <form method="post" action="/inicio"> 

                <div class="input_group">
                    <label class="datos" for="text"> Usuario:</label>
                    <input class="barra_texto" type="text" id="usuario" name="usuario" placeholder="Ingrese un usuario...">
                </div>

                <div class="input_group">
                    <label for="text"> Contrasenia:</label>
                    <input class="barra_texto" type="password" id="contrasenia" name="contrasenia" placeholder="Ingrese una contraseña..."> <br><br>
                </div>

                <br>

                <input class="boton" type="submit" value="Acceder">
            </form>
        
        </div>

    </body>
</html> 
