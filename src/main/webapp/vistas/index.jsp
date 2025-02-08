<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" type="text/css" href="/resources/css/style.css"> 
    <title>HOLDING WEB</title> 
  </head> 
   <body>
        
        <div class="contenedor">
            <h2>Holdig Web</h2>
            <form method="post" action="/inicio"> 
                <div class="form-group">
                    <label class="datos" for="text"> Usuario:</label>
                    <input type="text" id="usuario" name="usuario" placeholder="Ingrese un usuario...">
                </div>
                <div class="form-group">
                    <label for="text"> Contrasenia:</label>
                    <input class="datos" type="text" id="contrasenia" name="contrasenia" placeholder="Ingrese una contraseña..."> <br><br>
                </div>
                <input class="acceder" type="submit" value="Acceder">
                </form>
        
        </div>
    </body> 
</html> 
