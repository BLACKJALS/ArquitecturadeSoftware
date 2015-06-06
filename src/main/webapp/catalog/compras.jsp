<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Compras</title>
    </head>
    <body>
        <html>
    <head>
<body BGCOLOR=003366>
  <font color="White">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista de compras</title>
    </head>
    <body>
        <h1><center>Lista de compras</h1>
<center><section class="webdesigntuts-workshop">
	<form action="" method="">		    
		<input type="Buscar" placeholder="Buscar...">		    	
		<button>Buscar</button>
	</form>
</center>
</section>
        <table>
            <thead>

                <tr>

                 
                    <th><font color="White">Id producto</th>
                    <th><font color="White">Usuario</th>
                    <th><font color="White">Id compra</th>
                   
                </tr>
            </thead>
            <tbody>

                <!-- Here the productList variable used in items is the same name 
                used when storing the result in the ListProducts command class-->
                <c:forEach items="${compraList}" var="compra">
                    <tr>
                        <!-- Here we use the product variable defined in the for each loop-->
                        <td><c:out value="${compra.Idproducto}"></c:out></td>
                        <td><c:out value="${compra.usuario}"></c:out></td>
                        <td><c:out value="${compra.Idcompra}"></c:out></td>
                    </tr>
                </c:forEach>

            </tbody>
        </table>
        </font>
<meta charset="">




<canvas height="800px" width="900px" id="micanvas">
Su navegador no soporta en elemento CANVAS</canvas>

<script>
var canvas = document.getElementById("micanvas");
var ctx = canvas.getContext("2d");

ctx.fillStyle="#A9D0F5";
ctx.fillRect(220,10,1200,750);
</script>

<br/><br/>
<hr>
    </body>
</html>
        
