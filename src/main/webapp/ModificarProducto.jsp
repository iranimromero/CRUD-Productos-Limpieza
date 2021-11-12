<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS V5-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
<title>Modificar Producto</title>
</head>
<body>
<h1>Modificar Producto</h1>

<section class="container">
 <form action="ModificarProducto" method="POST"> <!--Aqui sucede la magia de conexion con el servlet-->
        <input type="hidden" value="${producto.getIdProducto()}" name="idProducto"> <!-- Parametro oculto que le pasamos del producto a modificar -->
        <div class="mb-3">
          <label for="nombreProducto" class="form-label">Nombre Producto</label>
          <input type="text" class="form-control" id="nombreProducto" name="nombreProducto" value="${producto.getNombreProducto()}">
        </div>
        <div class="mb-3">
            <label for="precioProducto" class="form-label">Precio Producto</label>
            <input type="number" class="form-control" id="precioProducto" name="precioProducto" value="${producto.getPrecioProducto()}">
        </div>
        <div class="mb-3">
          <label for="descripcionProducto" class="form-label">Descripcion Producto</label>
          <input type="text" class="form-control" id="descripcionProducto" name="descripcionProducto" value="${producto.getDescripcionProducto()}">
        </div>
        
      <div class="mb-3">
            <label for="categoria" class="form-label">Categoria</label>
            <select name="listaCategorias" id="listaCategorias">
                <c:forEach items="${listaCategorias}" var="listaTemp">
                    <option value="${listaTemp.getIdCategoria()}" 
                    ${categoria.getIdProducto() == producto.getIdCategoria() ? ' selected' :'' }>
                    ${listaTemp.getNombreCategoria()}</option>    
                </c:forEach>
            </select>
        </div>
      <button type="submit" class="btn btn-primary">Modificar</button>
      
      </form>
</section>
	<a href="PaginaInicio">volver al inicio</a>
	
    <!-- Popper-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <!-- Java Script Bootstrap-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>

</body>
</html>