<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="/resources/css/EstiloCrear.css">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="contenedor">
            <div class="cabecera">
                <h2>Agregar Vendedor</h2>
            </div>
            <form method="post" action="/inicio/altaVendedor">
            <div class="contenido">
                <div class="input_group">
                    <label for="usuario"> Usuario: </label>
                    <input class="barra_texto" type="text" id="usuario" name="usuario" placeholder="Ingrese el usuario del vendedor...">
                </div>
                <div class="input_group">
                    <label for="contrasenia"> Contrasenia: </label>
                    <input class="barra_texto" type="text" id="contrasenia" name="contrasenia" placeholder="Ingrese el contrasenia del vendedor...">
                </div>
                <div class="input_group">
                    <label for="nombreVendedor"> Nombre: </label>
                    <input class="barra_texto" type="text" id="nombre" name="nombre" placeholder="Ingrese el nombre del vendedor...">
                </div>
                <div class="input_group">
                    <label for="direccion"> Dirección: </label>
                    <input class="barra_texto" type="text" id="direccion" name="direccion" placeholder="Ingrese la direccion del vendedor...">
                </div>
                <div class="input_group">
                    <label for="EmpresaVendedor"> Empresa: </label>
                    <select id="empresaVendedor" name="empresa" size="1" >
                        <option selected hidden>Elija una empresa...</option>
                        <c:forEach var="empresa" items="${empresas}">
                            <option class="opcion" value="${empresa.getId()}"> ${empresa.nombre} </option>
                        </c:forEach>
                    </select>
                </div>
                <div class="input_group">
                    <label for="LiderVendedor"> Lider: </label>
                    <select id="liderVendedor"  name="lider" size="1">
                        <option selected hidden> Elija una lider</option>
                        <option class="opcion" value="">No tiene Lider</option>
                        <c:forEach var="lider" items="${vendedores}">
                            <option class="opcion" value="${lider.getId()}"> ${lider.nombre} </option>
                        </c:forEach>
                    </select>
                </div>
            </div>
            <div>
                <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
                <input class="boton" type="submit" value="Aceptar y Crear">     
            </div>
            </form>
        </div>
    </body>
</html>