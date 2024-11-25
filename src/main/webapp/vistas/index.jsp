<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" type="text/css" href="/resources/css/estilo.css"> 
    <title>HOLDING WEB</title> 
  </head> 
  <body> 
    <h1>
        HOLDING INSPT
    </h1>
    <form method="post" action="/inicio"> 
      <h2>Ingrese su usuario</h2>
      <input type="text" id="usuario" name="usuario">
      <h2>Ingrese su contrasenia</h2>
      <input type="text" id="contrasenia" name="contrasenia"> <br><br>
      <input type="submit" value="Acceder">
    </form>
    
  </body> 
</html> 
