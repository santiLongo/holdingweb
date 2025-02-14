<%-- 
    Document   : altaVendedor
    Created on : 13 feb. 2025, 23:46:24
    Author     : Rocco
--%>

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


        <div class="contenido">

            <div class="input_group">
                <label for="nombreVendedor"> Nombre: </label>
                <input class="barra_texto" type="text" id="nombreVendedor" placeholder="Ingrese el nombre del vendedor...">
            </div>

            <div class="input_group">
                <label for="direccion"> Dirección: </label>
                
                <input class="barra_texto" type="text" id="direccion" placeholder="Ingrese la direccion del vendedor...">
            </div>

            <div class="input_group">

                <label for="EmpresaVendedor"> Empresa: </label>

                <select  name="EmpresaVendedor" size="1" >
                    <option selected hidden>Elija una empresa...</option>
                    <c:forEach var="option" items="${comboBoxOptions}">
                        <option value="${option}"> </option>
                    </c:forEach>
                    
                </select>


            </div>

            <div class="input_group">

                <label for="LiderVendedor"> Lider: </label>

                <select  name="LiderVendedor" size="1">
                    <option selected hidden> Elija una lider</option>
                    <option value="null">No tiene Lider</option>
                    <c:forEach var="option" items="${comboBoxOptions}">
                        <option value="${option}"></option>
                    </c:forEach>
                    
                </select>
            </div>
            

        </div>

        <div>
            <input class="boton" type="button" onclick="window.history.back();" value="Cancelar y Cerrar">
            <input class="boton" type="submit" value="Aceptar y Crear">     
        </div>

    </div>
    
</body>
</html>
