<%@page contentType="text/html" pageEncoding="UTF-8" %> 
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
<!DOCTYPE html> 
<html> 
  <head> 
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
    <link rel="stylesheet" type="text/css" href="/resources/css/estilo.css"> 
    <link rel="icon" type="image/x-icon" href="/resources/img/favicon.ico"> 
    <link rel="shortcut icon" type="image/x-icon" href="/resources/img/favicon.ico"> 
    <title>HOLDING WEB</title> 
  </head> 
  <body> 
    <h1>HOLDING INSPT</h1>
    <form method="post" action="/inicio"> 
      <h3>Ingrese su usuario</h3>
      <textarea name="usuario" id="1"></textarea>
      <h3>Ingrese su contrasenia</h3>
      <textarea name="contrasenia" id="2"></textarea>
      <h4></h4>
      <input type="submit" value="Acceder">
    </form>
    
  </body> 
</html> 
