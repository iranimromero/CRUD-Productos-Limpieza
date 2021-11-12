<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Eliminar Producto</title>
</head>
<body>
	<h1>Eliminar Producto</h1>
	
	 <form action="EliminarProducto" method="POST"> <!--Aqui sucede la magia de conexion con el servlet-->
	 	<input type="hidden" value="${id}" name="id"> <!-- Parametro oculto que le pasamos del producto a modificar -->
	 	<button type="submit">Eliminar</button>
	 </form>
	 
	 <br><a href="PaginaInicio">Volver al Inicio</a>
</body>
</html>