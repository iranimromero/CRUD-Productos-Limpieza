<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<!-- Bootstrap CSS V5-->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">

<title>Agregar Producto</title>
</head>
<body>

<section class="container">
    <form action="AgregarProducto" method="POST"> <!--Aqui sucede la magia de conexion con el servlet-->
        <div class="mb-3">
          <label for="nombreProducto" class="form-label">Nombre Producto</label>
          <input type="text" class="form-control" id="nombreProducto" name="nombreProducto">
        </div>
        <div class="mb-3">
            <label for="precioProducto" class="form-label">Precio Producto</label>
            <input type="number" class="form-control" id="precioProducto" name="precioProducto">
        </div>
        <div class="mb-3">
          <label for="descripcionProducto" class="form-label">Descripcion Producto</label>
          <input type="text" class="form-control" id="descripcionProducto" name="descripcionProducto">
        </div>
        
      <div class="mb-3">
            <label for="categoria" class="form-label">Categoria</label>
            <select name="categoriaProducto" id="listaCategorias">
                <c:forEach items="${listaCategorias}" var="listaTemp">
                    <option value="${listaTemp.getIdCategoria()}">${listaTemp.getNombreCategoria()}</option>    
                </c:forEach>
            </select>
        </div>
      <button type="submit" class="btn btn-primary">Agregar</button>
      
      </form>
     </section>
    
    <a href="PaginaInicio">volver al inicio</a>
    
     <!-- Popper-->
    <script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.9.2/dist/umd/popper.min.js" integrity="sha384-IQsoLXl5PILFhosVNubq5LC7Qb9DXgDA9i+tQ8Zj3iwWAwPtgFTxbJ8NT4GN1R8p" crossorigin="anonymous"></script>
    <!-- Java Script Bootstrap-->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.min.js" integrity="sha384-cVKIPhGWiC2Al4u+LWgxfKTRIcfu0JTxR+EQDz/bgldoEyl4H0zUF0QKbrJ0EcQF" crossorigin="anonymous"></script>
    

</body>
</html>